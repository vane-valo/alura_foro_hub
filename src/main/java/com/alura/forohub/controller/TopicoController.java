package com.alura.forohub.controller;

import com.alura.forohub.topico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;
    List<Topico> topicoList;

    @Transactional
   @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriComponentsBuilder){
       var topico = new Topico(datos);
       repository.save(topico);

       var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

       return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));
    }

    @GetMapping
    public ResponseEntity listar(){
        topicoList = repository.findAll();

        return ResponseEntity.ok(topicoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id){
       var topico = repository.getReferenceById(id);

       return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @Transactional
    @PutMapping
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizacionTopico datos){
     var topico = repository.getReferenceById(datos.id());
     topico.actualizarDatos(datos);

     return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        Optional<Topico> topico;

        repository.deleteById(id);
        topicoList = repository.findAll();

        return ResponseEntity.ok(topicoList);
    }
}
