package io.kodlama.starbucks.adapter.mernis;

import io.kodlama.starbucks.adapter.mernis.webService.MEEKPSPublicSoap;
import io.kodlama.starbucks.business.abstracts.PersonCheckService;
import io.kodlama.starbucks.business.dto.requests.CheckRealPersonRequest;
import io.kodlama.starbucks.core.utilities.exceptions.business.BusinessErrorCode;
import io.kodlama.starbucks.core.utilities.exceptions.business.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MernisServiceAdapter implements PersonCheckService {
    MEEKPSPublicSoap service;
    @Override

    public boolean checkRealPerson(CheckRealPersonRequest request) throws BusinessException {
        long tcNo;
        try{
            tcNo = Long.parseLong(request.getNationalIdentity());
        }catch (NumberFormatException numberFormatException){
            throw new BusinessException(BusinessErrorCode.UnsuitableState, "National identity is invalid.");
        }

        try{
            return service.TCKimlikNoDogrula(tcNo, request.getFirstName().toUpperCase(), request.getLastName().toUpperCase(), request.getBirthDate().getYear() );
        }
        catch (Exception exception){
            throw new BusinessException(BusinessErrorCode.Unknown, "An unknown error occured on mernis: " + exception.getMessage());
        }
    }
}
