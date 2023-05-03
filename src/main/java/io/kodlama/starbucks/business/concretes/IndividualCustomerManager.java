package io.kodlama.starbucks.business.concretes;

import io.kodlama.starbucks.business.abstracts.IndividualCustomerService;
import io.kodlama.starbucks.business.dto.requests.CheckRealPersonRequest;
import io.kodlama.starbucks.business.dto.requests.create.CreateIndividualCustomerRequest;
import io.kodlama.starbucks.business.dto.requests.update.UpdateIndividualCustomerRequest;
import io.kodlama.starbucks.business.dto.responses.create.CreateIndividualCustomerResponse;
import io.kodlama.starbucks.business.dto.responses.get.GetAllIndividualCustomersResponse;
import io.kodlama.starbucks.business.dto.responses.get.GetIndividualCustomerResponse;
import io.kodlama.starbucks.business.dto.responses.update.UpdateIndividualCustomerResponse;
import io.kodlama.starbucks.business.rules.IndividualCustomerBusinessRules;
import io.kodlama.starbucks.core.utilities.exceptions.business.BusinessException;
import io.kodlama.starbucks.entity.concretes.IndividualCustomer;
import io.kodlama.starbucks.repository.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IndividualCustomerManager implements IndividualCustomerService {
    private final IndividualCustomerRepository repository;
    private final ModelMapper modelMapper;
    private final IndividualCustomerBusinessRules businessRules;


    @Override
    public List<GetAllIndividualCustomersResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(individualCustomer -> modelMapper.map(individualCustomer, GetAllIndividualCustomersResponse.class))
                .toList();
    }

    @Override
    public GetIndividualCustomerResponse getById(int customerId) throws BusinessException {
        IndividualCustomer individualCustomer = businessRules.checkIfEntityExistsByIdThenReturn(customerId);
        return modelMapper.map(individualCustomer, GetIndividualCustomerResponse.class);
    }

    @Override
    public CreateIndividualCustomerResponse add(CreateIndividualCustomerRequest request) throws BusinessException {
        businessRules.checkIfEmailIsNotUsed(request.getEmail());
        businessRules.checkIfRealPerson(modelMapper.map(request, CheckRealPersonRequest.class));
        businessRules.checkIfNationalIdentityIsNotUsed(request.getNationalIdentity());

        IndividualCustomer individualCustomer = modelMapper.map(request, IndividualCustomer.class);
        individualCustomer.setId(0);
        IndividualCustomer savedIndividualCustomer = repository.save(individualCustomer);
        return modelMapper.map(savedIndividualCustomer, CreateIndividualCustomerResponse.class);
    }

    @Override
    public UpdateIndividualCustomerResponse update(int customerId, UpdateIndividualCustomerRequest request) throws BusinessException {
        businessRules.checkIfRealPerson(modelMapper.map(request, CheckRealPersonRequest.class));
        IndividualCustomer oldIndividualCustomer = businessRules.checkIfEntityExistsByIdThenReturn(customerId);

        boolean wantToChangeEmail = !oldIndividualCustomer.getEmail().equals(request.getEmail());
        if(wantToChangeEmail)
            businessRules.checkIfEmailIsNotUsed(request.getEmail());

        boolean wantToChangeNationalIdentity = !oldIndividualCustomer.getNationalIdentity().equals(request.getNationalIdentity());
        if(wantToChangeNationalIdentity)
            businessRules.checkIfNationalIdentityIsNotUsed(request.getNationalIdentity());

        IndividualCustomer individualCustomer = modelMapper.map(request, IndividualCustomer.class);
        individualCustomer.setId(customerId);
        IndividualCustomer updatedIndividualCustomer = repository.save(individualCustomer);
        return modelMapper.map(updatedIndividualCustomer, UpdateIndividualCustomerResponse.class);
    }

    @Override
    public void deleteById(int customerId) throws BusinessException {
        businessRules.checkIfEntityExistsById(customerId);
        repository.deleteById(customerId);
    }
}
