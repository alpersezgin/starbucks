package io.kodlama.starbucks.business.concretes;

import io.kodlama.starbucks.business.abstracts.CorporateCustomerService;
import io.kodlama.starbucks.business.dto.requests.CheckRealCorporateRequest;
import io.kodlama.starbucks.business.dto.requests.create.CreateCorporateCustomerRequest;
import io.kodlama.starbucks.business.dto.requests.update.UpdateCorporateCustomerRequest;
import io.kodlama.starbucks.business.dto.responses.create.CreateCorporateCustomerResponse;
import io.kodlama.starbucks.business.dto.responses.get.GetAllCorporateCustomersResponse;
import io.kodlama.starbucks.business.dto.responses.get.GetCorporateCustomerResponse;
import io.kodlama.starbucks.business.dto.responses.update.UpdateCorporateCustomerResponse;
import io.kodlama.starbucks.business.rules.CorporateCustomerBusinessRules;
import io.kodlama.starbucks.core.utilities.exceptions.business.BusinessException;
import io.kodlama.starbucks.entity.concretes.CorporateCustomer;
import io.kodlama.starbucks.repository.CorporateCustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CorporateCustomerManager implements CorporateCustomerService {
    private final CorporateCustomerRepository repository;
    private final ModelMapper modelMapper;
    private final CorporateCustomerBusinessRules businessRules;
    @Override
    public List<GetAllCorporateCustomersResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(corporateCustomer -> modelMapper.map(corporateCustomer, GetAllCorporateCustomersResponse.class))
                .toList();
    }

    @Override
    public GetCorporateCustomerResponse getById(int customerId) throws BusinessException {
        CorporateCustomer corporateCustomer = businessRules.checkIfEntityExistsByIdThenReturn(customerId);
        return modelMapper.map(corporateCustomer, GetCorporateCustomerResponse.class);
    }

    @Override
    public CreateCorporateCustomerResponse add(CreateCorporateCustomerRequest request) throws BusinessException {
        businessRules.checkIfRealCorporate(modelMapper.map(request, CheckRealCorporateRequest.class));
        businessRules.checkIfEmailOrCorporateNameIsNotUsed(request.getEmail(), request.getCorporateName());
        businessRules.checkIfSocialSecurityRegistrationNumberIsNotUsed(request.getSocialSecurityRegistrationNumber());

        CorporateCustomer corporateCustomer = modelMapper.map(request, CorporateCustomer.class);
        corporateCustomer.setId(0);
        CorporateCustomer savedCustomer = repository.save(corporateCustomer);
        return modelMapper.map(savedCustomer, CreateCorporateCustomerResponse.class);
    }

    @Override
    public UpdateCorporateCustomerResponse update(int customerId, UpdateCorporateCustomerRequest request) throws BusinessException {
        businessRules.checkIfRealCorporate(modelMapper.map(request, CheckRealCorporateRequest.class));
        CorporateCustomer oldCorporateCustomer = businessRules.checkIfEntityExistsByIdThenReturn(customerId);

        boolean wantToChangeEmail = !oldCorporateCustomer.getEmail().equals(request.getEmail());
        if(wantToChangeEmail)
            businessRules.checkIfEmailIsNotUsed(request.getEmail());

        boolean wantToChangeCorporateName = !oldCorporateCustomer.getCorporateName().equalsIgnoreCase(request.getCorporateName());
        if(wantToChangeCorporateName)
            businessRules.checkIfCorporateNameIsNotUsed(request.getCorporateName());

        boolean wantToChangeSSRN = !oldCorporateCustomer.getSocialSecurityRegistrationNumber().equals(request.getSocialSecurityRegistrationNumber());
        if(wantToChangeSSRN)
            businessRules.checkIfSocialSecurityRegistrationNumberIsNotUsed(request.getSocialSecurityRegistrationNumber());

        CorporateCustomer corporateCustomer = modelMapper.map(request, CorporateCustomer.class);
        corporateCustomer.setId(customerId);
        CorporateCustomer updatedCorporateCustomer = repository.save(corporateCustomer);
        return modelMapper.map(updatedCorporateCustomer, UpdateCorporateCustomerResponse.class);
    }

    @Override
    public void deleteById(int customerId) throws BusinessException {
        businessRules.checkIfEntityExistsById(customerId);
        repository.deleteById(customerId);
    }
}
