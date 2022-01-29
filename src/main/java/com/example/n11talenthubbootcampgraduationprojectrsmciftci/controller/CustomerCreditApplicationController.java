package com.example.n11talenthubbootcampgraduationprojectrsmciftci.controller;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CreditApplicationDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.service.CreditScoreService;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.service.CreditService;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.service.CustomerService;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.validation.TurkishIdentityNumber;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/credit-application/")
@AllArgsConstructor
@Validated
public class CustomerCreditApplicationController {

    private CreditService creditService;


    @Operation(summary = "Saving a credit.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Saved the application to database.", content = {@Content(mediaType = "application/json")}
            ),
            @ApiResponse(
                    responseCode = "500",description = "When salary in database and in request didn't match.", content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",description = "When no-customer match with the Turkish identity number.", content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",description = "When the dto is cannot be validated.", content = @Content
            )
    })
    @PostMapping("")
    public ResponseEntity saveCreditApplicationAndSendSMSIfCustomerExistsIfNotSaveCustomerThenCreditApplicationAndSendSMS(
            @RequestBody @Valid CreditApplicationDto creditApplicationDto) {
            return creditService.saveCredit(creditApplicationDto);


    }

    @Operation(summary = "Finding credit application.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "When credit application has found.", content = {@Content(mediaType = "application/json")}
            ),
            @ApiResponse(
                    responseCode = "500",description = "When dateOfBirth is not in the correct form. It should be YYYY-MM-DD.", content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",description = "When Turkish identity number doesn't obey its algorithm.", content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",description = "When no-credit match with the Turkish identity number and date of birth of customer.", content = @Content
            )
    })
    @GetMapping("by-{turkishIdentityNumber}&{dateOfBirth}")
    public ResponseEntity findCreditApplication(@PathVariable("turkishIdentityNumber") @TurkishIdentityNumber String turkishIdentityNumber,
                                                @PathVariable("dateOfBirth") String dateOfBirth) {
        return creditService.findCreditApplication(turkishIdentityNumber, dateOfBirth);
    }
}