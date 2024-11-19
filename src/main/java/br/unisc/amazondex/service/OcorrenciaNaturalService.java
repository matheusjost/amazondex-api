package br.unisc.amazondex.service;

import br.unisc.amazondex.command.OcorrenciaNaturalCommand;
import br.unisc.amazondex.entity.Arvore;
import br.unisc.amazondex.entity.OcorrenciaNatural;
import br.unisc.amazondex.repository.OcorrenciaNaturalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OcorrenciaNaturalService {

    private final OcorrenciaNaturalRepository ocorrenciaNaturalRepository;

    public void salvarOcorrenciaNatural(OcorrenciaNaturalCommand cmd, Arvore arvore) {
        if (cmd == null) {
            return;
        }

        OcorrenciaNatural ocorrenciaNatural = new OcorrenciaNatural();
        ocorrenciaNatural.setArvore(arvore);
        ocorrenciaNatural.setLatitude(cmd.latitude());
        ocorrenciaNatural.setLongitude(cmd.longitude());

        if (cmd.id() != null) {
            ocorrenciaNatural.setId(cmd.id());
        }
        ocorrenciaNaturalRepository.save(ocorrenciaNatural);
    }

    public void salvarOcorrenciaNatural(List<OcorrenciaNaturalCommand> cmd, Arvore arvore) {
        if (cmd == null || cmd.isEmpty()) {
            return;
        }

        for (OcorrenciaNaturalCommand ocorrenciaNaturalCommand : cmd) {
            salvarOcorrenciaNatural(ocorrenciaNaturalCommand, arvore);
        }
    }
}
