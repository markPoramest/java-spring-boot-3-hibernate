package com.example.javaspringboot3hibernate.Service;

import com.example.javaspringboot3hibernate.Dao.JokerRepository;
import com.example.javaspringboot3hibernate.Model.Joker;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class JokerService {
    private JokerRepository jokerRepository;

    public JokerService(JokerRepository jokerRepository) {
        this.jokerRepository = jokerRepository;
    }

    public List<Joker> findAll(){
        return jokerRepository.findAll();
    }


    public Joker findbyID(@PathVariable Integer id){
        return jokerRepository.findById(id);
    }



    public boolean insert(@RequestBody Joker joker){
        return jokerRepository.insert(joker);
    }


    public void update(@PathVariable Integer id, @RequestBody Joker joker){
        jokerRepository.update(id,joker);
    }


    public void delete(@PathVariable Integer id){
        jokerRepository.delete(id);
    }
}
