CREATE DATABASE bdaula01;
USE bdaula01;

CREATE TABLE veiculo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    modelo VARCHAR(30),
    placa VARCHAR(7),
    id_pessoa SMALLINT NOT NULL,
    FOREIGN KEY (id_pessoa) REFERENCES pessoa(id)
);
CREATE TABLE pessoa (
    id SMALLINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    sexo VARCHAR(1) NOT NULL,
    idioma VARCHAR(10) NOT NULL
);
INSERT INTO pessoa (nome, sexo, idioma) VALUES 
("Bruno", "M", "Português"),
("Iago", "M", "Português"),
("Matheus", "M", "Espanhol"),
("Aileen", "F", "Inglês"),
("Maria", "F", "Francês"),
("Gabriela", "F", "Alemão");
