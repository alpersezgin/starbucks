package io.kodlama.starbucks.business.rules;

import io.kodlama.starbucks.business.abstracts.CorporateCheckService;
import io.kodlama.starbucks.business.dto.requests.CheckRealCorporateRequest;
import io.kodlama.starbucks.core.rules.BaseBusinessRules;
import io.kodlama.starbucks.core.utilities.exceptions.business.BusinessErrorCode;
import io.kodlama.starbucks.core.utilities.exceptions.business.BusinessException;
import io.kodlama.starbucks.entity.concretes.CorporateCustomer;
import io.kodlama.starbucks.repository.CorporateCustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CorporateCustomerBusinessRules extends BaseBusinessRules<CorporateCustomer, CorporateCustomerRepository> {
    private final CorporateCheckService corporateCheckService;

    public CorporateCustomerBusinessRules(CorporateCustomerRepository repository, CorporateCheckService corporateCheckService){
        super("Corporate Customer", repository);
        this.corporateCheckService = corporateCheckService;
    }

    public void checkIfEmailOrCorporateNameIsNotUsed(String email, String corporateName) throws BusinessException {
        if(!getRepository().existsByEmailOrCorporateName(email, corporateName)) return;
        throw new BusinessException(BusinessErrorCode.AlreadyUsed, "Email or corporate name is used.");
    }

    public void checkIfEmailIsNotUsed(String email) throws BusinessException{
        if(!getRepository().existsByEmail(email)) return;
        throw new BusinessException(BusinessErrorCode.AlreadyUsed, "Email is already used!");
    }

    public void checkIfCorporateNameIsNotUsed(String corporateName) throws BusinessException{
        if(!getRepository().existsByCorporateName(corporateName)) return;
        throw new BusinessException(BusinessErrorCode.AlreadyUsed, "Corporate name is already used!");
    }

    public void checkIfSocialSecurityRegistrationNumberIsNotUsed(String ssrn) throws BusinessException{
        if(!getRepository().existsBySocialSecurityRegistrationNumber(ssrn)) return;
        throw new BusinessException(BusinessErrorCode.AlreadyUsed, "Social Security registration number is already used!");
    }

    public void checkIfRealCorporate(CheckRealCorporateRequest request) throws BusinessException {
        if (corporateCheckService.checkRealCorporate(request)) return;
        throw new BusinessException(BusinessErrorCode.Incorrect, "An invalid corporate information was rejected.");
    }
}
