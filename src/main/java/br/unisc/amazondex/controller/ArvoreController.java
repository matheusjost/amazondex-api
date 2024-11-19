package br.unisc.amazondex.controller;

import br.unisc.amazondex.command.ArvoreCommand;
import br.unisc.amazondex.entity.Arvore;
import br.unisc.amazondex.pojo.ApiResponseDTO;
import br.unisc.amazondex.service.ArvoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/arvore")
public class ArvoreController extends AmazondexController<ArvoreCommand> {

    private final ArvoreService arvoreService;

    @Override
    public ResponseEntity<ApiResponseDTO> post(@RequestBody ArvoreCommand cmd) {
        try {
            Arvore arvore = arvoreService.salvar(cmd);
            return ResponseHandler.createdApiResponse(arvore.getId());
        } catch (Exception ex) {
            return ResponseHandler.errorApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @Override
    public ResponseEntity<ApiResponseDTO> get(@PathVariable String id) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponseDTO> listAll() {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponseDTO> delete(@PathVariable String id) {
        try {
            arvoreService.deletar(Integer.parseInt(id));
            return ResponseHandler.okApiResponse();
        } catch (Exception ex) {
            return ResponseHandler.errorApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @Override
    public ResponseEntity<ApiResponseDTO> put(@PathVariable String id, @RequestBody ArvoreCommand cmd) {
        try {
            Arvore arvore = arvoreService.salvar(cmd);
            return ResponseHandler.createdApiResponse(arvore.getId());
        } catch (Exception ex) {
            return ResponseHandler.errorApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

}
