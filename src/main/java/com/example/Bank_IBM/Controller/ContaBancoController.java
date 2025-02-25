package com.example.Bank_IBM.Controller;


import com.example.Bank_IBM.model.ContaBanco;
import com.example.Bank_IBM.service.ContaBancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;



import com.example.Bank_IBM.model.ContaBanco;
import com.example.Bank_IBM.service.ContaBancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas")
public class ContaBancoController {
    @Autowired
    private ContaBancoService contaService;

    @PostMapping("/abrir")
    public ContaBanco abrirConta(@RequestParam String tipo, @RequestParam String nome) {
        return contaService.abrirConta(tipo, nome);
    }

    @PostMapping("/depositar")
    public ContaBanco depositar(@RequestParam int numConta, @RequestParam float valor) {
        return contaService.depositar(numConta, valor);
    }

    @PostMapping("/sacar")
    public ContaBanco sacar(@RequestParam int numConta, @RequestParam float valor) {
        return contaService.sacar(numConta, valor);
    }

    @PostMapping("/pagar-mensal")
    public ContaBanco pagarMensal(@RequestParam int numConta) {
        return contaService.pagarMensal(numConta);
    }

    @PostMapping("/fechar")
    public boolean fecharConta(@RequestParam int numConta) {
        return contaService.fecharConta(numConta);
    }

    @GetMapping("/info")
    public ContaBanco getConta(@RequestParam int numConta) {
        return contaService.getConta(numConta);
    }
}