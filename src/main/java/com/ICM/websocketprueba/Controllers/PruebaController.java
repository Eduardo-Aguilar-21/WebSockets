package com.ICM.websocketprueba.Controllers;

import com.ICM.websocketprueba.Exceptions.ResourceNotFoundException;
import com.ICM.websocketprueba.Models.PruebaModel;
import com.ICM.websocketprueba.Services.PruebaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/prueba")
public class PruebaController {
    @Autowired
    PruebaService pruebaService;

    @GetMapping
    public List<PruebaModel> GetAll(){
        return pruebaService.GetAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PruebaModel> GetById(@PathVariable Long id){
        Optional<PruebaModel> prueba = pruebaService.GetById(id);
        if(prueba.isPresent()){
            return new ResponseEntity<>(prueba.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<PruebaModel> Save(@Valid @RequestBody PruebaModel pruebaModel){
        try{
            PruebaModel prueba = pruebaService.Save(pruebaModel);
            return new ResponseEntity<>(prueba, HttpStatus.CREATED);
        }catch (ResourceNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PruebaModel> CambioWS(@PathVariable Long id, @Valid @RequestBody PruebaModel pruebaModel){
        try {
            PruebaModel prueba = pruebaService.CambioWS(id, pruebaModel);
            return new ResponseEntity<>(prueba, HttpStatus.OK);
        } catch (ResourceNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
