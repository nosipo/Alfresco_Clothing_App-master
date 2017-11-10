package com.nosipo.alfrescoclothing.restclient.jeans;


import com.nosipo.alfrescoclothing.domain.jeans.HighwaistJean;
import com.nosipo.alfrescoclothing.services.jeans.HighwasitJeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HighwaistJeanController
{
    @Autowired
    private HighwaistJeanService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/highwaistJean/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HighwaistJean> createHighwaistJean(@RequestBody HighwaistJean highwaistJean) {
        service.create(highwaistJean);
        return new ResponseEntity<HighwaistJean>(highwaistJean, HttpStatus.CREATED);
    }

    /*
        READ
    * */
    @RequestMapping(value = "/highwaistJean/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<HighwaistJean> readHighwaistJeanID(@PathVariable("id") long id) {
        HighwaistJean hJean = service.readById(id);
        if (hJean == null) {
            return new ResponseEntity<HighwaistJean>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<HighwaistJean>(hJean, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/highwaistJean/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<HighwaistJean>> findAllHighwaistJean() {
        Iterable<HighwaistJean> hwJean = service.readAll();
        if (hwJean == null) {
            return new ResponseEntity<Iterable<HighwaistJean>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<HighwaistJean>>(hwJean, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/highwaistJean/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HighwaistJean> updateHighwaistJean(@PathVariable("id") long id, @RequestBody HighwaistJean highwaistJean)
    {
        HighwaistJean currentHighwaistJean = service.readById(id);
        if(currentHighwaistJean == null)
        {
            return new ResponseEntity<HighwaistJean>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        HighwaistJean update = new HighwaistJean.Builder()
                .copy(currentHighwaistJean)
                .name(highwaistJean.getName())
                .colour(highwaistJean.getColour())
                .price(highwaistJean.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<HighwaistJean>(update,HttpStatus.OK);
    }

    /*
        DELETE
    * */
    @RequestMapping(value = "/highwaistJean/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<HighwaistJean> deleteHighwaistJean(@PathVariable("id") long id)
    {
        HighwaistJean highwJean = service.readById(id);
        if(highwJean == null)
        {
            return new ResponseEntity<HighwaistJean>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(highwJean);
        return new ResponseEntity<HighwaistJean>(HttpStatus.NO_CONTENT);
    }
}
