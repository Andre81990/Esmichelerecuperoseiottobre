package com.example.Esmichelerecuperoseiottobre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrdineRepository extends JpaRepository<Ordine,Long> {

    //optional--->oggetto
//tutti quelli che cercano qualcosa con una
// where--da un risultato nullo--->vuoto


    List<Ordine> save();



}
