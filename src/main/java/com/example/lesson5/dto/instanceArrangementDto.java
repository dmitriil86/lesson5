package com.example.lesson5.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class instanceArrangementDto {

    private String GeneralAgreementId;

    private String SupplementaryAgreementId;

    private String arrangementType;

    private Integer shedulerJobId;

    @NotNull(message = "Обязательное поле instanceArrangement.Number не заполнено!!!")
    private String Number;

    @NotNull(message = "Обязательное поле instanceArrangement.openingDate не заполнено!!!")
    private Date openingDate;

    private Date closingDate;

    private Date CancelDate;

    private Integer validityDuration;

    private String cancellationReason;

    private String Status;

    private Date interestCalculationDate;

    private Float interestRate;

    private Float coefficient;

    private String coefficientAction;

    private Float minimumInterestRate;

    private String minimumInterestRateCoefficient;

    private String minimumInterestRateCoefficientAction;

    private BigDecimal maximalnterestRate;

    private BigDecimal maximalnterestRateCoefficient;

    private String maximalnterestRateCoefficientAction;


}
