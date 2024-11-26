package br.unisc.amazondex.service;

import br.unisc.amazondex.command.CuidadosEspeciaisCommand;
import br.unisc.amazondex.entity.CuidadosEspeciais;
import br.unisc.amazondex.entity.Cultivo;
import br.unisc.amazondex.repository.CuidadosEspeciaisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CuidadosEspeciaisService {

    private final CuidadosEspeciaisRepository cuidadosEspeciaisRepository;

    public void salvarCuidadosEspeciais(CuidadosEspeciaisCommand cmd, Cultivo cultivo) {
        if (cmd == null) {
            return;
        }

        CuidadosEspeciais cuidadosEspeciais = new CuidadosEspeciais();
        cuidadosEspeciais.setTipoCuidado(String.valueOf(cmd.getTipoCuidado()));
        cuidadosEspeciais.setDescricao(cmd.getDescricao());
        cuidadosEspeciais.setCultivo(cultivo);

        if (cmd.getId() != null) {
            cuidadosEspeciais.setId(cmd.getId());
        }

        cuidadosEspeciaisRepository.save(cuidadosEspeciais);
    }

    public void salvarCuidadosEspeciais(List<CuidadosEspeciaisCommand> cmd, Cultivo cultivo) {
        if (cmd == null || cmd.isEmpty()) {
            return;
        }

        for (CuidadosEspeciaisCommand cuidadosEspeciaisCommand : cmd) {
            salvarCuidadosEspeciais(cuidadosEspeciaisCommand, cultivo);
        }
    }
}
