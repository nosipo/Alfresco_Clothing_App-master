package com.nosipo.alfrescoclothing.restclient.dresses;


import com.nosipo.alfrescoclothing.domain.dresses.FlaredDress;
import com.nosipo.alfrescoclothing.services.dresses.FlaredDressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FlaredDressController
{
    @Autowired
    private FlaredDressService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/flaredDress/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FlaredDress> createFlaredDress(@RequestBody FlaredDress flaredDress) {
        service.create(flaredDress);
        return new ResponseEntity<FlaredDress>(flaredDress, HttpStatus.CREATED);
    }

    /*
        READ
    * */
    @RequestMapping(value = "/flaredDress/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<FlaredDress> readFlaredDressByID(@PathVariable("id") long id) {
        FlaredDress fDress = service.readById(id);
        if (fDress == null) {
            return new ResponseEntity<FlaredDress>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<FlaredDress>(fDress, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/flaredDress/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<FlaredDress>> findAllFlaredDress() {
        Iterable<FlaredDress> flDress = service.readAll();
        if (flDress == null) {
            return new ResponseEntity<Iterable<FlaredDress>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<FlaredDress>>(flDress, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/flaredDress/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FlaredDress> updateFlaredDress(@PathVariable("id") long id, @RequestBody FlaredDress flaredDress)
    {
        FlaredDress currentFlaredDress = service.readById(id);
        if(currentFlaredDress == null)
        {
            return new ResponseEntity<FlaredDress>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        FlaredDress update = new FlaredDress.Builder()
                .copy(currentFlaredDress)
                .name(flaredDress.getName())
                .colour(flaredDress.getColour())
                .price(flaredDress.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<FlaredDress>(update,HttpStatus.OK);
    }

    /*
        DELETE
    * */
    @RequestMapping(value = "/flaredDress/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<FlaredDress> deleteFlaredDress(@PathVariable("id") long id)
    {
        FlaredDress fdDress = service.readById(id);
        if(fdDress == null)
        {
            return new ResponseEntity<FlaredDress>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(fdDress);
        return new ResponseEntity<FlaredDress>(HttpStatus.NO_CONTENT);
    }
}
