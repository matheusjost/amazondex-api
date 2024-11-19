package br.unisc.amazondex.service;

import br.unisc.amazondex.command.BiologiaReprodutivaCommand;
import br.unisc.amazondex.entity.Arvore;
import br.unisc.amazondex.entity.BiologiaReprodutiva;
import br.unisc.amazondex.repository.BiologiaReprodutivaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BiologiaReprodutivaService {

    private final BiologiaReprodutivaRepository biologiaReprodutivaRepository;

    public void salvarBiologiaReprodutiva(BiologiaReprodutivaCommand cmd, Arvore arvore) {
        if (cmd == null) {
            return;
        }

        BiologiaReprodutiva biologiaReprodutiva = new BiologiaReprodutiva();
        biologiaReprodutiva.setArvore(arvore);
        biologiaReprodutiva.setDescricao(cmd.descricao());

        if (cmd.id() != null) {
            biologiaReprodutiva.setId(cmd.id());
        }
        biologiaReprodutivaRepository.save(biologiaReprodutiva);
    }

}
