package io.swagger.sample.resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.sample.data.ContactData;
import io.swagger.sample.exception.NotFoundException;
import io.swagger.sample.models.Contact;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "contacts-xml")
@Slf4j
public class ContactGetXml {

    @ApiResponses({
        @ApiResponse(code = 200, message = "Nice!"),
        @ApiResponse(code = 400, message = "Invalid contact data supplied"),
        @ApiResponse(code = 404, message = "Contact not created")
    })
    @ApiOperation(notes = "Gets contact by id in XML format", value = "Get contact by ID in XML", nickname = "getContactXml",
        tags = {"Contact"})
    @GetMapping(value = "/contact/{contactId}", produces = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Contact> getContactById(@ApiParam(value = "ID of contact that needs to be fetched", required = true)
        @PathVariable(value = "contactId") Integer contactId) throws Exception {
        Contact contact = ContactData.getContactById(contactId);
        if (contact != null) {
            log.info("**** get ****");
            log.info("contact name: {}", contact.getName());
            log.info("contact id: {}", contact.getId());
            log.info("*************");
            return ResponseEntity.ok().body(contact);
        } else {
            throw new NotFoundException(io.swagger.sample.models.ApiResponse.ERROR, "Contact " + contactId + " not found");
        }
    }

    @ApiResponses({
        @ApiResponse(code = 200, message = "Nice!"),
        @ApiResponse(code = 400, message = "Invalid contact data supplied"),
        @ApiResponse(code = 404, message = "Contact not created")
    })
    @ApiOperation(notes = "Gets all contacts in XML format", value = "Get all contacts in XML", nickname = "listAll",
        tags = {"Contact"})
    @GetMapping(value = "/listAll", produces = {MediaType.APPLICATION_XML_VALUE})
    public List<Contact> getContactById() {
        List<Contact> contacts = ContactData.getAllContacts();
        log.info("**** All contact ****");
        for (Contact p : contacts) {
            log.info("contact name: {}", p.getName());
            log.info("contact id: {}", p.getId());
            log.info("*************");
        }
        return contacts;
    }
}
