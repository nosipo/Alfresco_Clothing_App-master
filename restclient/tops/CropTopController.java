package com.nosipo.alfrescoclothing.restclient.tops;


import com.nosipo.alfrescoclothing.domain.tops.CropTop;
import com.nosipo.alfrescoclothing.services.tops.CropTopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CropTopController
{
    @Autowired
    private CropTopService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/cropTop/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CropTop> createColdDrink(@RequestBody CropTop crTop) {
        service.create(crTop);
        return new ResponseEntity<CropTop>(crTop, HttpStatus.CREATED);
    }

    /*
        READ
    * */
    @RequestMapping(value = "/cropTop/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CropTop> readCropTopID(@PathVariable("id") long id) {
        CropTop cropTop = service.readById(id);
        if (cropTop == null) {
            return new ResponseEntity<CropTop>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CropTop>(cropTop, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/cropTop/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<CropTop>> findAllCropTop() {
        Iterable<CropTop> cTop = service.readAll();
        if (cTop == null) {
            return new ResponseEntity<Iterable<CropTop>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<CropTop>>(cTop, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/cropTop/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CropTop> updateCropTop(@PathVariable("id") long id, @RequestBody CropTop crTop)
    {
        CropTop currentCropTop = service.readById(id);
        if(currentCropTop == null)
        {
            return new ResponseEntity<CropTop>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        CropTop update = new CropTop.Builder()
                .copy(currentCropTop)
                .name(crTop.getName())
                .colour(crTop.getColour())
                .price(crTop.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<CropTop>(update,HttpStatus.OK);
    }

    /*
        DELETE
    * */
    @RequestMapping(value = "/cropTop/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<CropTop> deleteCropTop(@PathVariable("id") long id)
    {
        CropTop cropTop = service.readById(id);
        if(cropTop == null)
        {
            return new ResponseEntity<CropTop>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(cropTop);
        return new ResponseEntity<CropTop>(HttpStatus.NO_CONTENT);
    }
}
