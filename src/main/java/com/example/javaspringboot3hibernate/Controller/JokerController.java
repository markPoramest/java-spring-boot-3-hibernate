package com.example.javaspringboot3hibernate.Controller;

import com.example.javaspringboot3hibernate.Dao.JokerRepository;
import com.example.javaspringboot3hibernate.Model.Joker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joker/api")
public class JokerController {
    @Autowired
    private JokerRepository jokerRepository;
    @GetMapping("/findAll")
    public List<Joker> findAll(){
        return jokerRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Joker findbyID(@PathVariable Integer id){
        return jokerRepository.findById(id);
    }

    @PostMapping
    public boolean insert(@RequestBody Joker joker){
        return jokerRepository.insert(joker);
    }

    @PostMapping("/update/{id}")
    public void delete(@PathVariable Integer id, @RequestBody Joker joker){
        jokerRepository.update(id,joker);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        jokerRepository.delete(id);
    }


}
