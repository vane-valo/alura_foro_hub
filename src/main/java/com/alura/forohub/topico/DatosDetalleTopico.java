package com.alura.forohub.topico;

import java.time.LocalDateTime;

public record DatosDetalleTopico(Long id,
                                 String titulo,
                                 String mensaje,
                                 String status,
                                 String autor,
                                 String curso) {
    public DatosDetalleTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}
