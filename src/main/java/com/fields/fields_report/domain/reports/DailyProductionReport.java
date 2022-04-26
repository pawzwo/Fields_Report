package com.fields.fields_report.domain.reports;

import com.fields.fields_report.domain.ProtoDocument;
import com.fields.fields_report.model.DailyReportDto;
import com.fields.fields_report.model.HCtype;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter
@Builder
public class DailyProductionReport extends ProtoDocument {

    private String concessionName;
    private List<String> owners;
    private String fieldName;
    private List<HCtype> hydrocarbons;
    private Double producedOilBbl;
    private Double producedGasMcf;
    private Double producedCondensateBbl;


    public DailyReportDto toDto() {
        DailyReportDto dailyReportDto = new DailyReportDto();

        dailyReportDto.setId(this.getId());
        dailyReportDto.setConcessionName(this.getConcessionName());
        dailyReportDto.setOwners(this.getOwners());
        dailyReportDto.setFieldName(this.getFieldName());
        dailyReportDto.setHydrocarbons(this.getHydrocarbons());
        dailyReportDto.setProducedOilBbl(this.getProducedOilBbl());
        dailyReportDto.setProducedGasMMcf(this.getProducedGasMcf());
        dailyReportDto.setProducedCondensateBbl(this.getProducedCondensateBbl());
        return dailyReportDto;
    }

    public DailyProductionReport updateDailyReport(DailyReportDto dailyReportDto) {
        this.concessionName=dailyReportDto.getConcessionName();
        this.owners=dailyReportDto.getOwners();
        this.fieldName=dailyReportDto.getFieldName();
        this.hydrocarbons=dailyReportDto.getHydrocarbons();
        this.producedOilBbl= dailyReportDto.getProducedOilBbl();
        this.producedGasMcf=dailyReportDto.getProducedGasMMcf();
        this.producedCondensateBbl=dailyReportDto.getProducedCondensateBbl();
        return this;
    }

}
