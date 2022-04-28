package com.fields.fields_report.exceptions

import com.fields.fields_report.domain.reports.DailyProductionReport
import com.fields.fields_report.domain.reports.DailyProductionReportController
import com.fields.fields_report.domain.reports.DailyReportProductionRepository
import com.fields.fields_report.model.DailyReportDto
import com.fields.fields_report.model.HCtype
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class DailyProductionReportNotFoundExceptionTest extends Specification {

    @Autowired
    private DailyReportProductionRepository reportProductionRepository
    @Autowired
    private DailyProductionReportController dailyProductionReportController

    private DailyReportDto dailyReportDto
    private final UUID INVALID_ID = UUID.randomUUID()

    void setup() {
        DailyProductionReport productionReport= new DailyProductionReport("Concession 1", List.of("Company1"), "Field 1", List.of(HCtype.GAS), 0.0, 10.0, 0.0)
        dailyReportDto = reportProductionRepository.save(productionReport).toDto()
    }

    void cleanup() {
        reportProductionRepository.deleteAll()
    }

    def "Try to find report with wrong id and get thrown DailyProductionReportNotFoundException"() {
        when:
        dailyProductionReportController.findDailyReportById(INVALID_ID)
        then:
        thrown(DailyProductionReportNotFoundException)
    }
}
