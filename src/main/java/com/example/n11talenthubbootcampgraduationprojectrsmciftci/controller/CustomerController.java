package com.example.n11talenthubbootcampgraduationprojectrsmciftci.controller;


import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CustomerDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CustomerSavingDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Customer;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.service.CreditScoreService;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.service.CustomerService;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.service.SmsService;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.validation.TurkishIdentityNumber;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/customers/")
@AllArgsConstructor
@Validated
@CrossOrigin
public class CustomerController {

    private CustomerService customerService;
    private CreditScoreService creditScoreService;


    @Operation(summary = "Saving a customer.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Saved the customer to database.",
                    content = {@Content(mediaType = "application/json")}
            ),
            @ApiResponse(
                    responseCode = "500",description = "When identity number is not unique.", content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",description = "When @RequestBody is not validated.", content = @Content
            )


    })
    @PostMapping("")
    public Customer save(@RequestBody @Valid CustomerSavingDto customerSavingDto){
        return customerService.save(customerSavingDto);
    }
    @Operation(summary = "Deleting a customer.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "returns updated customer",
                    content = {@Content(mediaType = "application/json")}
            ),
            @ApiResponse(
                    responseCode = "500",description = "When no customer's id match with the request id.", content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",description = "When any of the field is not validated." , content = @Content
            )
    })
    @PutMapping("")
    public Customer update(@RequestBody @Valid CustomerDto customerDto){
        return customerService.update(customerDto);
    }

    @Operation(summary = "Deleting a customer.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "returns the message:Customer Successfully Deleted",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",description = "Turkish identity number is not validated.", content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",description = "Turkish identity number & Date of birth didn't match " +
                    "or date of birth is not in the form of YYYY-MM-DD.", content = @Content
            )
    })
    @DeleteMapping("delete-by-{turkishIdentityNumber}&{dateOfBirth}")
    public ResponseEntity deleteCustomer(@PathVariable @TurkishIdentityNumber String turkishIdentityNumber, @PathVariable String dateOfBirth){
        return customerService.delete(turkishIdentityNumber,LocalDate.parse(dateOfBirth));
    }

    @Operation(summary = "Returns APPROVED/REJECTED, no matter if customer already saved in database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "returns approved/rejected",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",description = "Turkish identity number is not validated.", content = @Content
            )
    })
    @GetMapping("{turkishIdentityNumber}")
    public String findCreditScoreEnum(@PathVariable  @TurkishIdentityNumber String turkishIdentityNumber){
        return creditScoreService.getCreditScoreEnum(turkishIdentityNumber).toString();
    }

}
