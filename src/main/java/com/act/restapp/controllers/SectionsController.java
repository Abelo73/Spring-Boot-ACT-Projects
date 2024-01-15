package com.act.restapp.controllers;

import com.act.restapp.models.Sections;
import com.act.restapp.services.SectionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sections")
public class SectionsController {

    private final SectionsService sectionsService;


    @PostMapping("/add")
    public ResponseEntity<Sections> addSection(@RequestBody Sections sections){
        Sections cretedSections = sectionsService.createSections(sections);
        return new ResponseEntity<>(cretedSections, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Sections>> getAllSections(){
        List<Sections> sections = sectionsService.getAllSections();
        return new ResponseEntity<>(sections, HttpStatus.OK);
    }
}
