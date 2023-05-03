package io.kodlama.starbucks.business.abstracts;

import io.kodlama.starbucks.business.dto.requests.CheckRealCorporateRequest;

public interface CorporateCheckService {
    boolean checkRealCorporate(CheckRealCorporateRequest request);
}
