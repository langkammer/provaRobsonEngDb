package br.com.robsonlangkammer.controller;

import br.com.robsonlangkammer.model.Cliente;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClienteController {

    @RequestMapping(path = "/cliente")
    public Cliente criaCliente(){
        return new Cliente(1l,"ROBSON","07416616670","MASCULINO");
    }
}
