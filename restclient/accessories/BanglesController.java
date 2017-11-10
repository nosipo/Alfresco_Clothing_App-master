package com.nosipo.alfrescoclothing.restclient.accessories;


import com.nosipo.alfrescoclothing.domain.accessories.Bangles;
import com.watson.alfrescoclothing.services.accessories.BanglesService;
import org.nosipo.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BanglesController
{
    @Autowired
    private BnaglesService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/bangles/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<Bangles> createBangle(@RequestBody Bangle bangle) {
        service.create(bangle);
        return new ResponseEntity<Bangles>(bangle, HttpStatus.CREATED);
    }

    /*
        READ
    * */
    @RequestMapping(value = "/bangles/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Bangles> readBanglesByID(@PathVariable("id") long id) {
        Bangles ba = service.readById(id);
        if (ba == null) {
            return new ResponseEntity<Bangles>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Bangles>(ba, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/bangles/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Bangles>> findAllColdDrinks() {
        Iterable<Bangles> ban = service.readAll();
        if (ban == null) {
            return new ResponseEntity<Iterable<Bangles>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<Bangles>>(ban, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/bangles/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    public ResponseEntity<Bangles> updateBangles(@PathVariable("id") long id, @RequestBody Bangles bangles)
    {
        Bangles currentBangle = service.readById(id);
        if(currentBangle == null)
        {
            return new ResponseEntity<Bangles>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Bangles update = new Bangles.Builder()
                .copy(currentBangle)
                .name(bangles.getName())
                .colour(bangles.getColour())
                .price(bangles.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<Bangles>(update,HttpStatus.OK);
    }

    /*
        DELETE
    * */
    @RequestMapping(value = "/bangles/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Bangles> deleteBangles(@PathVariable("id") long id)
    {
        Bangles bang = service.readById(id);
        if(bang == null)
        {
            return new ResponseEntity<Bangles>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(bang);
        return new ResponseEntity<Bangles>(HttpStatus.NO_CONTENT);
    }
}
