package br.unisc.amazondex.controller;

import br.unisc.amazondex.command.ArvoreCommand;
import br.unisc.amazondex.entity.Arvore;
import br.unisc.amazondex.pojo.ApiResponseDTO;
import br.unisc.amazondex.service.ArvoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import jakarta.persistence.NoResultException;
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
    @Operation(summary = "Cadastrar uma nova árvore")
    public ResponseEntity<ApiResponseDTO> post(@RequestBody ArvoreCommand cmd) {
        try {
            Arvore arvore = arvoreService.salvar(cmd);
            return ResponseHandler.createdApiResponse(arvore.getId());
        } catch (Exception ex) {
            return ResponseHandler.errorApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @Override
    @Operation(summary = "Buscar árvore por ID")
    public ResponseEntity<ApiResponseDTO> get(@PathVariable String id) {
        try {
            return ResponseHandler.okApiResponse(arvoreService.buscarPorArvoreId(Integer.parseInt(id)));
        } catch (NoResultException ex) {
            return ResponseHandler.errorApiResponse(HttpStatus.NOT_FOUND, "Arvore não encontrada");
        } catch (Exception ex) {
            return ResponseHandler.errorApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @Override
    @Operation(summary = "Buscar todas as árvores")
    public ResponseEntity<ApiResponseDTO> listAll() {
        try {
            return ResponseHandler.okApiResponse(arvoreService.buscarTodasAsArvores());
        } catch (Exception ex) {
            return ResponseHandler.errorApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @Override
    @Operation(summary = "Remover árvore por ID")
    public ResponseEntity<ApiResponseDTO> delete(@PathVariable String id) {
        try {
            arvoreService.deletar(Integer.parseInt(id));
            return ResponseHandler.okApiResponse();
        } catch (Exception ex) {
            return ResponseHandler.errorApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @Override
    @Operation(summary = "Atualizar árvore por ID")
    public ResponseEntity<ApiResponseDTO> put(@PathVariable String id, @RequestBody ArvoreCommand cmd) {
        try {
            Arvore arvore = arvoreService.salvar(cmd);
            return ResponseHandler.okApiResponse(arvore.getId());
        } catch (Exception ex) {
            return ResponseHandler.errorApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

}
