//package com.fields.fields_report.kafka;
//
//import com.fields.fields_report.domain.reports.DailyProductionReport;
//import com.fields.fields_report.model.DailyReportDto;
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//@Component
//@Slf4j
//public class KafkaListeners {
//
//    @KafkaListener(topics= "Daily_Report",
//    groupId = "daily_report",
//    containerFactory = "reportKafkaListenerContainerFactory")
//    void listener(DailyReportDto dailyReportDto) {
//
//        log.info(dailyReportDto.toString());
//    }
//
//    private void saveDailyReport(DailyReportDto dailyReportDto) {
//        DailyProductionReport.DailyProductionReportBuilder reportBuilder = new DailyProductionReport.DailyProductionReportBuilder();
//    }
//
//
//
//}
