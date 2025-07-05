CREATE TABLE catalogue.table_user (
  id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  user_name VARCHAR(20) NOT NULL CHECK (length(trim(user_name)) > 0 ) UNIQUE,
  password VARCHAR(500)
);
