package com.alura.forohub.topico;

public record DatosListaTopico(Long id,
                               String titulo,
                               String mensaje,
                               String status,
                               String autor,
                               String curso) {

    public DatosListaTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}
