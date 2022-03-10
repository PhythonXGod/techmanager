package com.tehnika.tehnikamanager.resource;

import com.tehnika.tehnikamanager.model.Tech;
import com.tehnika.tehnikamanager.service.TechService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//controler layers
@RestController
@RequestMapping("/tech")
public class TechResource {
    private final TechService techService;

    public TechResource(TechService techService) {
        this.techService = techService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Tech>> getAllTech () {
        List<Tech> tech = techService.findAllTech();
        return new ResponseEntity<>(tech, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Tech> addTech(@RequestBody Tech tech) {
        Tech newTech = techService.addTech(tech);
        return new ResponseEntity<>(newTech, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Tech> updateTech(@RequestBody Tech tech) {
        Tech updateTech = techService.updateTech(tech);
        return new ResponseEntity<>(updateTech, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTech(@PathVariable("id") Long id) {
        techService.deleteTech(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}