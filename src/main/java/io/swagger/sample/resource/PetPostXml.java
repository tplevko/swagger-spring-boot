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
@RequestMapping(value = "pets-xml")
@Slf4j
public class PetPostXml {

    @ApiResponses({
        @ApiResponse(code = 200, message = "Nice!"),
        @ApiResponse(code = 400, message = "Invalid pet data supplied"),
        @ApiResponse(code = 404, message = "Pet not created")
    })
    @PostMapping(value = "/newPet", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    @ApiOperation(notes = "Create a new pet, returns it's ID", value = "Create a new pet using XML", nickname = "createNewPet")
    public ResponseEntity<String> newPet(@ApiParam(value = "Pet which should be created", required = true)
        @RequestBody(required = true) io.swagger.sample.models.Pet pet) {
        Pet newPet = PetData.addPet(pet);
        log.info("**** new pet ****");
        log.info("pet name: {}", pet.getName());
        log.info("pet id: {}", pet.getId());
        log.info("******************");
        return ResponseEntity.ok().body(String.valueOf(newPet.getId()));
    }
}
