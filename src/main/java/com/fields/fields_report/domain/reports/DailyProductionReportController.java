package com.fields.fields_report.domain.reports;

import com.fields.fields_report.api.DailyReportsApi;
import com.fields.fields_report.exceptions.DailyProductionReportNotFoundException;
import com.fields.fields_report.model.DailyReportDto;
import com.fields.fields_report.model.HCtype;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class DailyProductionReportController implements DailyReportsApi {

    private final DailyProductionReportService dailyProductionReportService;

    @Override
    public ResponseEntity<Void> deleteDailyReport(UUID id) {
        dailyProductionReportService.deleteDailyReport(id);
        return ResponseEntity.ok().build();
    }

    //TODO
    @Override
    public ResponseEntity<List<DailyReportDto>> findAllReports(String companyName, String concessionName, String filedName, String owner, HCtype hydrocarbons) {
        return DailyReportsApi.super.findAllReports(companyName, concessionName, filedName, owner, hydrocarbons);
    }

    @Override
    public ResponseEntity<DailyReportDto> findDailyReportById(UUID id) {
        return ResponseEntity.ok(dailyProductionReportService.findDailyReportById(id)
                .orElseThrow(DailyProductionReportNotFoundException::new));
    }

    @Override
    public ResponseEntity<DailyReportDto> updateDailyReport(UUID id, DailyReportDto dailyReportDto) {
        return ResponseEntity.ok(dailyProductionReportService.updateDailyReport(id, dailyReportDto));
    }
}
