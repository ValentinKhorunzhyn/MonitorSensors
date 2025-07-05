package com.khorunzhyn.statistics.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(schema = "statistics", name = "table_sensor_stats")
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "statistic_date")
    private LocalDate date;
    @Column(name = "total_sensors ")
    private int total;
    @Column(name = "pressure_count")
    private int pressure;
    @Column(name = "voltage_count")
    private int voltage;
    @Column(name = "temperature_count")
    private int temperature;
    @Column(name = "humidity_count")
    private int humidity;

    public Statistic() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "id=" + id +
                ", date=" + date +
                ", total=" + total +
                ", pressure=" + pressure +
                ", voltage=" + voltage +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                '}';
    }
}
