CREATE TABLE IF NOT EXISTS usuario(
    id SERIAL PRIMARY KEY,
    login VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL CHECK (role IN ('ADMINISTRADOR','BIOLOGO','ALUNO'))
);