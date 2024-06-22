-- Crear la tabla Perfil
CREATE TABLE Perfil (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- Crear la tabla Usuario
CREATE TABLE Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correoElectronico VARCHAR(100) NOT NULL UNIQUE,
    contrasena VARCHAR(100) NOT NULL,
    perfiles INT,
    FOREIGN KEY (perfiles) REFERENCES Perfil(id)
);

-- Crear la tabla Curso
CREATE TABLE Curso (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    categoria VARCHAR(100) NOT NULL
);

-- Crear la tabla Topico
CREATE TABLE Topico (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    mensaje TEXT NOT NULL,
    fechaCreacion DATETIME NOT NULL,
    status ENUM('abierto', 'cerrado') NOT NULL,
    autor INT,
    curso INT,
    respuestas INT,
    FOREIGN KEY (autor) REFERENCES Usuario(id),
    FOREIGN KEY (curso) REFERENCES Curso(id)
);

-- Crear la tabla Respuesta
CREATE TABLE Respuesta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    mensaje TEXT NOT NULL,
    topico INT,
    fechaCreacion DATETIME NOT NULL,
    autor INT,
    solucion BOOLEAN,
    FOREIGN KEY (topico) REFERENCES Topico(id),
    FOREIGN KEY (autor) REFERENCES Usuario(id)
);
