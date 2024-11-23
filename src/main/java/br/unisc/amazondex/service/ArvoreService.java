package br.unisc.amazondex.service;

import br.unisc.amazondex.command.ArvoreCommand;
import br.unisc.amazondex.entity.Arvore;
import br.unisc.amazondex.pojo.ArvoreDTO;
import br.unisc.amazondex.repository.*;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArvoreService {

    private final ArvoreRepository arvoreRepository;

    private final BiologiaReprodutivaService biologiaReprodutivaService;
    private final OcorrenciaNaturalService ocorrenciaNaturalService;
    private final FotoArvoreService fotoArvoreService;
    private final CultivoService cultivoService;
    private final PaisagismoService paisagismoService;
    private final AproveitamentoService aproveitamentoService;

    public ArvoreDTO buscarPorArvoreId(Integer arvoreId) {
        return arvoreRepository.findArvoreByIdWithAllRelations(arvoreId).orElseThrow(NoResultException::new);
    }

    public Arvore salvar(ArvoreCommand cmd) {
        Arvore arvore = new Arvore();
        arvore.setNome(cmd.nome());
        arvore.setDescricaoBotanica(cmd.descricaoBotanica());
        arvore.setAspectosEcologicos(cmd.aspectosEcologicos());
        arvore.setRegeneracaoNatural(cmd.regeneracaoNatural());

        if (cmd.id() != null) {
            arvore.setId(cmd.id());
        }

        arvore = arvoreRepository.save(arvore);
        salvarArvoreCompleto(cmd, arvore);

        return arvore;
    }

    private void salvarArvoreCompleto(ArvoreCommand cmd, Arvore arvore) {
        biologiaReprodutivaService.salvarBiologiaReprodutiva(cmd.biologiaReprodutivaCommand(), arvore);
        ocorrenciaNaturalService.salvarOcorrenciaNatural(cmd.ocorrenciaNaturalCommand(), arvore);
        fotoArvoreService.salvarFotoArvore(cmd.fotoArvoreCommand(), arvore);
        cultivoService.salvarCultivo(cmd.cultivoCommand(), arvore);
        paisagismoService.salvarPaisagismo(cmd.paisagismoCommand(), arvore);
        aproveitamentoService.salvarAproveitamento(cmd.aproveitamentoCommand(), arvore);
    }

    public void deletar(Integer id) {
        arvoreRepository.deleteById(id);
    }

}
