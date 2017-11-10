package com.nosipo.alfrescoclothing.restclient.accessories;


import com.nosipo.alfrescoclothing.domain.accessories.Earrings;
import com.nosipo.alfrescoclothing.services.accessories.EarringsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EarringsController {
    @Autowired
    private EarringsService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/earrings/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<Earrings> createEarrings(@RequestBody Earrings earrings) {
        service.create(earrings);
        return new ResponseEntity<Earrings>(earrings, HttpStatus.CREATED);
    }

    /*
        READ
    * */
    @RequestMapping(value = "/earrings/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Earrings> readEarringsByID(@PathVariable("id") long id) {
        Earrings ea = service.readById(id);
        if (ea == null) {
            return new ResponseEntity<Earrings>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Earrings>(ea, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/earrings/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Earrings>> findAllEarrings() {
        Iterable<Earrings> ear = service.readAll();
        if (ear == null) {
            return new ResponseEntity<Iterable<Earrings>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<Earrings>>(ear, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/earrings/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    public ResponseEntity<Earrings> updateColdDrink(@PathVariable("id") long id, @RequestBody Earrings earrings)
    {
        Earrings currentEarrings = service.readById(id);
        if(currentEarrings == null)
        {
            return new ResponseEntity<Earrings>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Earrings update = new Earrings.Builder()
                .copy(currentEarrings)
                .name(earrings.getName())
                .colour(earrings.getColour())
                .price(earrings.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<Earrings>(update,HttpStatus.OK);
    }

    /*
        DELETE
    * */
    @RequestMapping(value = "/earrings/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Earrings> deleteEarrings(@PathVariable("id") long id)
    {
        Earrings earr = service.readById(id);
        if(earr == null)
        {
            return new ResponseEntity<Earrings>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(earr);
        return new ResponseEntity<Earrings>(HttpStatus.NO_CONTENT);
    }

}

