package io.swagger.sample.resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.sample.data.ContactData;
import io.swagger.sample.models.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "contacts-xml")
@Slf4j
public class ContactPostXml {

    @ApiResponses({
        @ApiResponse(code = 200, message = "Nice!"),
        @ApiResponse(code = 400, message = "Invalid contact data supplied"),
        @ApiResponse(code = 404, message = "Contact not created")
    })
    @PostMapping(value = "/newContact", consumes = MediaType.APPLICATION_XML_VALUE)
    @ApiOperation(notes = "Create a new contact, returns it's ID", value = "Create a new contact using XML", nickname = "createNewContact")
    public void newContactNoResponse(@ApiParam(value = "Contact which should be created", required = true)
        @RequestBody(required = true) io.swagger.sample.models.Contact contact) {
        Contact newContact = ContactData.addContact(contact);
        log.info("**** new contact ****");
        log.info("contact name: {}", contact.getName());
        log.info("contact id: {}", contact.getId());
        log.info("******************");
    }
//    Not working yet, because of: https://github.com/syndesisio/syndesis/issues/2468    
//    @ApiResponses({
//        @ApiResponse(code = 200, message = "Nice!"),
//        @ApiResponse(code = 400, message = "Invalid contact data supplied"),
//        @ApiResponse(code = 404, message = "Contact not created")
//    })
//    @PostMapping(value = "/newContact", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
//    @ApiOperation(notes = "Create a new contact, returns it's ID", value = "Create a new contact using XML", nickname = "createNewContact")
//    public ResponseEntity<String> newContactResponse(@ApiParam(value = "Contact which should be created", required = true)
//        @RequestBody(required = true) io.swagger.sample.models.Contact contact
//    ) {
//        Contact newContact = ContactData.addContact(contact);
//        log.info("**** new contact ****");
//        log.info("contact name: {}", contact.getName());
//        log.info("contact id: {}", contact.getId());
//        log.info("******************");
//        return ResponseEntity.ok().body(String.valueOf(newContact.getId()));
//    }
}
