package com.nosipo.alfrescocloting.restclient.accessories;


import com.nosipo.alfrescocloting.domain.accessories.Scarves;
import com.nosipo.alfrescocloting.services.accessories.ScarvesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScarvesController
{
    @Autowired
    private ScarvesService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/scarves/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<Scarves> createColdDrink(@RequestBody Scareves scarves) {
        service.create(scarves);
        return new ResponseEntity<Scarves>(scarves, HttpStatus.CREATED);
    }

    /*
        READ
    * */
    @RequestMapping(value = "/scarves/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Scarves> readScarvesByID(@PathVariable("id") long id) {
        Scarves scar = service.readById(id);
        if (scar == null) {
            return new ResponseEntity<Scarves>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Scarves>(scar, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/scarves/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Scarves>> findAllScarves() {
        Iterable<Scarves> sc = service.readAll();
        if (sc == null) {
            return new ResponseEntity<Iterable<Scarves>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<Scarves>>(sc, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/scarves/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    public ResponseEntity<Scarves> updateScarves(@PathVariable("id") long id, @RequestBody Scarves scarves)
    {
        Scarves currentScarves = service.readById(id);
        if(currentScarves == null)
        {
            return new ResponseEntity<Scarves>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Scarves update = new Scarves.Builder()
                .copy(currentScarves)
                .name(scarves.getName())
                .colour(scarves.getColour())
                .price(scarves.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<Scarves>(update,HttpStatus.OK);
    }

    /*
        DELETE
    * */
    @RequestMapping(value = "/scarves/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Scarves> deleteScarves(@PathVariable("id") long id)
    {
        Scarves scarves = service.readById(id);
        if(scarves == null)
        {
            return new ResponseEntity<Scarves>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(scarves);
        return new ResponseEntity<Scarves>(HttpStatus.NO_CONTENT);
    }
}
