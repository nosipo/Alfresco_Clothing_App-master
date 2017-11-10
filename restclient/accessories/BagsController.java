package com.nosipo.alfrescoclothing.restclient.accessories;


import com.nosipo.alfrescoclothing.domain.accessories.Bags;
import com.nosipo.alfrescoclothing.services.accessories.BagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BagsController
{
    @Autowired
    private BagsService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/bags/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<Bags> createBag(@RequestBody Bags bags) {
        service.create(bags);
        return new ResponseEntity<Bags>(bags, HttpStatus.CREATED);
    }

    /*
        READ
    * */
    @RequestMapping(value = "/bags/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Bags> readBagsByID(@PathVariable("id") long id) {
        Bags b = service.readById(id);
        if (b == null) {
            return new ResponseEntity<Bags>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Bags>(b, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/bags/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Bags>> findAllBags() {
        Iterable<Bags> ba = service.readAll();
        if (ba == null) {
            return new ResponseEntity<Iterable<Bags>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<Bags>>(ba, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/bags/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    public ResponseEntity<Bags> updateBags(@PathVariable("id") long id, @RequestBody Bags bags)
    {
        Bags currentBag = service.readById(id);
        if(currentBag == null)
        {
            return new ResponseEntity<Bags>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Bags update = new Bags.Builder()
                .copy(currentBag)
                .name(bags.getName())
                .colour(bags.getColour())
                .price(bags.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<Bags>(update,HttpStatus.OK);
    }

    /*
        DELETE
    * */
    @RequestMapping(value = "/bags/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Bags> deleteBag(@PathVariable("id") long id)
    {
        Bags bag = service.readById(id);
        if(bag == null)
        {
            return new ResponseEntity<Bags>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(bag);
        return new ResponseEntity<Bags>(HttpStatus.NO_CONTENT);
    }
}
