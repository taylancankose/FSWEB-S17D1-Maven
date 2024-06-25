package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
    private Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping("/")
    public List<Animal> getAnimals(){
        return new ArrayList<>(animals.values());
    }


    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable int id){
        return animals.get(id);
    }

    @PostMapping("/")
    public Animal addAnimal(@RequestBody Animal animal){
        return animals.put(animal.getId(), animal);
    }

    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable int id, @RequestBody Animal animal){
        return animals.put(id, animal);
    }


    @DeleteMapping("/{id}")
    public Animal delete(@PathVariable int id){
        Animal animal = animals.get(id);

        return animals.remove(animal);
    }
}
