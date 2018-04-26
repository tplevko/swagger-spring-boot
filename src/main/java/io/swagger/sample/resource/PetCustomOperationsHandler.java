package io.swagger.sample.resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.sample.data.PetData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tplevko
 */
@RestController
@RequestMapping(value = "pets")
@Slf4j
public class PetCustomOperationsHandler {

    @ApiResponses({
        @ApiResponse(code = 200, message = "Nice!"),
        @ApiResponse(code = 400, message = "Invalid pet data supplied"),
        @ApiResponse(code = 404, message = "Pet not created")
    })
    @ApiOperation(notes = "Delete all pets", value = "Delete all pets", nickname = "deleteAll",
        tags = {"Pet"})
    @GetMapping(value = "/deleteAllPets")
    public void deleteAllPets() {
        PetData.deleteAllPets();
        log.info("*************");
        log.info("all pets deleted");
        log.info("*************");
    }
}
