package br.unisc.amazondex.service;

import br.unisc.amazondex.command.AlimentacaoCommand;
import br.unisc.amazondex.entity.Alimentacao;
import br.unisc.amazondex.entity.Aproveitamento;
import br.unisc.amazondex.repository.AlimentacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlimentacaoService {

    private final AlimentacaoRepository alimentacaoRepository;

    public void salvarAlimentacao(AlimentacaoCommand cmd, Aproveitamento aproveitamento) {
        if (cmd == null) {
            return;
        }

        Alimentacao alimentacao = new Alimentacao();
        alimentacao.setAproveitamento(aproveitamento);
        alimentacao.setDadosNutricionais(cmd.dadosNutricionais());
        alimentacao.setFormasConsumo(cmd.formasConsumo());

        if (cmd.id() != null) {
            alimentacao.setId(cmd.id());
        }
        alimentacaoRepository.save(alimentacao);
    }
}
