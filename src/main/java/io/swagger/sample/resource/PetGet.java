package io.swagger.sample.resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.sample.data.PetData;
import io.swagger.sample.models.Pet;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "pets")
public class PetGet extends AbstractResource {

    @ApiResponses({
        @ApiResponse(code = 200, message = "Nice!"),
        @ApiResponse(code = 400, message = "Invalid pet data supplied"),
        @ApiResponse(code = 404, message = "Pet not created")
    })
    @PostMapping(value = "/newPet", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    @ApiOperation(notes = "Creates a new Pet.", value = "Create a new pet, returns it's ID", nickname = "createNewPet")
    public String newPet(@ApiParam(value = "ID of pet that needs to be fetched", required = true)
        @RequestBody io.swagger.sample.models.Pet pet) {
        Pet newPet = PetData.addPet(pet);
        return String.valueOf(newPet.getId());
    }
}
