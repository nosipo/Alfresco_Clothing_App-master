package com.nosipo.alfrescoclothing.restclient.jeans;


import com.nosipo.alfrescoclothing.domain.jeans.SkinnyJean;
import com.nosipo.alfrescoclothing.services.jeans.SkinnyJeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SkinnyJeanController
{
    @Autowired
    private SkinnyJeanService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/skinnyJean/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SkinnyJean> createSkinnyJean(@RequestBody SkinnyJean skinnyJean) {
        service.create(skinnyJean);
        return new ResponseEntity<SkinnyJean>(skinnyJean, HttpStatus.CREATED);
    }

    /*
        READ
    * */
    @RequestMapping(value = "/skinnyJean/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SkinnyJean> readSkinnyJeanByID(@PathVariable("id") long id) {
        SkinnyJean sJean = service.readById(id);
        if (sJean == null) {
            return new ResponseEntity<SkinnyJean>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<SkinnyJean>(sJean, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/skinnyJean/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<SkinnyJean>> findAllSkinnyJean() {
        Iterable<SkinnyJean> skinJean = service.readAll();
        if (skinJean == null) {
            return new ResponseEntity<Iterable<SkinnyJean>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<SkinnyJean>>(skinJean, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/skinnyJean/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SkinnyJean> updateSkinnyJean(@PathVariable("id") long id, @RequestBody SkinnyJean skinnyJean)
    {
        SkinnyJean currentSkinnyJean = service.readById(id);
        if(currentSkinnyJean == null)
        {
            return new ResponseEntity<SkinnyJean>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        SkinnyJean update = new SkinnyJean.Builder()
                .copy(currentSkinnyJean)
                .name(skinnyJean.getName())
                .colour(skinnyJean.getColour())
                .price(skinnyJean.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<SkinnyJean>(update,HttpStatus.OK);
    }

    /*
        DELETE
    * */
    @RequestMapping(value = "/skinnyJean/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<SkinnyJean> deleteSinnyJean(@PathVariable("id") long id)
    {
        SkinnyJean snJean = service.readById(id);
        if(snJean == null)
        {
            return new ResponseEntity<SkinnyJean>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(snJean);
        return new ResponseEntity<SkinnyJean>(HttpStatus.NO_CONTENT);
    }
}
