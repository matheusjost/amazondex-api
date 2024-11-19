package br.unisc.amazondex.service;

import br.unisc.amazondex.command.PaisagismoCommand;
import br.unisc.amazondex.entity.Arvore;
import br.unisc.amazondex.entity.Paisagismo;
import br.unisc.amazondex.repository.PaisagismoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaisagismoService {

    private final PaisagismoRepository paisagismoRepository;
    private final PaisagismoFotoService paisagismoFotoService;

    public void salvarPaisagismo(PaisagismoCommand cmd, Arvore arvore) {
        if (cmd == null) {
            return;
        }

        Paisagismo paisagismo = new Paisagismo();
        paisagismo.setDescricao(cmd.getDescricao());
        paisagismo.setArvore(arvore);

        if (cmd.getId() != null) {
            paisagismo.setId(cmd.getId());
        }

        paisagismo = paisagismoRepository.save(paisagismo);
        salvarPaisagismoCompleto(cmd, paisagismo);
    }

    private void salvarPaisagismoCompleto(PaisagismoCommand cmd, Paisagismo paisagismo) {
        paisagismoFotoService.salvarPaisagismoFoto(cmd.getPaisagismoFotoCommand(), paisagismo);
    }

}
