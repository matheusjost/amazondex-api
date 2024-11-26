package br.unisc.amazondex.service;

import br.unisc.amazondex.command.BioatividadeCommand;
import br.unisc.amazondex.entity.Aproveitamento;
import br.unisc.amazondex.entity.Bioatividade;
import br.unisc.amazondex.repository.BioatividadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BioatividadeService {

    private final BioatividadeRepository bioatividadeRepository;

    public void salvarBioatividade(BioatividadeCommand cmd, Aproveitamento aproveitamento) {
        if (cmd == null) {
            return;
        }

        Bioatividade bioatividade = new Bioatividade();
        bioatividade.setAproveitamento(aproveitamento);
        bioatividade.setDescricao(cmd.getDescricao());

        if (cmd.getId() != null) {
            bioatividade.setId(cmd.getId());
        }
        bioatividadeRepository.save(bioatividade);
    }

}
