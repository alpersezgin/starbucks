package io.kodlama.starbucks.api.controllers.v1;

import io.kodlama.starbucks.business.abstracts.CorporateCustomerService;
import io.kodlama.starbucks.business.dto.requests.create.CreateCorporateCustomerRequest;
import io.kodlama.starbucks.business.dto.requests.update.UpdateCorporateCustomerRequest;
import io.kodlama.starbucks.business.dto.responses.create.CreateCorporateCustomerResponse;
import io.kodlama.starbucks.business.dto.responses.get.GetAllCorporateCustomersResponse;
import io.kodlama.starbucks.business.dto.responses.get.GetCorporateCustomerResponse;
import io.kodlama.starbucks.business.dto.responses.update.UpdateCorporateCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Version;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/corporate/customers")
public class CorporateCustomerController {
    private final CorporateCustomerService service;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<GetAllCorporateCustomersResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public GetCorporateCustomerResponse getById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CreateCorporateCustomerResponse add(@Valid @RequestBody CreateCorporateCustomerRequest request){
        return service.add(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public UpdateCorporateCustomerResponse update(@PathVariable int id, @Valid @RequestBody UpdateCorporateCustomerRequest request){
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id){
        service.deleteById(id);
    }
}
