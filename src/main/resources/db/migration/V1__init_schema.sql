CREATE TABLE app_user (
    id          BIGSERIAL PRIMARY KEY,
    username    VARCHAR(255) NOT NULL UNIQUE,
    password    VARCHAR(255) NOT NULL,
    role        VARCHAR(50)  NOT NULL
);

CREATE TABLE note (
    id          BIGSERIAL PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    content     TEXT,
    created_at  TIMESTAMP    NOT NULL DEFAULT now(),
    owner       VARCHAR(255) NOT NULL
);
