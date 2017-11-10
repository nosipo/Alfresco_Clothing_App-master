package com.nosipo.alfrescoclothing.restclient.dresses;


import com.nosipo.alfrescoclothing.domain.dresses.MaxiDress;
import com.nosipo.alfrescoclothing.services.dresses.MaxiDressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MaxiDressController
{
    @Autowired
    private MaxiDressService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/maxiDress/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MaxiDress> createMaxiDress(@RequestBody MaxiDress maxiDress) {
        service.create(maxiDress);
        return new ResponseEntity<MaxiDress>(maxiDress, HttpStatus.CREATED);
    }

    /*
        READ
    * */
    @RequestMapping(value = "/maxiDress/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<MaxiDress> readMaxiDressByID(@PathVariable("id") long id) {
        MaxiDress mDress = service.readById(id);
        if (mDress == null) {
            return new ResponseEntity<MaxiDress>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<MaxiDress>(mDress, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/maxiDress/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<MaxiDress>> findAllMaxiDress() {
        Iterable<MaxiDress> maDress = service.readAll();
        if (maDress == null) {
            return new ResponseEntity<Iterable<MaxiDress>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<MaxiDress>>(maDress, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/maxiDress/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MaxiDress> updateColdDrink(@PathVariable("id") long id, @RequestBody MaxiDress maxiDress)
    {
        MaxiDress currentMaxiDress = service.readById(id);
        if(currentMaxiDress == null)
        {
            return new ResponseEntity<MaxiDress>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        MaxiDress update = new MaxiDress.Builder()
                .copy(currentMaxiDress)
                .name(maxiDress.getName())
                .colour(maxiDress.getColour())
                .price(maxiDress.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<MaxiDress>(update,HttpStatus.OK);
    }

    /*
        DELETE Burger
    * */
    @RequestMapping(value = "/maxiDress/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<MaxiDress> deleteMaxiDress(@PathVariable("id") long id)
    {
        MaxiDress maxDress = service.readById(id);
        if(maxDress == null)
        {
            return new ResponseEntity<MaxiDress>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(maxDress);
        return new ResponseEntity<MaxiDress>(HttpStatus.NO_CONTENT);
    }
}
