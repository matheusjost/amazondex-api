package br.unisc.amazondex.service;

import br.unisc.amazondex.command.BiotecnologiaCommand;
import br.unisc.amazondex.entity.Aproveitamento;
import br.unisc.amazondex.entity.Biotecnologia;
import br.unisc.amazondex.repository.BiotecnologiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BiotecnologiaService {

    private final BiotecnologiaRepository biotecnologiaRepository;

    public void salvarBiotecnologia(BiotecnologiaCommand cmd, Aproveitamento aproveitamento) {
        if (cmd == null) {
            return;
        }

        Biotecnologia biotecnologia = new Biotecnologia();
        biotecnologia.setAproveitamento(aproveitamento);
        biotecnologia.setComposicao(cmd.composicao());
        biotecnologia.setPotenciaBioprodutos(cmd.potenciaBioprodutos());

        if (cmd.id() != null) {
            biotecnologia.setId(cmd.id());
        }
        biotecnologiaRepository.save(biotecnologia);
    }
}
