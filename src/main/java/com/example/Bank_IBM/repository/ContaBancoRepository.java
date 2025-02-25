package com.example.Bank_IBM.repository;


import com.example.Bank_IBM.model.ContaBanco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaBancoRepository extends JpaRepository<ContaBanco, Integer> {
}
