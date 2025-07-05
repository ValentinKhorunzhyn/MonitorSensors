CREATE SCHEMA IF NOT EXISTS statistics;

CREATE TABLE statistics.table_sensor_stats (
  id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  statistic_date        DATE NOT NULL,
  total_sensors         INTEGER NOT NULL,
  pressure_count        INTEGER DEFAULT 0,
  voltage_count         INTEGER DEFAULT 0,
  temperature_count     INTEGER DEFAULT 0,
  humidity_count        INTEGER DEFAULT 0
);