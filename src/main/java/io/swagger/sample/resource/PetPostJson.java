package io.swagger.sample.resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.sample.data.PetData;
import io.swagger.sample.models.Pet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "pets-json")
@Slf4j
public class PetPostJson {

    @ApiResponses({
        @ApiResponse(code = 200, message = "Nice!"),
        @ApiResponse(code = 400, message = "Invalid pet data supplied"),
        @ApiResponse(code = 404, message = "Pet not created")
    })
    @PostMapping(value = "/newPet", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "Create a new pet, nothing returned", value = "Create a new pet using JSON, no return value", nickname = "createNewPet")
    public void newPetNoResponse(@ApiParam(value = "Pet which should be created", required = true)
        @RequestBody(required = true) io.swagger.sample.models.Pet body) {
        Pet newPet = PetData.addPet(body);
        log.info("**** new pet ****");
        log.info("pet name: {}", newPet.getName());
        log.info("pet id: {}", newPet.getId());
        log.info("******************");
    }

    @ApiResponses({
        @ApiResponse(code = 200, message = "Nice!"),
        @ApiResponse(code = 400, message = "Invalid pet data supplied"),
        @ApiResponse(code = 404, message = "Pet not created")
    })
    @PostMapping(value = "/newPet-return", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "Create a new pet, returns it's ID", value = "Create a new pet using JSON, return value - ID", nickname = "createNewPet")
    public ResponseEntity<String> newPetResponse(@ApiParam(value = "Pet which should be created", required = true)
        @RequestBody(required = true) io.swagger.sample.models.Pet body) {
        Pet newPet = PetData.addPet(body);
        log.info("**** new pet ****");
        log.info("pet name: {}", newPet.getName());
        log.info("pet id: {}", newPet.getId());
        log.info("******************");
        return ResponseEntity.ok().body(String.valueOf(newPet.getId()));
    }
}
