package com.example.lesson5.services.inpl;

import com.example.lesson5.dto.RequestProductReq;
import com.example.lesson5.dto.ResponseBodyAgreementDto;
import com.example.lesson5.dto.instanceArrangementDto;
import com.example.lesson5.exceptions.BadRequestException;
import com.example.lesson5.exceptions.NotFoundException;
import com.example.lesson5.model.*;
import com.example.lesson5.repository.*;
import com.example.lesson5.services.ProductServices;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServicesImpl implements ProductServices {

    private final TppProductRepository tppProductRepository;
    private final AgreementRepository agreementRepository;
    private final TppRefProductClassRepository tppRefProductClassRepository;
    private final TppRefAccountTypeRepository tppRefAccountTypeRepository;
    private final TppRefProductRegisterTypeRepository tppRefProductRegisterTypeRepository;


    @SneakyThrows
    @Override
    public ResponseBodyAgreementDto createProduct(RequestProductReq req) {

        TppProduct tppProduct = tppProductRepository.findByNumber(req.getContractNumber());

        if (tppProduct!=null)
        {
            throw new BadRequestException("Параметр ContractNumber № договора "+req.getContractNumber()+" уже существует для ЭП с ИД  "+tppProduct.getId());
        }

        for(instanceArrangementDto instanceArrangementDto : req.getInstanceArrangement()) {
            Agreement agreement = agreementRepository.findByNumber(instanceArrangementDto.getNumber());

            if (agreement != null)
            {
                throw new BadRequestException("Параметр № Дополнительного соглашения (сделки) Number "+instanceArrangementDto.getNumber()+" уже существует для ЭП с ИД "+agreement.getId());
            }
        }

        TppRefProductClass tppRefProductClasses =  tppRefProductClassRepository.findByValue(req.getProductCode());

        TppRefAccountType tppRefAccountType = tppRefAccountTypeRepository.findByValue("Клиентский");

        List<TppRefProductRegisterType> tppRefProductRegisterTypes = tppRefProductRegisterTypeRepository.findByProductClassCodeAndAccountType(tppRefProductClasses, tppRefAccountType);

        if (tppRefProductRegisterTypes.size() == 0)
        {
            throw new NotFoundException("КодПродукта "+req.getProductCode()+" не найдено в Каталоге продуктов tpp_ref_product_class");
        }

//        tppProduct.set
//
//        tppProductRepository.saveAllAndFlush()

        return new ResponseBodyAgreementDto();
    }

    @SneakyThrows
    @Override
    public ResponseBodyAgreementDto changeProduct(RequestProductReq req) {

        TppProduct tppProduct = tppProductRepository.getReferenceById(req.getInstanceId());

        if (tppProduct == null)
        {
            throw new NotFoundException("Экземпляр продукта с параметром instanceId "+req.getInstanceId()+" не найден.");
        }

        for(instanceArrangementDto instanceArrangementDto : req.getInstanceArrangement()) {
            Agreement agreement = agreementRepository.findByNumber(instanceArrangementDto.getNumber());

            if (agreement != null)
            {
                throw new BadRequestException("Параметр № Дополнительного соглашения (сделки) Number "+instanceArrangementDto.getNumber()+" уже существует для ЭП с ИД "+agreement.getId());
            }
        }
        return new ResponseBodyAgreementDto();
    }
}
