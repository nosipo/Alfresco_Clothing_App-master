package com.nosipo.alfrescoclothing.restclient.tops;


import com.nosipo.alfrescoclothing.domain.tops.SplitSleevesTop;
import com.nosipo.alfrescoclothing.services.tops.SplitSleevesTopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class SplitSleevesController
{
    @Autowired
    private SplitSleevesService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/splitSleevesTop/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SplitSleevesTop> createSplitSleevesTop(@RequestBody SplitSleevesTop splitSleevesTop) {
        service.create(splitSleevesTop);
        return new ResponseEntity<SplitSleevesTop>(splitSleevesTop, HttpStatus.CREATED);
    }

    /*
        READ
    * */
    @RequestMapping(value = "/splitSleevesTop/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SplitSleevesTop> readSplitSleevesTopID(@PathVariable("id") long id) {
        SplitSleevesTop ssTop = service.readById(id);
        if (ssTop == null) {
            return new ResponseEntity<SplitSleevesTop>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<SplitSleevesTop>(ssTop, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/splitSleevesTop/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<SplitSleevesTop>> findAllColdDrinks() {
        Iterable<SplitSleevesTop> splitsTop = service.readAll();
        if (splitsTop == null) {
            return new ResponseEntity<Iterable<SplitSleevesTop>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<SplitSleevesTop>>(splitsTop, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/splitSleevesTop/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SplitSleevesTop> updateSplitSleevesTop(@PathVariable("id") long id, @RequestBody SplitSleevesTop splitSleevesTop)
    {
        SplitSleevesTop currentSplitTop = service.readById(id);
        if(currentSplitTop == null)
        {
            return new ResponseEntity<ChickenPizza>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        SplitSleevesTop update = new SplitSleevesTop.Builder()
                .copy(currentSplitTop)
                .name(splitSleevesTop.getName())
                .colour(splitSleevesTop.getColour())
                .price(splitSleevesTop.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<ChickenPizza>(update,HttpStatus.OK);
    }

    /*
        DELETE
    * */
    @RequestMapping(value = "/splitSleevesTop/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<SplitSleevesTop> deleteSplitSleevesTop(@PathVariable("id") long id)
    {
        SplitSleevesTop ssTop = service.readById(id);
        if(ssTop == null)
        {
            return new ResponseEntity<SplitSleevesTop>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(ssTop);
        return new ResponseEntity<SplitSleevesTop>(HttpStatus.NO_CONTENT);
    }
}
