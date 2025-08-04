package com.alura.forohub.topico;

import java.time.LocalDateTime;

public record DatosDetalleTopico(Long id,
                                 String titulo,
                                 String mensaje,
                                 LocalDateTime fechaCreacion,
                                 String status,
                                 String autor,
                                 String curso,
                                 String respuestas) {
    public DatosDetalleTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso(),
                topico.getRespuestas());
    }
}
