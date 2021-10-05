package br.com.estudo.api.cinema.estudo.controller;

import br.com.estudo.api.cinema.estudo.dto.*;
import br.com.estudo.api.cinema.estudo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinema")
public class CinemaController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private SessaoService sessaoService;

    @Autowired
    private VendaService vendaService;

    @Autowired
    private SalaService salaService;

    @Autowired
    private LoginService loginService;

    @PostMapping("/usuarios/cadastrar_cliente")
    public ResponseEntity<ClienteDto> cadastrarUsuario(@RequestBody ClienteDto clienteDto){
       return ResponseEntity.ok(clienteService.cadastrar(clienteDto));
    }

    @PostMapping("/sessoes")
    public ResponseEntity<SessaoDto> cadastrarSessao(@RequestBody SessaoDto sessaoDto){
        return ResponseEntity.ok(sessaoService.cadastrar(sessaoDto));
    }

    @GetMapping("/sessoes")
    public List<SessaoDto> consultarSessao(){
        var sessao = sessaoService.consultar();
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
    public List<VendaDto> consultarVendas(){
        return vendaService.consultarVendas();
    }


    @GetMapping("/salas")
    public List<SalaDto> consultarsalas(){
        return salaService.consultarSalas();
    }

    @PostMapping("/vendas")
    public ResponseEntity<VendaDto> cadastrarVenda(@RequestBody VendaDto vendaDto){
        return ResponseEntity.ok(vendaService.cadastrarVenda(vendaDto));
    }

    @PostMapping("/users/login")
    public ResponseEntity login(@RequestBody UserDto userDto){
        var login = loginService.validaLogin(userDto);
        if(login){
            return ResponseEntity.ok().build();
        } else {
            return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
    }
}