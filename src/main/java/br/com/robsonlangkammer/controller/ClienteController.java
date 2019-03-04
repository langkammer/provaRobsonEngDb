package br.com.robsonlangkammer.controller;

import br.com.robsonlangkammer.model.Cliente;
import br.com.robsonlangkammer.repository.ClienteRepository;
import br.com.robsonlangkammer.repository.VendedorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ClienteController {

    private final ClienteRepository clienteRepository;

    private final VendedorRepository vendedorRepository;

    ClienteController(ClienteRepository clienteRepository,VendedorRepository vendedorRepository) {
        this.clienteRepository = clienteRepository;
        this.vendedorRepository = vendedorRepository;

    }

    @GetMapping(path = "/cliente/listar")
    public List<Cliente> list(){
        List<Cliente> todosClientes = clienteRepository.findAll();

        return todosClientes;
    }

    @PostMapping(path = "/cliente/create")
    public Cliente create(@RequestBody Cliente cliente){
        vendedorRepository.saveAndFlush(cliente.getVendedor());
        return clienteRepository.save(cliente);
    }

    @GetMapping(path = "/cliente/get/{id}")
    public Cliente get(@PathVariable Long id){
        return clienteRepository.findById(id).get();
    }

    @GetMapping(path = "/cliente/delete/{id}")
    public void delete(@PathVariable Long id){
        clienteRepository.deleteById(id);
    }


//    @GetMapping(path = "/cliente/getVendedorByClienteId/{idVendedor}")
//    public List<Cliente> getVendedorByClienteId(@PathVariable Long idVendedor){
//        Optional<Cliente> cliente = repository.findById(id);
//        return cliente.get();
//    }
}
