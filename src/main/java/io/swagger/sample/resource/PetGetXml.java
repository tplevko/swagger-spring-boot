package io.swagger.sample.resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.sample.data.PetData;
import io.swagger.sample.exception.NotFoundException;
import io.swagger.sample.models.Pet;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "pets-xml")
@Slf4j
public class PetGetXml {

    @ApiResponses({
        @ApiResponse(code = 200, message = "Nice!"),
        @ApiResponse(code = 400, message = "Invalid pet data supplied"),
        @ApiResponse(code = 404, message = "Pet not created")
    })
    @ApiOperation(notes = "Gets pet by id in XML format", value = "Get pet by ID in XML", nickname = "getPet",
        tags = {"Pet"})
    @GetMapping(value = "/pet/{petId}", produces = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Pet> getPetById(@ApiParam(value = "ID of pet that needs to be fetched", required = true)
        @PathVariable(value = "petId") Integer petId) throws Exception {
        Pet pet = PetData.getPetById(petId);
        if (pet != null) {
            log.info("**** get ****");
            log.info("pet name: {}", pet.getName());
            log.info("pet id: {}", pet.getId());
            log.info("*************");
            return ResponseEntity.ok().body(pet);
        } else {
            throw new NotFoundException(io.swagger.sample.models.ApiResponse.ERROR, "Pet " + petId + " not found");
        }
    }

    @ApiResponses({
        @ApiResponse(code = 200, message = "Nice!"),
        @ApiResponse(code = 400, message = "Invalid pet data supplied"),
        @ApiResponse(code = 404, message = "Pet not created")
    })
    @ApiOperation(notes = "Gets all pets in XML format", value = "Get all pets in XML", nickname = "listAll",
        tags = {"Pet"})
    @GetMapping(value = "/listAll", produces = {MediaType.APPLICATION_XML_VALUE})
    public List<Pet> getPetById() {
        List<Pet> pets = PetData.getAllPets();
        log.info("**** All pets ****");
        for (Pet p : pets) {
            log.info("pet name: {}", p.getName());
            log.info("pet id: {}", p.getId());
            log.info("*************");
        }
        return pets;
    }
}
