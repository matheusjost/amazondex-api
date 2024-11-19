package br.unisc.amazondex.service;

import br.unisc.amazondex.command.AproveitamentoCommand;
import br.unisc.amazondex.entity.Aproveitamento;
import br.unisc.amazondex.entity.Arvore;
import br.unisc.amazondex.repository.AproveitamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AproveitamentoService {

    private final AproveitamentoRepository aproveitamentoRepository;
    private final BiotecnologiaService biotecnologiaService;
    private final AlimentacaoService alimentacaoService;
    private final BioatividadeService bioatividadeService;

    public void salvarAproveitamento(AproveitamentoCommand cmd, Arvore arvore) {
        if (cmd == null) {
            return;
        }

        Aproveitamento aproveitamento = new Aproveitamento();
        aproveitamento.setArvore(arvore);
        aproveitamento.setDescricao(cmd.getDescricao());

        aproveitamentoRepository.save(aproveitamento);
        salvarAproveitamentoCompleto(cmd, aproveitamento);
    }

    private void salvarAproveitamentoCompleto(AproveitamentoCommand cmd, Aproveitamento aproveitamento) {
        biotecnologiaService.salvarBiotecnologia(cmd.getBiotecnologiaCommand(), aproveitamento);
        alimentacaoService.salvarAlimentacao(cmd.getAlimentacaoCommand(), aproveitamento);
        bioatividadeService.salvarBioatividade(cmd.getBioatividadeCommand(), aproveitamento);
    }
}
