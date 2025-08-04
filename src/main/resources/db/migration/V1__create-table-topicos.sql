CREATE TABLE topicos(
    id bigint NOT NULL auto_increment,
    titulo VARCHAR(100) NOT NULL,
    mensaje VARCHAR(100) NOT NULL,
    fechaCreacion datetime NOT NULL,
    status VARCHAR(100) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    curso VARCHAR(100) NOT NULL,
    respuesta VARCHAR(12),

    PRIMARY KEY(id)
);