package com.act.restapp.services;

import com.act.restapp.models.Sections;
import com.act.restapp.repositories.SectionsRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectionsService {
    private final SectionsRepositories sectionsRepositories;

    public Sections createSections(@RequestBody Sections sections){

        return sectionsRepositories.save(sections);
    }

    public List<Sections> getAllSections(){
        return sectionsRepositories.findAll();
    }
}
