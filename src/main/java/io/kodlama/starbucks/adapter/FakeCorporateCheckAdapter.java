package io.kodlama.starbucks.adapter;

import io.kodlama.starbucks.business.abstracts.CorporateCheckService;
import io.kodlama.starbucks.business.dto.requests.CheckRealCorporateRequest;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FakeCorporateCheckAdapter implements CorporateCheckService {
    @Override
    public boolean checkRealCorporate(CheckRealCorporateRequest request) {
        return new Random().nextFloat() > .5;
    }
}
