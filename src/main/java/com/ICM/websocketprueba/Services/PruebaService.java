package com.ICM.websocketprueba.Services;

import com.ICM.websocketprueba.Exceptions.ResourceNotFoundException;
import com.ICM.websocketprueba.Models.PruebaModel;
import com.ICM.websocketprueba.Repositories.PruebaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PruebaService {
    @Autowired
    PruebaRepository pruebaRepository;

    public List<PruebaModel> GetAll(){
        return pruebaRepository.findAll();
    }

    public Optional<PruebaModel> GetById(Long id){
        return pruebaRepository.findById(id);
    }

    public  PruebaModel Save(PruebaModel pruebaModel){
        try{
            return pruebaRepository.save(pruebaModel);
        }catch (Exception ex){
            throw new ResourceNotFoundException("Error al guardar el recurso: " + ex.getMessage());
        }
    }

    public PruebaModel CambioWS(Long id, PruebaModel pruebaModel){
        Optional<PruebaModel> existing = pruebaRepository.findById(id);

        if(existing.isPresent()){
            PruebaModel prueba = existing.get();
            prueba.setMensaje(pruebaModel.getMensaje());
            prueba.setAumentador(pruebaModel.getAumentador());
            return pruebaRepository.save(prueba);
        } else {
            throw new ResourceNotFoundException("No se encontro el recurso con Id " + id);
        }
    }
}
