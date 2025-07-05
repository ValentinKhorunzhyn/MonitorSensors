package com.khorunzhyn.statistics.mapper;

import com.khorunzhyn.statistics.model.Statistic;
import com.khorunzhyn.statistics.model.sensor.Sensor;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticMapper {

    public static Statistic getStatistic(List<Sensor> sensors) {
        Statistic statistic = new Statistic();
        statistic.setDate(LocalDate.now());

        Map<String, Long> stats = sensors.stream()
                .collect(Collectors.groupingBy(sensor -> sensor.getType().getTypeName(), Collectors.counting()));

        statistic.setTotal(sensors.size());
        statistic.setPressure(stats.getOrDefault("Pressure", 0L).intValue());
        statistic.setVoltage(stats.getOrDefault("Voltage", 0L).intValue());
        statistic.setTemperature(stats.getOrDefault("Temperature", 0L).intValue());
        statistic.setHumidity(stats.getOrDefault("Humidity", 0L).intValue());
        return statistic;
    }

}
