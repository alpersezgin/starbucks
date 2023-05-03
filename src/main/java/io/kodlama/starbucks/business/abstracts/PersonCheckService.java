package io.kodlama.starbucks.business.abstracts;

import io.kodlama.starbucks.business.dto.requests.CheckRealPersonRequest;
import io.kodlama.starbucks.core.utilities.exceptions.business.BusinessException;

public interface PersonCheckService {
    boolean checkRealPerson(CheckRealPersonRequest request) throws BusinessException;
}
