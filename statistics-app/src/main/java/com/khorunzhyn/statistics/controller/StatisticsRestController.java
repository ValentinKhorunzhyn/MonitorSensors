package com.khorunzhyn.statistics.controller;

import com.khorunzhyn.statistics.model.Statistic;
import com.khorunzhyn.statistics.service.StatisticService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/stats")
public class StatisticsRestController {

    private final StatisticService service;

    public StatisticsRestController(StatisticService service) {
        this.service = service;
    }

    @GetMapping
    public List<Statistic> getStats(
            @RequestParam(value = "from",required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam(value = "to",required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to
    ) {
        return service.getStatisticsByDates(from, to);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ProblemDetail> handleNoSuchElementException(IllegalArgumentException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }

}
