package com.amigoscode;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getEngineers() {
        return softwareEngineerService.getAllSoftwareEngineers();

    }

    @GetMapping("{id}")
    public SoftwareEngineer getEngineerById(
          @PathVariable Integer id
    ) {
        return softwareEngineerService.getSoftwareEngineerById(id);

    }

    @PostMapping
    //normalmente é um dto (data transfer object)
    public SoftwareEngineer addNewSoftwareEngineer( @RequestBody SoftwareEngineer softwareEngineer) {
        return softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }

    @DeleteMapping("{id}")
    public SoftwareEngineer deleteSoftwareEngineer(@PathVariable Integer id) {
        return softwareEngineerService.deleteSoftwareEngineer(id);
    }

    @PutMapping("{id}")
    public SoftwareEngineer updateSoftwareEngineerByID(@PathVariable Integer id, @RequestBody SoftwareEngineer softwareEngineer) {
        return softwareEngineerService.updateSoftwareEngineerByID(id, softwareEngineer);
    }
}
