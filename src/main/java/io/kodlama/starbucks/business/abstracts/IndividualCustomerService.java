package io.kodlama.starbucks.business.abstracts;

import io.kodlama.starbucks.business.dto.requests.create.CreateIndividualCustomerRequest;
import io.kodlama.starbucks.business.dto.requests.update.UpdateIndividualCustomerRequest;
import io.kodlama.starbucks.business.dto.responses.create.CreateIndividualCustomerResponse;
import io.kodlama.starbucks.business.dto.responses.get.GetAllIndividualCustomersResponse;
import io.kodlama.starbucks.business.dto.responses.get.GetIndividualCustomerResponse;
import io.kodlama.starbucks.business.dto.responses.update.UpdateIndividualCustomerResponse;
import io.kodlama.starbucks.core.utilities.exceptions.business.BusinessException;

import java.util.List;

public interface IndividualCustomerService {
    public List<GetAllIndividualCustomersResponse> getAll();

    public GetIndividualCustomerResponse getById(int customerId) throws BusinessException;

    public CreateIndividualCustomerResponse add(CreateIndividualCustomerRequest request) throws BusinessException;

    public UpdateIndividualCustomerResponse update(int customerId, UpdateIndividualCustomerRequest request) throws BusinessException;

    public void deleteById(int customerId) throws BusinessException;
}
