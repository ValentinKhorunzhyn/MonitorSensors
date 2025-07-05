package com.khorunzhyn.statistics.repository;

import com.khorunzhyn.statistics.model.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Long> {

    List<Statistic> findByDateBetween(LocalDate from, LocalDate to);
}
