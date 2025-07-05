CREATE SCHEMA IF NOT EXISTS catalogue;

CREATE TABLE catalogue.table_sensor_type (
  id BIGINT PRIMARY KEY,
  type_name VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE catalogue.table_sensor_unit (
  id BIGINT PRIMARY KEY,
  unit_name VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE catalogue.table_sensor (
  id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  name VARCHAR(30) NOT NULL,
  model VARCHAR(15) NOT NULL,
  range_from INTEGER NOT NULL,
  range_to INTEGER NOT NULL,
  type_id BIGINT REFERENCES catalogue.table_sensor_type(id),
  unit_id BIGINT REFERENCES catalogue.table_sensor_unit(id),
  location VARCHAR(40),
  description VARCHAR(200)
);