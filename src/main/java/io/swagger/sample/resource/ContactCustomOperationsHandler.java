package io.swagger.sample.resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.sample.data.ContactData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tplevko
 */
@RestController
@RequestMapping(value = "contact")
@Slf4j
public class ContactCustomOperationsHandler {

    @ApiResponses({
        @ApiResponse(code = 200, message = "Nice!"),
        @ApiResponse(code = 400, message = "Invalid contact data supplied"),
        @ApiResponse(code = 404, message = "Contact not created")
    })
    @ApiOperation(notes = "Delete all contacts", value = "Delete all contacts", nickname = "deleteAll",
        tags = {"Contact"})
    @GetMapping(value = "/deleteAllContacts")
    public void deleteAllContact() {
        ContactData.deleteAllContacts();
        log.info("*************");
        log.info("all contacts deleted");
        log.info("*************");
    }
}
