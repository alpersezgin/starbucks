package io.kodlama.starbucks.core.rules;

import io.kodlama.starbucks.core.utilities.exceptions.business.BusinessErrorCode;
import io.kodlama.starbucks.core.utilities.exceptions.business.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseBusinessRules<E, T extends JpaRepository<E, Integer>> {
    private String repositoryName;
    private T repository;
    public void checkIfEntityExistsById(int id) throws BusinessException{
        if(repository.existsById(id)) return;
        throwNotExistError(id);
    }

    public E checkIfEntityExistsByIdThenReturn(int id) throws BusinessException{
        var optionalT = repository.findById(id);
        if(optionalT.isEmpty()) throwNotExistError(id);
        return optionalT.get();
    }

    private void throwNotExistError(int id) throws BusinessException{
        throw new BusinessException(BusinessErrorCode.NotExists, "No data exists in repository '" + repositoryName +"' with id " + id);
    }
}
