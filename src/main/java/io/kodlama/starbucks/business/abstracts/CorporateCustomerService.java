package io.kodlama.starbucks.business.abstracts;

import io.kodlama.starbucks.business.dto.requests.create.CreateCorporateCustomerRequest;
import io.kodlama.starbucks.business.dto.requests.update.UpdateCorporateCustomerRequest;
import io.kodlama.starbucks.business.dto.responses.create.CreateCorporateCustomerResponse;
import io.kodlama.starbucks.business.dto.responses.get.GetAllCorporateCustomersResponse;
import io.kodlama.starbucks.business.dto.responses.get.GetCorporateCustomerResponse;
import io.kodlama.starbucks.business.dto.responses.update.UpdateCorporateCustomerResponse;
import io.kodlama.starbucks.core.utilities.exceptions.business.BusinessException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CorporateCustomerService {
    public List<GetAllCorporateCustomersResponse> getAll();

    public GetCorporateCustomerResponse getById(int customerId) throws BusinessException;

    public CreateCorporateCustomerResponse add(CreateCorporateCustomerRequest request) throws BusinessException;

    public UpdateCorporateCustomerResponse update(int customerId, UpdateCorporateCustomerRequest request) throws BusinessException;

    public void deleteById(int customerId) throws BusinessException;
}
