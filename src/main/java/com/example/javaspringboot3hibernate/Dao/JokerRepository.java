package com.example.javaspringboot3hibernate.Dao;

import com.example.javaspringboot3hibernate.Model.Joker;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class JokerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Joker> findAll(){
        Query query = entityManager.createQuery("from Joker");
        return query.getResultList();
    }

    public Joker findById(Integer id){
        return entityManager.find(Joker.class,id);
    }

    @Transactional
    public boolean insert(Joker joker){
        entityManager.persist(joker);
        return  true;
    }

    @Transactional
    public boolean update(Integer id,Joker joker){
        Joker jk = entityManager.find(Joker.class,id);
        jk.setName(joker.getName());
        jk.setFoot_size(joker.getFoot_size());
        jk.setWeight(joker.getWeight());
        return  true;
    }

    @Transactional
    public void delete(Integer id){
        Joker joker = entityManager.find(Joker.class,id);
        entityManager.remove(joker);
    }

}

