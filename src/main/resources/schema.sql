CREATE TABLE IF NOT EXISTS "usuario"(
    "id" SERIAL PRIMARY KEY,
    "login" TEXT NOT NULL UNIQUE,
    "senha" TEXT NOT NULL,
    "nome" TEXT NOT NULL,
    "email" TEXT NOT NULL UNIQUE,
    "role" TEXT NOT NULL CHECK (role IN ('ADMIN','BIOLOGO','ALUNO'))
);

CREATE TABLE IF NOT EXISTS "arvore" (
    "id" serial PRIMARY KEY,
    "nome" TEXT,
    "descricao_botanica" text,
    "aspectos_ecologicos" text,
    "regeneracao_natural" text
);

CREATE TABLE IF NOT EXISTS "ocorrencia_natural" (
    "id" serial PRIMARY KEY,
    "arvore_id" integer,
    "latitude" text,
    "longitude" text,
    FOREIGN KEY ("arvore_id") REFERENCES "arvore" ("id") ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "biologia_reprodutiva" (
    "id" serial PRIMARY KEY,
    "arvore_id" integer,
    "tipo" TEXT,
    "descricao" TEXT,
    FOREIGN KEY ("arvore_id") REFERENCES "arvore" ("id") ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS "arquivo" (
    "id" serial PRIMARY KEY,
    "uploaded_at" timestamp,
    "usuario_id" integer,
    "caminho" text,
    FOREIGN KEY ("usuario_id") REFERENCES "usuario" ("id")
);

CREATE TABLE IF NOT EXISTS "paisagismo" (
    "id" serial PRIMARY KEY,
    "arvore_id" integer,
    "descricao" text,
    FOREIGN KEY ("arvore_id") REFERENCES "arvore" ("id") ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "paisagismo_foto" (
    "id" serial PRIMARY KEY,
    "paisagismo_id" integer,
    "foto_id" integer,
    FOREIGN KEY ("paisagismo_id") REFERENCES "paisagismo" ("id") ON DELETE CASCADE,
    FOREIGN KEY ("foto_id") REFERENCES "arquivo" ("id") ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "foto_arvore" (
    "id" serial PRIMARY KEY,
    "arvore_id" integer,
    "foto_id" integer,
    "descricao" text,
    FOREIGN KEY ("arvore_id") REFERENCES "arvore" ("id") ON DELETE CASCADE,
    FOREIGN KEY ("foto_id") REFERENCES "arquivo" ("id")
);

CREATE TABLE IF NOT EXISTS "aproveitamento" (
    "id" serial PRIMARY KEY,
    "arvore_id" integer,
    "descricao" text,
    FOREIGN KEY ("arvore_id") REFERENCES "arvore" ("id") ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "alimentacao" (
    "id" serial PRIMARY KEY,
    "aproveitamento_id" integer,
    "dados_nutricionais" text,
    "formas_consumo" text,
    FOREIGN KEY ("aproveitamento_id") REFERENCES "aproveitamento" ("id") ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "biotecnologia" (
    "id" serial PRIMARY KEY,
    "aproveitamento_id" integer,
    "composicao" text,
    "potencia_bioprodutos" text,
    FOREIGN KEY ("aproveitamento_id") REFERENCES "aproveitamento" ("id") ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "bioatividade" (
    "id" serial PRIMARY KEY,
    "aproveitamento_id" integer,
    "descricao" text,
    FOREIGN KEY ("aproveitamento_id") REFERENCES "aproveitamento" ("id") ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "cultivo" (
    "id" serial PRIMARY KEY,
    "arvore_id" integer,
    "descricao" text,
    FOREIGN KEY ("arvore_id") REFERENCES "arvore" ("id") ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "cuidados_especiais" (
    "id" serial PRIMARY KEY,
    "cultivo_id" integer,
    "tipo_cuidado" text,
    "descricao" text,
    FOREIGN KEY ("cultivo_id") REFERENCES "cultivo" ("id") ON DELETE CASCADE
);
