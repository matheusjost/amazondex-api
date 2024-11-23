package br.unisc.amazondex.controller;

import br.unisc.amazondex.command.ArvoreCommand;
import br.unisc.amazondex.entity.Arquivo;
import br.unisc.amazondex.exception.AmazondexException;
import br.unisc.amazondex.pojo.ApiResponseDTO;
import br.unisc.amazondex.service.ArquivoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequiredArgsConstructor
@RequestMapping("/arquivo")
public class ArquivoController extends AmazondexController<ArvoreCommand> {

    private final ArquivoService arquivoService;

    @Override
    @Operation(summary = "Upload de arquivo")
    public ResponseEntity<ApiResponseDTO> upload(@RequestParam("file") MultipartFile file) {
        try {
            String path = arquivoService.armazenarArquivo(file);
            Arquivo arquivo = arquivoService.salvar(path, getUsuario());

            return ResponseHandler.createdApiResponse(arquivo.getId());
        } catch (Exception e) {
            return ResponseHandler.errorApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Override
    @Operation(summary = "Buscar view de arquivo por ID")
    public ResponseEntity<byte[]> view(@PathVariable String id) {
        try {
            String caminho = arquivoService.get(Integer.valueOf(id)).getCaminho();
            Path path = Path.of(caminho);

            if (!Files.exists(path)) {
                throw new AmazondexException("Arquivo não existe.");
            }

            String mt = Files.probeContentType(path);
            return ResponseHandler.okApiResponse(mt, Files.readAllBytes(path));
        } catch (Exception ex) {
            return null;
        }
    }

}
