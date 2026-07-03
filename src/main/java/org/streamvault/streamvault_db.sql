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
-- Insertamos los planes disponibles
INSERT INTO planes (nombre, precio, limite_horas, con_anuncios, perfiles, descargas) VALUES
('PlanFree', 0.00, 10, 1, 1, 0),
('PlanBasico', 9.90, 30, 0, 1, 0),
('PlanPremium', 19.90, NULL, 0, 4, 1);

CREATE TABLE usuarios (
    id_usuario INT IDENTITY(1,1) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    tipo_usuario VARCHAR(20) NOT NULL CHECK (tipo_usuario IN ('Free', 'Premium'))
);
-- Actualización + columna contraseña
ALTER TABLE usuarios
ADD contrasena VARCHAR(255) NOT NULL DEFAULT '123456789';

-- Suscripciones de usuarios
CREATE TABLE suscripciones (
    id_suscripcion INT IDENTITY(1,1) PRIMARY KEY,
    id_usuario INT NOT NULL FOREIGN KEY REFERENCES usuarios(id_usuario),
    id_plan INT NOT NULL FOREIGN KEY REFERENCES planes(id_plan),
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL
);

-- Contenidos
CREATE TABLE contenidos (
    id_contenido VARCHAR(10) PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    tipo_contenido VARCHAR(20) NOT NULL CHECK (tipo_contenido IN ('Pelicula', 'Serie', 'Episodio')),
    duracion_total INT NOT NULL
);
-- Actualización de campos
ALTER TABLE contenidos ADD
    genero VARCHAR(100) NULL,
    anio INT NULL,
    calificacion FLOAT NULL,
    director VARCHAR(150) NULL,
    clasificacion VARCHAR(50) NULL,
    temporadas INT NULL,
    numero_episodio INT NULL,
    titulo_episodio VARCHAR(255) NULL;

--Historial de usuarios
CREATE TABLE historial_reproducciones (
    id_reproduccion INT IDENTITY(1,1) PRIMARY KEY,
    id_usuario INT NOT NULL FOREIGN KEY REFERENCES usuarios(id_usuario),
    id_contenido VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES contenidos(id_contenido),
    fecha DATETIME NOT NULL DEFAULT GETDATE(),
    duracion_seg INT NOT NULL
);


select * from suscripciones;
select * from planes;
select * from usuarios;
select * from contenidos;
select * from historial_reproducciones;
