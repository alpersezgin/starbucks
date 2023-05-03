package io.kodlama.starbucks.api.controllers.v1;


import io.kodlama.starbucks.business.abstracts.IndividualCustomerService;
import io.kodlama.starbucks.business.dto.requests.create.CreateIndividualCustomerRequest;
import io.kodlama.starbucks.business.dto.requests.update.UpdateIndividualCustomerRequest;
import io.kodlama.starbucks.business.dto.responses.create.CreateIndividualCustomerResponse;
import io.kodlama.starbucks.business.dto.responses.get.GetAllIndividualCustomersResponse;
import io.kodlama.starbucks.business.dto.responses.get.GetIndividualCustomerResponse;
import io.kodlama.starbucks.business.dto.responses.update.UpdateIndividualCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/individual/customers")
public class IndividualCustomerController {
    private final IndividualCustomerService service;

    @GetMapping
    public List<GetAllIndividualCustomersResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetIndividualCustomerResponse getById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CreateIndividualCustomerResponse add(@Valid @RequestBody CreateIndividualCustomerRequest request){
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateIndividualCustomerResponse update(@PathVariable int id, @Valid @RequestBody UpdateIndividualCustomerRequest request){
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        service.deleteById(id);
    }
}
