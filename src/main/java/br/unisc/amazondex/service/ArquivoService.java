package br.unisc.amazondex.service;

import br.unisc.amazondex.entity.Arquivo;
import br.unisc.amazondex.entity.Usuario;
import br.unisc.amazondex.exception.AmazondexException;
import br.unisc.amazondex.repository.ArquivoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArquivoService {

    private final ArquivoRepository arquivoRepository;

    @Value("${br.unisc.amazondex.diretorio.entrada}")
    private String DIRETORIO_ENTRADA;

    public Arquivo get(Integer id) {
        return arquivoRepository.findById(id).orElseThrow();
    }

    public Arquivo salvar(Arquivo arquivo) {
        return arquivoRepository.save(arquivo);
    }

    public Arquivo salvar(String caminho, Usuario usuario) {
        Arquivo arquivo = new Arquivo();
        arquivo.setCaminho(caminho);
        arquivo.setUsuario(usuario);
        arquivo.setUploadedAt(new Date());

        return arquivoRepository.save(arquivo);
    }

    public String armazenarArquivo(MultipartFile file) {
        String originalFileName = file.getOriginalFilename();
        String filePath = getFilePath(originalFileName);
        File uploadedFile = new File(filePath);

        if(!uploadedFile.exists()) {
            try {
                File directory = uploadedFile.getParentFile();
                Files.createDirectories(directory.toPath());
                if (uploadedFile.createNewFile()) {
                    log.info("Armazenado com sucesso em: " + uploadedFile.getAbsolutePath());
                }

                try (FileOutputStream fop = new FileOutputStream(uploadedFile)) {
                    fop.write(file.getBytes());
                    fop.flush();
                }

            } catch (Exception e) {
                throw new AmazondexException("Erro ao salvar o arquivo: " + e.getMessage());
            }
        }

        return filePath;
    }

    private String getFilePath(String fileName) {
        String fileNameWithoutExtension = fileName.substring(0, fileName.lastIndexOf('.'));
        String fileExtension = fileName.substring(fileName.lastIndexOf('.'));

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String newFileName = fileNameWithoutExtension + "_" + timestamp + fileExtension;

        return DIRETORIO_ENTRADA + newFileName;
    }

}
