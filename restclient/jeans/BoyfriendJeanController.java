package com.nosipo.alfrescoclothing.restclient.jeans;


import com.nosipo.alfrescoclothing.domain.jeans.BoyfriendJean;
import com.nosipo.alfrescoclothing.services.jeans.BoyfriendJeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoyfriendJeanController
{
    @Autowired
    private BoyfriendJeanService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/boyfriendJean/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BoyfriendJean> createBoyfriendJean(@RequestBody BoyfriendJean boyfriendJean) {
        service.create(boyfriendJean);
        return new ResponseEntity<BoyfriendJean>(boyfriendJean, HttpStatus.CREATED);
    }

    /*
        READ
    * */
    @RequestMapping(value = "/boyfriendJean/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BoyfriendJean> readBoyfriendJeanID(@PathVariable("id") long id) {
        BoyfriendJean bfJean = service.readById(id);
        if (bfJean == null) {
            return new ResponseEntity<BoyfriendJean>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<BoyfriendJean>(bfJean, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/boyfriendJean/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<BoyfriendJean>> findAllBoyfriendJean() {
        Iterable<BoyfriendJean> boyfJean = service.readAll();
        if (boyfJean == null) {
            return new ResponseEntity<Iterable<BoyfriendJean>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<BoyfriendJean>>(boyfJean, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/boyfriendJean/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BoyfriendJean> updateColdDrink(@PathVariable("id") long id, @RequestBody BoyfriendJean boyfriendJean)
    {
        BoyfriendJean currentBoyfriendJean = service.readById(id);
        if(currentBoyfriendJean == null)
        {
            return new ResponseEntity<SteakGatsby>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        BoyfriendJean update = new BoyfriendJean.Builder()
                .copy(currentBoyfriendJean)
                .name(boyfriendJean.getName())
                .colour(boyfriendJean.getColour())
                .price(boyfriendJean.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<BoyfriendJean>(update,HttpStatus.OK);
    }

    /*
        DELETE
    * */
    @RequestMapping(value = "/boyfriendJean/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<BoyfriendJean> deleteBoyfriendJean(@PathVariable("id") long id)
    {
        BoyfriendJean bfriendJean = service.readById(id);
        if(bfriendJean == null)
        {
            return new ResponseEntity<BoyfriendJean>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(bfriendJean);
        return new ResponseEntity<BoyfriendJean>(HttpStatus.NO_CONTENT);
    }
}
