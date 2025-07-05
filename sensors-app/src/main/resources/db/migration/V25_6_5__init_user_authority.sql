CREATE TABLE catalogue.table_authority (
  id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  authority VARCHAR(20) NOT NULL CHECK (length(trim(authority)) > 0 ) UNIQUE
);

CREATE TABLE catalogue.table_user_authority (
  id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  id_user INTEGER REFERENCES catalogue.table_user(id),
  id_authority INTEGER REFERENCES catalogue.table_authority(id),
  CONSTRAINT uk_user_authority UNIQUE (id_user,id_authority)
);