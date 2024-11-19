package br.unisc.amazondex.service;

import br.unisc.amazondex.command.PaisagismoFotoCommand;
import br.unisc.amazondex.entity.Arquivo;
import br.unisc.amazondex.entity.FotoArvore;
import br.unisc.amazondex.entity.Paisagismo;
import br.unisc.amazondex.entity.PaisagismoFoto;
import br.unisc.amazondex.exception.AmazondexException;
import br.unisc.amazondex.repository.PaisagismoFotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PaisagismoFotoService {

    private final PaisagismoFotoRepository paisagismoFotoRepository;
    private final ArquivoService arquivoService;

    public void salvarPaisagismoFoto(PaisagismoFotoCommand cmd, Paisagismo paisagismo) {
        if (cmd == null) {
            return;
        }

        try {
            Arquivo arquivo = arquivoService.get(cmd.fotoId());

            PaisagismoFoto paisagismoFoto = new PaisagismoFoto();
            paisagismoFoto.setPaisagismo(paisagismo);
            paisagismoFoto.setFoto(arquivo);

            if (cmd.id() != null) {
                paisagismoFoto.setId(cmd.id());
            }
            paisagismoFotoRepository.save(paisagismoFoto);
        } catch (NoSuchElementException e) {
            throw new AmazondexException("Arquivo não encontrado", e);
        } catch (Exception e) {
            throw new AmazondexException("Erro ao salvar foto da árvore", e);
        }
    }

}
