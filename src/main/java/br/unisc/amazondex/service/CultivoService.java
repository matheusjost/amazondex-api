package br.unisc.amazondex.service;

import br.unisc.amazondex.command.CultivoCommand;
import br.unisc.amazondex.entity.Arvore;
import br.unisc.amazondex.entity.Cultivo;
import br.unisc.amazondex.repository.CultivoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CultivoService {

    private final CultivoRepository cultivoRepository;
    private final CuidadosEspeciaisService cuidadosEspeciaisService;

    public void salvarCultivo(CultivoCommand cmd, Arvore arvore) {
        if (cmd == null) {
            return;
        }

        Cultivo cultivo = new Cultivo();
        cultivo.setArvore(arvore);
        cultivo.setDescricao(cmd.getDescricao());

        if (cmd.getId() != null) {
            cultivo.setId(cmd.getId());
        }
        cultivo = cultivoRepository.save(cultivo);

        salvarCultivoCompleto(cmd, cultivo);
    }

    private void salvarCultivoCompleto(CultivoCommand cmd, Cultivo cultivo) {
        cuidadosEspeciaisService.salvarCuidadosEspeciais(cmd.getCuidadosEspeciaisCommand(), cultivo);
    }
}
