package com.zirius.zerp.controller;


import com.zirius.zerp.service.ZiriusMigrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company-migration")
public class CompanyDataMigrationController {

    @Autowired
    private ZiriusMigrationService ziriusMigrationService;


    @GetMapping("/companyData")
    public ResponseEntity<Boolean> updateCompanyDataFromZerpToPlus(@RequestParam("organizationNumber") String organizationNumber, @RequestParam("filePath") String path) {
        System.out.println("Received request for companyId: " + organizationNumber);
        try {
            boolean response = ziriusMigrationService.updateCompanyData(organizationNumber, path);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(false);
        }
    }

}
