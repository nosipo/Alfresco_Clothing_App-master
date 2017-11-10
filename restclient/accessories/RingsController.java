package com.nosipo.alfrescoclothing.restclient.accessories;


import com.nosipo.alfrescoclothing.domain.accessories.Rings;
import com.nosipo.alfrescoclothing.services.accessories.RingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RingsController
{
    @Autowired
    private RingsService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/rings/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<Rings> createRings(@RequestBody Rings rings) {
        service.create(rings);
        return new ResponseEntity<Rings>(rings, HttpStatus.CREATED);
    }

    /*
        READ
    * */
    @RequestMapping(value = "/rings/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Rings> readRingsByID(@PathVariable("id") long id) {
        Rings ri = service.readById(id);
        if (ri == null) {
            return new ResponseEntity<Rings>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Rings>(ri, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/rings/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Rings>> findAllColdDrinks() {
        Iterable<Rings> rin = service.readAll();
        if (rin == null) {
            return new ResponseEntity<Iterable<Rings>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<Rings>>(rin, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/rings/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    public ResponseEntity<Rings> updateRings(@PathVariable("id") long id, @RequestBody Rings rings)
    {
        Rings currentRings = service.readById(id);
        if(currentRings == null)
        {
            return new ResponseEntity<Rings>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Rings update = new Rings.Builder()
                .copy(currentRings)
                .name(rings.getName())
                .colour(colour.getColour())
                .price(rings.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<Rings>(update,HttpStatus.OK);
    }

    /*
        DELETE
    * */
    @RequestMapping(value = "/rings/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Rings> deleteRings(@PathVariable("id") long id)
    {
        Rings rings = service.readById(id);
        if(rings == null)
        {
            return new ResponseEntity<Rings>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(rings);
        return new ResponseEntity<Rings>(HttpStatus.NO_CONTENT);
    }
}
