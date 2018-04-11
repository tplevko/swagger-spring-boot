package io.swagger.sample.resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.sample.data.PetData;
import io.swagger.sample.exception.NotFoundException;
import io.swagger.sample.models.Pet;
import javax.ws.rs.core.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PetResource extends AbstractResource {

    private static PetData data = new PetData();

    @ApiOperation(notes = "Returns a pet when a pet with specified ID exists. Non-integers will simulate API error conditions", value = "Find pet by ID", nickname = "getPetById",
        tags = {"Pet"})
    @ApiResponses({
        @ApiResponse(code = 200, message = "Nice!", response = Pet.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied", response = io.swagger.sample.models.ApiResponse.class),
        @ApiResponse(code = 404, message = "Pet not found", response = io.swagger.sample.models.ApiResponse.class)
    })
    @RequestMapping(value = "/pet/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ResponseEntity<Pet> getPetById(@ApiParam(value = "ID of pet that needs to be fetched", required = true)
        @PathVariable("id") Integer petId) throws Exception {
        Pet pet = data.getPetById(petId);
        if (pet != null) {
            return ResponseEntity.ok().body(pet);
        } else {
            throw new NotFoundException(io.swagger.sample.models.ApiResponse.ERROR, "Pet " + petId + " not found");
        }
    }

    @ApiOperation(notes = "Creates a new Pet.", value = "Create a new pet, returns it's ID", nickname = "createNewPet",
        tags = {"Pet"})
    @ApiResponses({
        @ApiResponse(code = 200, message = "Nice!", response = Pet.class),
        @ApiResponse(code = 400, message = "Invalid pet data supplied", response = io.swagger.sample.models.ApiResponse.class),
        @ApiResponse(code = 404, message = "Pet not created", response = io.swagger.sample.models.ApiResponse.class)
    })
    @RequestMapping(value = "/pet/new", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML},
        produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Pet form(Pet pet) {
        Pet newPet = data.addPet(pet);
        return newPet;
    }
}
