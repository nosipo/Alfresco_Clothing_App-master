package com.nosipo.alfrescoclothing.restclient.jeans;


import com.nosipo.alfrescoclothing.domain.jeans.BootcutJean;
import com.nosipo.alfrescoclothing.services.jeans.BootcutJeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BootcutJeanController
{
    @Autowired
    private BootcutJeanService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/bootcutJean/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BootcutJean> createBootcutJean(@RequestBody BootcutJean bootcutJean) {
        service.create(bootcutJean);
        return new ResponseEntity<BootcutJean>(bootcutJean, HttpStatus.CREATED);
    }

    /*
        READ
    * */
    @RequestMapping(value = "/bootcutJean/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BootcutJean> readBootcutJeanByID(@PathVariable("id") long id) {
        BootcutJean bJean = service.readById(id);
        if (bJean == null) {
            return new ResponseEntity<BootcutJean>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<BootcutJean>(bJean, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/bootcutJean/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<BootcutJean>> findAllBootcutJean() {
        Iterable<BootcutJean> bootcutJean = service.readAll();
        if (bootcutJean == null) {
            return new ResponseEntity<Iterable<BootcutJean>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<BootcutJean>>(bootcutJean, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/bootcutJean/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BootcutJean> updateBootcutJean(@PathVariable("id") long id, @RequestBody BootcutJean bootcutJean)
    {
        BootcutJean currentBootcutJean = service.readById(id);
        if(currentBurger == null)
        {
            return new ResponseEntity<BootcutJean>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        BootcutJean update = new BootcutJean.Builder()
                .copy(currentBootcutJean)
                .name(bootcutJean.getName())
                .colour(bootcutJean.getColour())
                .price(bootcutJean.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<BootcutJean>(update,HttpStatus.OK);
    }

    /*
        DELETE
    * */
    @RequestMapping(value = "/bootcutJean/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<BootcutJean> deleteBootcutDrink(@PathVariable("id") long id)
    {
        BootcutJean bcJean = service.readById(id);
        if(bcJean == null)
        {
            return new ResponseEntity<BootcutJean>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(bcJean);
        return new ResponseEntity<BootcutJean>(HttpStatus.NO_CONTENT);
    }
}
