CREATE DATABASE streamvault_db; -- Creación de base de datos.
USE streamvault_db; -- Usamos la base de datos.

CREATE TABLE planes (
    id_plan INT IDENTITY(1,1) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    precio DECIMAL(5,2) NOT NULL,
    limite_horas INT NULL,
    con_anuncios BIT NOT NULL DEFAULT 1,
    perfiles INT NULL,
    descargas BIT NOT NULL DEFAULT 0
);

CREATE TABLE usuarios (
    id_usuario INT IDENTITY(1,1) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    tipo_usuario VARCHAR(20) NOT NULL CHECK (tipo_usuario IN ('Free', 'Premium'))
);

CREATE TABLE suscripciones (
    id_suscripcion INT IDENTITY(1,1) PRIMARY KEY,
    id_usuario INT NOT NULL FOREIGN KEY REFERENCES usuarios(id_usuario),
    id_plan INT NOT NULL FOREIGN KEY REFERENCES planes(id_plan),
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL
);

CREATE TABLE contenidos (
    id_contenido VARCHAR(10) PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    tipo_contenido VARCHAR(20) NOT NULL CHECK (tipo_contenido IN ('Pelicula', 'Serie', 'Episodio')),
    duracion_total INT NOT NULL
);

CREATE TABLE historial_reproducciones (
    id_reproduccion INT IDENTITY(1,1) PRIMARY KEY,
    id_usuario INT NOT NULL FOREIGN KEY REFERENCES usuarios(id_usuario),
    id_contenido VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES contenidos(id_contenido),
    fecha DATETIME NOT NULL DEFAULT GETDATE(),
    duracion_seg INT NOT NULL
);

INSERT INTO planes (nombre, precio, limite_horas, con_anuncios, perfiles, descargas) VALUES
('PlanFree', 0.00, 10, 1, 1, 0),
('PlanBasico', 9.90, 30, 0, 1, 0),
('PlanPremium', 19.90, NULL, 0, 4, 1);

