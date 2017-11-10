package com.nosipo.alfrescoclothing.restclient.dresses;


import com.nosipo.alfrescoclothing.domain.dresses.MiniDress;
import com.nosipo.alfrescoclothing.services.dresses.MiniDressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MiniDressController
{
    @Autowired
    private MiniDressService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/miniDress/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MiniDress> createMiniDress(@RequestBody MiniDress miniDress) {
        service.create(miniDress);
        return new ResponseEntity<MiniDress>(miniDress, HttpStatus.CREATED);
    }

    /*
        READ SINGLE Drink
    * */
    @RequestMapping(value = "/miniDress/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<MiniDress> readMiniDressByID(@PathVariable("id") long id) {
        MiniDress miDress = service.readById(id);
        if (miDress == null) {
            return new ResponseEntity<MiniDress>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<MiniDress>(miDress, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/miniDress/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<MiniDress>> findAllMiniDress() {
        Iterable<MiniDress> minDress = service.readAll();
        if (minDress == null) {
            return new ResponseEntity<Iterable<MiniDress>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<MiniDress>>(minDress, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/miniDress/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MiniDress> updateMiniDress(@PathVariable("id") long id, @RequestBody MiniDress miniDress)
    {
        MiniDress currentMiniDress = service.readById(id);
        if(currentMiniDress == null)
        {
            return new ResponseEntity<MiniDress>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        MiniDress update = new MiniDress.Builder()
                .copy(currentMiniDress)
                .name(miniDress.getName())
                .colour(miniDress.getColour())
                .price(miniDress.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<MiniDress>(update,HttpStatus.OK);
    }

    /*
        DELETE
    * */
    @RequestMapping(value = "/miniDress/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<MiniDress> deleteMiniDress(@PathVariable("id") long id)
    {
        MiniDress mnDress = service.readById(id);
        if(mnDress == null)
        {
            return new ResponseEntity<MiniDress>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(mnDress);
        return new ResponseEntity<MiniDress>(HttpStatus.NO_CONTENT);
    }
}
