package com.alura.forohub.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizacionTopico(@NotNull Long id,
                                       String mensaje,
                                       String status,
                                       String curso) {
}
