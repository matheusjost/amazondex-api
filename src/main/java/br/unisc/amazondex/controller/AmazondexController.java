package br.unisc.amazondex.controller;

import br.unisc.amazondex.entity.Usuario;
import br.unisc.amazondex.pojo.ApiResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

abstract class AmazondexController<T> {

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public Usuario getUsuario() {
        return (Usuario) getAuthentication().getPrincipal();
    }

    public String getRole() {
        return getAuthentication().getAuthorities().iterator().next().getAuthority();
    }

    @PostMapping()
    public ResponseEntity<ApiResponseDTO> post(@RequestBody T requestBody) {
        return ResponseHandler.errorApiResponse(HttpStatus.NOT_IMPLEMENTED, "Not implemented yet");
    }

    @PostMapping("upload")
    public ResponseEntity<ApiResponseDTO> upload(@RequestParam("file") MultipartFile file) {
        return ResponseHandler.errorApiResponse(HttpStatus.NOT_IMPLEMENTED, "Not implemented yet");
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDTO> get(@PathVariable String id) {
        return ResponseHandler.errorApiResponse(HttpStatus.NOT_IMPLEMENTED, "Not implemented yet");
    }

    @GetMapping("view/{id}")
    public ResponseEntity<byte[]> view(@PathVariable String id) {
        return null;
    }

    @GetMapping("/list")
    public ResponseEntity<ApiResponseDTO> listAll() {
        return ResponseHandler.errorApiResponse(HttpStatus.NOT_IMPLEMENTED, "Not implemented yet");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponseDTO> delete(@PathVariable String id) {
        return ResponseHandler.errorApiResponse(HttpStatus.NOT_IMPLEMENTED, "Not implemented yet");
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponseDTO> put(@PathVariable String id, @RequestBody T requestBody) {
        return ResponseHandler.errorApiResponse(HttpStatus.NOT_IMPLEMENTED, "Not implemented yet");
    }

}
