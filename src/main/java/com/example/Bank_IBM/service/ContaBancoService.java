package com.example.Bank_IBM.service;


import com.example.Bank_IBM.model.ContaBanco;
import com.example.Bank_IBM.repository.ContaBancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.Bank_IBM.model.ContaBanco;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ContaBancoService {
    private Map<Integer, ContaBanco> contas = new HashMap<>();
    private int proximoNumConta = 1;

    public ContaBanco abrirConta(String tipo, String nome) {
        int numConta = proximoNumConta++;
        ContaBanco conta = new ContaBanco(numConta, tipo, nome);
        conta.setStatus(true);

        if (tipo.equals("Corrente")) {
            conta.setSaldo(50); // Bônus para conta corrente
        } else if (tipo.equals("Poupança")) {
            conta.setSaldo(150); // Bônus para conta poupança
        }

        contas.put(numConta, conta);
        return conta;
    }

    public ContaBanco depositar(int numConta, float valor) {
        ContaBanco conta = contas.get(numConta);
        if (conta != null && conta.isStatus() && valor > 0) {
            conta.setSaldo(conta.getSaldo() + valor);
        }
        return conta;
    }

    public ContaBanco sacar(int numConta, float valor) {
        ContaBanco conta = contas.get(numConta);
        if (conta != null && conta.isStatus() && valor > 0 && conta.getSaldo() >= valor) {
            conta.setSaldo(conta.getSaldo() - valor);
        }
        return conta;
    }

    public ContaBanco pagarMensal(int numConta) {
        ContaBanco conta = contas.get(numConta);
        if (conta != null && conta.isStatus()) {
            float taxa = conta.getTipo().equals("Corrente") ? 12 : 20;
            if (conta.getSaldo() >= taxa) {
                conta.setSaldo(conta.getSaldo() - taxa);
            }
        }
        return conta;
    }

    public boolean fecharConta(int numConta) {
        ContaBanco conta = contas.get(numConta);
        if (conta != null && conta.isStatus() && conta.getSaldo() == 0) {
            conta.setStatus(false);
            return true;
        }
        return false;
    }

    public ContaBanco getConta(int numConta) {
        return contas.get(numConta);
    }
}