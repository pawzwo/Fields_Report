package com.fields.fields_report.domain.reports;

import com.fields.fields_report.exceptions.DailyProductionReportNotFoundException;
import com.fields.fields_report.model.DailyReportDto;
import com.fields.fields_report.model.HCtype;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class DailyProductionReportServiceImpl implements DailyProductionReportService {

    private final DailyReportProductionRepository productionRepository;

    private void saveDailyReport(DailyReportDto dailyReportDto) {
        DailyProductionReport.DailyProductionReportBuilder reportBuilder = new DailyProductionReport.DailyProductionReportBuilder();
        DailyProductionReport dailyProductionReport = reportBuilder
                .concessionName(dailyReportDto.getConcessionName())
                .owners(dailyReportDto.getOwners())
                .fieldName(dailyReportDto.getFieldName())
                .hydrocarbons(dailyReportDto.getHydrocarbons())
                .producedOilBbl(dailyReportDto.getProducedOilBbl())
                .producedGasMcf(dailyReportDto.getProducedGasMMcf())
                .producedCondensateBbl(dailyReportDto.getProducedCondensateBbl())
                .build();
        productionRepository.save(dailyProductionReport);
    }

    @Override
    public void deleteDailyReport(UUID id) {
        productionRepository.delete(productionRepository.findById(id).orElseThrow(DailyProductionReportNotFoundException::new));
    }

    @Override
    public List<DailyReportDto> findAllDailyReports(String companyName, String concessionName, String filedName, String owner, HCtype hydrocarbons) {
        return null;
    }

    @Override
    public Optional<DailyReportDto> findDailyReportById(UUID id) {
        System.out.println(id);
        System.out.println(productionRepository.findById(id).orElseThrow(DailyProductionReportNotFoundException::new).toString());
        return productionRepository.findById(id).map(DailyProductionReport::toDto);
    }

    @Override
    public DailyReportDto updateDailyReport(UUID id, DailyReportDto dailyReportDto) {
        DailyProductionReport dailyProductionReport = productionRepository.findById(id).orElseThrow(DailyProductionReportNotFoundException::new);
        dailyProductionReport.updateDailyReport(dailyReportDto);
        return productionRepository.save(dailyProductionReport).toDto();
    }

    @KafkaListener(topics= "Daily_Report",
            groupId = "daily_report",
            containerFactory = "reportKafkaListenerContainerFactory")
    void listener(DailyReportDto dailyReportDto) {
        saveDailyReport(dailyReportDto);
        log.info(dailyReportDto.toString());
    }

}
