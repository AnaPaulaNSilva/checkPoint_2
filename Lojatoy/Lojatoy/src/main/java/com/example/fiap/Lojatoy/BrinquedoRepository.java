package com.example.fiap.Lojatoy;


/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
 
/**
*
* @author MSWagner
*/
 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface BrinquedoRepository extends CrudRepository<Brinquedo, Long>{
}


