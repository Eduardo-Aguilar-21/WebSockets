package com.ICM.websocketprueba.Controllers;

import com.ICM.websocketprueba.Models.Mensaje;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MensajeController {
    @MessageMapping("/envio")
    @SendTo("/tema/mensajes")
    public Mensaje envio(Mensaje mensaje){
        return new Mensaje(mensaje.nombre(), mensaje.contenido());
    }
}
