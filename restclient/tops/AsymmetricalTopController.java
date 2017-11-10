package com.nosipo.alfrescoclothing.restclient.tops;


import com.nosipo.alfrescoclothing.domain.tops.AsymmetricalTop;
import com.nosipo.alfrescoclothing.services.tops.AsymmetricalTopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AsymmetricalTopController
{
    @Autowired
    private AsymmetricalTopService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/asymmetricalTop/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AsymmetricalTop> createColdDrink(@RequestBody AsymmetricalTop asymmetricalTop) {
        service.create(asymmetricalTop);
        return new ResponseEntity<MexicanPizza>(asymmetricalTop, HttpStatus.CREATED);
    }

    /*
        READ
    * */
    @RequestMapping(value = "/asymmetricalTop/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AsymmetricalTop> readAsymmetricalTopID(@PathVariable("id") long id) {
        AsymmetricalTop asymmetricalTop = service.readById(id);
        if (asymmetricalTop == null) {
            return new ResponseEntity<AsymmetricalTop>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<AsymmetricalTop>(asymmetricalTop, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/asymmetricalTop/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<AsymmetricalTop>> findAllAsymmetricalTop() {
        Iterable<AsymmetricalTop> asymmetricalTop = service.readAll();
        if (asymmetricalTop == null) {
            return new ResponseEntity<Iterable<AsymmetricalTop>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<AsymmetricalTop>>(asymmetricalTop, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/asymmetricalTop/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AsymmetricalTop> updateAsymmetricalTop(@PathVariable("id") long id, @RequestBody AsymmetricalTop asymmetricalTop)
    {
        AsymmetricalTop currentTop = service.readById(id);
        if(currentTop == null)
        {
            return new ResponseEntity<AsymmetricalTop>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        AsymmetricalTop update = new AsymmetricalTop.Builder()
                .copy(currentTop)
                .name(asymmetricalTop.getName())
                .price(asymmetricalTop.getPrice())
                .colour(asymmetricalTop.getColour())
                .build();
        service.update(update);
        return new ResponseEntity<AsymmetricalTop>(update,HttpStatus.OK);
    }

    /*
        DELETE
    * */
    @RequestMapping(value = "/asymmetricalTop/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<AsymmetricalTop> deleteAsymmetricalTop(@PathVariable("id") long id)
    {
        Asymmetrical atop = service.readById(id);
        if(atop == null)
        {
            return new ResponseEntity<AsymmetricalTop>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(atop);
        return new ResponseEntity<AsymmetricalTop>(HttpStatus.NO_CONTENT);
    }
}
