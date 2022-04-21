package com.fields.fields_report.domain.reports;

import com.fields.fields_report.model.DailyReportDto;
import com.fields.fields_report.model.HCtype;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DailyProductionReportService {

    void deleteDailyReport(UUID id);

    List<DailyReportDto> findAllDailyReports(String companyName, String concessionName, String filedName, String owner, HCtype hydrocarbons);

    Optional<DailyReportDto> findDailyReportById(UUID id);

    DailyReportDto updateDailyReport(UUID id, DailyReportDto dailyReportDto);


}
