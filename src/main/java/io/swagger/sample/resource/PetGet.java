package io.swagger.sample.resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.sample.data.PetData;
import io.swagger.sample.exception.NotFoundException;
import io.swagger.sample.models.Pet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "pets")
@Slf4j
public class PetGet extends AbstractResource {

    @ApiOperation(notes = "gets pet by id.", value = "get pet by ID", nickname = "getPet",
        tags = {"Pet"})
    @ApiResponses({
        @ApiResponse(code = 200, message = "Nice!"),
        @ApiResponse(code = 400, message = "Invalid pet data supplied"),
        @ApiResponse(code = 404, message = "Pet not created")
    })
    @GetMapping(value = "/pet/{id}", produces = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Pet> getPetById(@ApiParam(value = "ID of pet that needs to be fetched", required = true)
        @PathVariable("id") Integer petId) throws Exception {
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
}
