package com.alura.forohub.controller;

import com.alura.forohub.topico.DatosDetalleTopico;
import com.alura.forohub.topico.DatosRegistroTopico;
import com.alura.forohub.topico.Topico;
import com.alura.forohub.topico.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

   @Transactional
   @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroTopico datos){
       var topico = new Topico(datos);
       repository.save(topico);

       return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }
}
