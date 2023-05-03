package io.kodlama.starbucks.business.rules;

import io.kodlama.starbucks.business.abstracts.PersonCheckService;
import io.kodlama.starbucks.business.dto.requests.CheckRealPersonRequest;
import io.kodlama.starbucks.core.rules.BaseBusinessRules;
import io.kodlama.starbucks.core.utilities.exceptions.business.BusinessErrorCode;
import io.kodlama.starbucks.core.utilities.exceptions.business.BusinessException;
import io.kodlama.starbucks.entity.concretes.IndividualCustomer;
import io.kodlama.starbucks.repository.IndividualCustomerRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class IndividualCustomerBusinessRules extends BaseBusinessRules<IndividualCustomer, IndividualCustomerRepository> {
    private final PersonCheckService personCheckService;

    public IndividualCustomerBusinessRules(@Qualifier("mernisServiceAdapter") PersonCheckService personCheckService, IndividualCustomerRepository repository){
        super("IndividualCustomer", repository);
        this.personCheckService = personCheckService;
    }

    public void checkIfEmailIsNotUsed(String email){
        if(!getRepository().existsByEmail(email)) return;
        throw new BusinessException(BusinessErrorCode.AlreadyUsed, "Email is already used!");
    }

    public void checkIfNationalIdentityIsNotUsed(String nationalIdentity) throws BusinessException{
        if(!getRepository().existsByNationalIdentity(nationalIdentity)) return;
        throw new BusinessException(BusinessErrorCode.AlreadyUsed, "National identity is already used!");
    }

    public void checkIfNationalIdentityIsExist(String nationalIdentity) throws BusinessException{
        if(getRepository().existsByNationalIdentity(nationalIdentity)) return;
        throw new BusinessException(BusinessErrorCode.NotExists, "The individual user with " + nationalIdentity +" a could not be reached.");
    }

    public void checkIfRealPerson(CheckRealPersonRequest request) throws BusinessException {
        if (personCheckService.checkRealPerson(request)) return;
        throw new BusinessException(BusinessErrorCode.Incorrect, "An invalid person information was rejected.");
    }
}
