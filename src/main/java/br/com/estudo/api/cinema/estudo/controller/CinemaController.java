package br.com.estudo.api.cinema.estudo.controller;

import br.com.estudo.api.cinema.estudo.dto.*;
import br.com.estudo.api.cinema.estudo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private SessaoService sessaoService;

    @Autowired
    private VendaService vendaService;

    @Autowired
    private SalaService salaService;

    @PostMapping("/usuarios/cadastrar_cliente")
    public ResponseEntity<ClienteDto> cadastrarUsuario(@RequestBody ClienteDto clienteDto){
       return ResponseEntity.ok(clienteService.cadastrar(clienteDto));
    }

    @PostMapping("/sessoes")
    public ResponseEntity<SessaoDto> cadastrarSessao(@RequestBody SessaoDto sessaoDto){
        return ResponseEntity.ok(sessaoService.cadastrar(sessaoDto));
    }

    @GetMapping("/sessoes")
    public Page<SessaoDto> consultarSessao(@RequestParam int pagina, int qtd){

        Pageable page = PageRequest.of(pagina, qtd);
        var sessao = sessaoService.consultar(page);
        return sessao;
    }

    @GetMapping("/sessoes/{titulo}")
    public ResponseEntity<SessaoDto> consultarSessaoPorTitulo(@PathVariable String titulo){
        var sessao = sessaoService.consultarPorTitulo(titulo);
        if(sessao == null){
           return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(sessao);
        }
    }

    @GetMapping("/vendas")
    public Page<VendaDto> consultarVendas(@RequestParam int pagina, int qtd){
        Pageable page = PageRequest.of(pagina, qtd);
        return vendaService.consultarVendas(page);
    }

    @GetMapping("/salas")
    public Page<SalaDto> consultarsalas(@RequestParam int pagina, int qtd){
        Pageable page = PageRequest.of(pagina, qtd);
        return salaService.consultarSalas(page);
    }

    @PostMapping("/vendas")
    public ResponseEntity<VendaDto> cadastrarVenda(@RequestBody VendaDto vendaDto){
        return ResponseEntity.ok(vendaService.cadastrarVenda(vendaDto));
    }
}