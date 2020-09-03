package com.example.javaspringboot3hibernate.Controller;

import com.example.javaspringboot3hibernate.Dao.JokerRepository;
import com.example.javaspringboot3hibernate.Model.Joker;
import com.example.javaspringboot3hibernate.Service.JokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joker/api")
public class JokerController {
    @Autowired
    private JokerService jokerService;
    @GetMapping("/findAll")
    public List<Joker> findAll(){
        return jokerService.findAll();
    }

    @GetMapping("/find/{id}")
    public Joker findbyID(@PathVariable Integer id){
        return jokerService.findbyID(id);
    }

    @PostMapping
    public boolean insert(@RequestBody Joker joker){
        return jokerService.insert(joker);
    }

    @PostMapping("/update/{id}")
    public void update(@PathVariable Integer id, @RequestBody Joker joker){
        jokerService.update(id,joker);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        jokerService.delete(id);
    }


}
