package com.fields.fields_report.domain.reports;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DailyReportProductionRepository extends MongoRepository<DailyProductionReport, UUID> {
}
