package br.com.robsonlangkammer.controller;

import br.com.robsonlangkammer.bean.EvenlopResponse;
import br.com.robsonlangkammer.bean.PesquisaClienteBean;
import br.com.robsonlangkammer.dao.ClienteDao;
import br.com.robsonlangkammer.model.Cliente;
import br.com.robsonlangkammer.repository.ClienteRepository;
import br.com.robsonlangkammer.repository.VendedorRepository;
import br.com.robsonlangkammer.util.ResponseFactory;
import org.springframework.web.bind.annotation.*;


@RestController
public class ClienteController extends ResponseFactory {

    private final ClienteRepository clienteRepository;

    private final VendedorRepository vendedorRepository;

    private final ClienteDao clienteDao;

    ClienteController(ClienteRepository clienteRepository,VendedorRepository vendedorRepository,ClienteDao clienteDao) {
        this.clienteRepository = clienteRepository;
        this.vendedorRepository = vendedorRepository;
        this.clienteDao = clienteDao;

    }

    @PostMapping(path = "/cliente/listar")
    public EvenlopResponse list(@RequestBody PesquisaClienteBean p){
        try{
            return returnEnvelopSucesso(clienteDao.listar(p.getCampoPesquisado(),p.getPesquisa()),"Operação Realizada com Sucesso");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a Operaçãp " + e.getMessage());

        }
    }

    @PostMapping(path = "/cliente/create")
    public EvenlopResponse create(@RequestBody Cliente cliente){
        try{
            return returnEnvelopSucesso(clienteRepository.save(cliente),"Operação Realizada com sucesso!");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a operacao " + e.getMessage());

        }

    }

    @GetMapping(path = "/cliente/get/{id}")
    public EvenlopResponse get(@PathVariable Long id){

        try{
            clienteRepository.findById(id).get();
            return returnEnvelopSucesso(clienteRepository.findById(id).get(),"Operação Realizada com sucesso!");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a operacao " + e.getMessage());

        }
    }

    @GetMapping(path = "/cliente/delete/{id}")
    public EvenlopResponse delete(@PathVariable Long id){

        try{
            clienteRepository.deleteById(id);
            return returnEnvelopSucesso(null,"Operação Realizada com sucesso!");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a operacao " + e.getMessage());

        }
    }


//    @GetMapping(path = "/cliente/getVendedorByClienteId/{idVendedor}")
//    public List<Cliente> getVendedorByClienteId(@PathVariable Long idVendedor){
//        Optional<Cliente> cliente = repository.findById(id);
//        return cliente.get();
//    }
}
