package io.kodlama.starbucks.business.concretes;

import io.kodlama.starbucks.business.abstracts.PersonCheckService;
import io.kodlama.starbucks.business.dto.requests.CheckRealPersonRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonCheckManager implements PersonCheckService {
    @Override
    public boolean checkRealPerson(CheckRealPersonRequest request) {
        return true;
    }
}
