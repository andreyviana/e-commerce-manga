DROP DATABASE emanga;

CREATE DATABASE emanga;

USE emanga;

CREATE TABLE usuarios (
  id INT PRIMARY KEY AUTO_INCREMENT,
  email_usuario VARCHAR(256) UNIQUE NOT NULL,
  senha_usuario VARCHAR(256) NOT NULL,
  acesso_usuario VARCHAR(100) NOT NULL
);

CREATE TABLE generos (
  id INT PRIMARY KEY AUTO_INCREMENT,
  genero VARCHAR(30) NOT NULL
);

CREATE TABLE mangas (
  id INT PRIMARY KEY AUTO_INCREMENT,
  titulo VARCHAR(100) NOT NULL,
  foto_capa_url VARCHAR(255),
  volume INT,
  preco NUMERIC(4 ,2),
  descricao TEXT,
  autores VARCHAR(100)
);

CREATE TABLE generos_mangas (
  id_genero INT,
  id_manga INT,
  PRIMARY KEY (id_genero, id_manga),
  FOREIGN KEY (id_genero) REFERENCES generos (id),
  FOREIGN KEY (id_manga) REFERENCES mangas (id)
);

INSERT INTO generos (genero)
VALUES ("Ação"),
  ("Fantasia"),
  ("Comédia");

INSERT INTO mangas (titulo, foto_capa_url, volume, preco, descricao, autores)
VALUES ("Sentouin, Hakenshimasu!", "https://cdn.myanimelist.net/images/manga/2/270153.jpg", 1, 30.5, NULL, "Kiasa, Masaaki (Arte), Akatsuki, Natsume (História)"),
  ("One Punch-Man", "https://cdn.myanimelist.net/images/manga/3/80661.jpg", 1, 23.99, NULL, "Murata, Yusuke (Arte), ONE (História)"),
  ("One Piece", "https://cdn.myanimelist.net/images/manga/2/253146.jpg", 30, 40, NULL, "Oda, Eiichiro (Arte e História)"),
  ("Noragami", "https://cdn.myanimelist.net/images/manga/3/161911.jpg", 1, 45.50, NULL, "Adachitoka (Arte e História)");

INSERT INTO generos_mangas (id_genero, id_manga)
VALUES (1, 1), 
  (1, 2),
  (1, 3),
  (1, 4),
  (2, 1), 
  (2, 3), 
  (2, 4), 
  (3, 1), 
  (3, 2);
  
SELECT generos.*, mangas.*
FROM generos_mangas
JOIN generos 
ON generos_mangas.id_genero = generos.id
JOIN mangas
ON generos_mangas.id_manga = mangas.id
ORDER BY mangas.titulo;
