package com.amigoscode;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    //Normalmente se faz um dto por questões de segurança

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }

    public SoftwareEngineer insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
        return softwareEngineer;
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id).
                orElseThrow(() -> new IllegalStateException(id + "not found"));
    }

    public SoftwareEngineer deleteSoftwareEngineer(Integer id) {
        if (!softwareEngineerRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Software Engineer with id " + id + " not found"
            );
        }

        SoftwareEngineer deletedSoftwareEnginner = getSoftwareEngineerById(id);
        softwareEngineerRepository.deleteById(id);
        return deletedSoftwareEnginner;
    }

    public SoftwareEngineer updateSoftwareEngineerByID(Integer id, SoftwareEngineer update) {
        SoftwareEngineer softwareEngineer = getSoftwareEngineerById(id);

        if (update.getName() != null && !update.getName().isBlank()) {
            softwareEngineer.setName(update.getName());
        }

        if (update.getTechStack() != null && !update.getTechStack().isBlank()) {
            softwareEngineer.setTechStack(update.getTechStack());
        }
        softwareEngineerRepository.save(softwareEngineer);
        return softwareEngineer;
    }
}
