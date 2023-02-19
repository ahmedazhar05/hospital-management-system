package src.main.java.com.healthplus.dataaccess.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.healthplus.dataaccess.domain.Scheme;

import src.main.java.com.healthplus.dataaccess.repo.ReportRepository;

@Controller
@RequestMapping(path="/schemes")
public class SchemeController {
    private ReportRepository reportRepository;
@Autowired
    @GetMapping(path = "/")
    public List<Scheme> listScheme() {
        return schemeRepository.findAll();
    }
@GetMapping(path="/{id}")
public Optional<Scheme> getschemeBy(@PathVariable("id") Long id){
    return schemeRepository.findById(id);
}
}
