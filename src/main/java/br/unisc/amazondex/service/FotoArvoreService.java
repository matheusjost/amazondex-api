package br.unisc.amazondex.service;

import br.unisc.amazondex.command.FotoArvoreCommand;
import br.unisc.amazondex.entity.Arquivo;
import br.unisc.amazondex.entity.Arvore;
import br.unisc.amazondex.entity.FotoArvore;
import br.unisc.amazondex.exception.AmazondexException;
import br.unisc.amazondex.repository.FotoArvoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FotoArvoreService {

    private final FotoArvoreRepository fotoArvoreRepository;

    private final ArquivoService arquivoService;

    public void salvarFotoArvore(FotoArvoreCommand cmd, Arvore arvore) {
        if (cmd == null) {
            return;
        }

        try {
            Arquivo arquivo = arquivoService.get(cmd.fotoId());

            FotoArvore fotoArvore = new FotoArvore();
            fotoArvore.setArvore(arvore);
            fotoArvore.setFoto(arquivo);
            fotoArvore.setDescricao(cmd.descricao());

            if (cmd.id() != null) {
                fotoArvore.setId(cmd.id());
            }
            fotoArvoreRepository.save(fotoArvore);

        } catch (NoSuchElementException e) {
            throw new AmazondexException("Arquivo não encontrado", e);
        } catch (Exception e) {
            throw new AmazondexException("Erro ao salvar foto da árvore", e);
        }
    }

    public void salvarFotoArvore(List<FotoArvoreCommand> cmd, Arvore arvore) {
        if (cmd == null || cmd.isEmpty()) {
            return;
        }

        for (FotoArvoreCommand fotoArvoreCommand : cmd) {
            salvarFotoArvore(fotoArvoreCommand, arvore);
        }
    }
}
