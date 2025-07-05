package com.khorunzhyn.statistics.service;

import com.khorunzhyn.statistics.client.SensorsRestClient;
import com.khorunzhyn.statistics.mapper.StatisticMapper;
import com.khorunzhyn.statistics.model.Statistic;
import com.khorunzhyn.statistics.model.sensor.Sensor;
import com.khorunzhyn.statistics.repository.StatisticRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StatisticService {

    private static final Logger log = LoggerFactory.getLogger(StatisticService.class);
    private final SensorsRestClient sensorClient;
    private final StatisticRepository statisticRepository;

    public StatisticService(SensorsRestClient sensorClient, StatisticRepository statisticRepository) {
        this.sensorClient = sensorClient;
        this.statisticRepository = statisticRepository;
    }

    @Scheduled(fixedRate = 30000)
    public void collectDailyStats() {
        log.info("Getting sensors statistic from sensors-app");
        List<Sensor> sensors = sensorClient.getAllSensors();
        log.info("Sensors found: {}", sensors.size());

        Statistic statistic = StatisticMapper.getStatistic(sensors);

        statisticRepository.save(statistic);
    }

    public List<Statistic> getStatisticsByDates(LocalDate startDate, LocalDate endDate) {

        if (startDate == null || endDate == null) {
            return statisticRepository.findAll();
        }

        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("Start date should be before End Date");
        }

        log.info("Start collecting statistic from {} to {}", startDate, endDate);
        return statisticRepository.findByDateBetween(startDate, endDate);
    }
}
