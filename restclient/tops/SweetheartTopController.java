package com.nosipo.alfrescoclothing.restclient.tops;


import com.nosipo.alfrescoclothing.domain.tops.SweetheartTop;
import com.nosipo.alfrescoclothing.services.tops.SweetheartTopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SweetheartTopController
{
    @Autowired
    private SweetheartTopService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/sweetheartTop/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SweetheartTop> createColdDrink(@RequestBody SweetheartTop sweetheartTop) {
        service.create(sweetheartTop);
        return new ResponseEntity<SweetheartTop>(sweetheartTop, HttpStatus.CREATED);
    }

    /*
        READ
    * */
    @RequestMapping(value = "/sweetheartTop/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SweetaheartTop> readSweetheartTopByID(@PathVariable("id") long id) {
        SweethearTop shTop = service.readById(id);
        if (shTop == null) {
            return new ResponseEntity<SweetheartTop>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<SweetheartTop>(shTop, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/sweetheartTop/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<SweetheartTop>> findAllColdDrinks() {
        Iterable<SweetheartTop> sweetheartTop = service.readAll();
        if (sweetheartTop == null) {
            return new ResponseEntity<Iterable<SweetheartTop>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<SweetheartTop>>(sweetheartTop, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/sweetheartTop/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SweetheartTop> updateSweetheartTop(@PathVariable("id") long id, @RequestBody SweethearTop sweethearTop)
    {
        SweetheartTop currentshTop = service.readById(id);
        if(currentshTop == null)
        {
            return new ResponseEntity<SweetheartTop>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        SweetheartTop update = new SweetheartTop.Builder()
                .copy(currentshTop)
                .name(sweethearTop.getName())
                .colour(sweethearTop.getColour())
                .price(sweethearTop.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<SweetheartTop>(update,HttpStatus.OK);
    }

    /*
        DELETE
    * */
    @RequestMapping(value = "/sweetheartTop/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<SweethearTop> deleteSweetheartTop(@PathVariable("id") long id)
    {
        SweethearTop sweethTop = service.readById(id);
        if(sweethTop == null)
        {
            return new ResponseEntity<SweethearTop>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(sweethTop);
        return new ResponseEntity<SweethearTop>(HttpStatus.NO_CONTENT);
    }
}
