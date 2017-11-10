package com.nosipo.alfrescoclothing.restclient.dresses;


import com.nosipo.alfrescoclothing.domain.dresses.LaceDress;
import com.nosipo.alfrescoclothing.services.dresses.LaceDressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LaceDressController
{
    @Autowired
    private LaceDressService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/laceDress/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LaceDress> createLaceDress(@RequestBody LaceDress laceDress) {
        service.create(laceDress);
        return new ResponseEntity<LaceDress>(laceDress, HttpStatus.CREATED);
    }

    /*
        READ
    * */
    @RequestMapping(value = "/laceDress/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<LaceDress> readLaceDressByID(@PathVariable("id") long id) {
        LaceDress lDress = service.readById(id);
        if (lDress == null) {
            return new ResponseEntity<LaceDress>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<LaceDress>(lDress, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/laceDress/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<LaceDress>> findAllLaceDress() {
        Iterable<LaceDress> lcDress = service.readAll();
        if (lcDress == null) {
            return new ResponseEntity<Iterable<LaceDress>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<LaceDress>>(lcDress, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/laceDress/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LaceDress> updateLaceDress(@PathVariable("id") long id, @RequestBody LaceDress laceDress)
    {
        LaceDress currentLaceDress = service.readById(id);
        if(currentLaceDress == null)
        {
            return new ResponseEntity<LaceDress>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        LaceDress update = new LaceDress.Builder()
                .copy(currentLaceDress)
                .name(laceDress.getName())
                .colour(laceDress.getColour())
                .price(laceDress.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<LaceDress>(update,HttpStatus.OK);
    }

    /*
        DELETE
    * */
    @RequestMapping(value = "/laceDress/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<LaceDress> deleteLaceDress(@PathVariable("id") long id)
    {
        LaceDress laDress = service.readById(id);
        if(laDress == null)
        {
            return new ResponseEntity<LaceDress>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(laDress);
        return new ResponseEntity<LaceDress>(HttpStatus.NO_CONTENT);
    }
}
