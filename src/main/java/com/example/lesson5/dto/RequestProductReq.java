package com.example.lesson5.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RequestProductReq {

    private Integer instanceId;

    @NotNull(message = "Обязательное поле productType не заполнено!!!")
    private String productType;

    @NotNull(message = "Обязательное поле productCode не заполнено!!!")
    private String productCode;

    @NotNull(message = "Обязательное поле registerType не заполнено!!!")
    private String registerType;

    @NotNull(message = "Обязательное поле mdmCode не заполнено!!!")
    private String mdmCode;

    @NotNull(message = "Обязательное поле contractNumber не заполнено!!!")
    private String contractNumber;

    @NotNull(message = "Обязательное поле contractDate не заполнено!!!")
    private Date contractDate;

    @NotNull(message = "Обязательное поле priority не заполнено!!!")
    private Integer priority;

    private Float interestRatePenalty;

    private Float minimalBalance;

    private Float thresholdAmount;

    private String accountingDetails;

    private String rateType;

    private Float taxPercentageRate;

    private Float technicalOverdraftLimitAmount;

    @NotNull(message = "Обязательное поле contractId не заполнено!!!")
    private Integer contractId;

    @NotNull(message = "Обязательное поле BranchCode не заполнено!!!")
    private String BranchCode;

    @NotNull(message = "Обязательное поле IsoCurrencyCode не заполнено!!!")
    private String IsoCurrencyCode;

    @NotNull(message = "Обязательное поле urgencyCode не заполнено!!!")
    private String urgencyCode;

    private Integer ReferenceCode;

    private List<additionalPropertiesVipDto> data;

    private List<instanceArrangementDto> instanceArrangement;

}
