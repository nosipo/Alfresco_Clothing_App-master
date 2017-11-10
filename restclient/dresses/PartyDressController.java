package com.nosipo.alfrescoclothing.restclient.dresses;


import com.nosipo.alfrescoclothing.domain.dresses.PartyDress;
import com.nosipo.alfrescoclothing.services.dresses.PartyDressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PartyDressController
{
    @Autowired
    private PartyDressService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/partyDress/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PartyDress> createColdDrink(@RequestBody PartyDress partyDress) {
        service.create(partyDress);
        return new ResponseEntity<PartyDress>(partyDress, HttpStatus.CREATED);
    }

    /*
        READ
    * */
    @RequestMapping(value = "/partyDress/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<PartyDress> readPartyDressByID(@PathVariable("id") long id) {
        PartyDress pDress = service.readById(id);
        if (pDress == null) {
            return new ResponseEntity<PartyDress>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<PartyDress>(pDress, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/partyDress/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<PartyDress>> findAllPartyDress() {
        Iterable<PartyDress> paDress = service.readAll();
        if (paDress == null) {
            return new ResponseEntity<Iterable<PartyDress>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<PartyDress>>(paDress, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/partyDress/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PartyDress> updatePartyDress(@PathVariable("id") long id, @RequestBody PartyDress partyDress)
    {
        PartyDress currentPartyDress = service.readById(id);
        if(currentPartyDress == null)
        {
            return new ResponseEntity<PartyDress>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        PartyDress update = new PartyDress.Builder()
                .copy(currentPartyDress)
                .name(partyDress.getName())
                .colour(partyDress.getColour())
                .price(partyDress.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<PartyDress>(update,HttpStatus.OK);
    }

    /*
        DELETE
    * */
    @RequestMapping(value = "/partyDress/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<PartyDress> deletePartyDress(@PathVariable("id") long id)
    {
        PartyDress parDress = service.readById(id);
        if(parDress == null)
        {
            return new ResponseEntity<PartyDress>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(parDress);
        return new ResponseEntity<PartyDress>(HttpStatus.NO_CONTENT);
    }
}
