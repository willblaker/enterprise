package com.myplantdiary.enterprise;


import com.myplantdiary.enterprise.dto.Specimen;
import com.myplantdiary.enterprise.service.ISpecimenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlantDiaryController {
    @Autowired
    ISpecimenService specimenService;
    /**
     * Handle the root (/) endpoint and return a start page
     * @return
     */
    /**
     * Endpoint to fetch specimen
     */
    @GetMapping("/specimen")
        public ResponseEntity fetchAllSpecimens(){
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Endpoint to fetsh specimen by ID
     */
    @GetMapping("/specimen/{id}")
    public ResponseEntity fetchSpecimenByID(@PathVariable("id") String id){
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Endpoint to create specimen
     */
    @PostMapping(value = "/specimen", consumes = "application/json", produces = "application/json")
        public Specimen createSpecimen(@RequestBody Specimen specimen){
            return specimen;
    }

    /**
     * Endpoint to delete specimen by ID
     */
    @DeleteMapping("/specimen/{id}")
        public ResponseEntity deleteSpecimen(@PathVariable("id") String id){
            return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping("/")
    public String index(Model model){
        Specimen specimen = new Specimen();
        specimen.setDescription("Pawpaw fruit season");
        specimen.setLongitude("39.74");
        specimen.setLatitude("-84.51");
        specimen.setSpecimenID("1103");
        specimen.setPlantId(84);
        model.addAttribute(specimen);

        return "start";
    }

    @RequestMapping("/saveSpecimen")
    public String saveSpecimen(Specimen specimen){
        try{
            specimenService.save(specimen);
        } catch(Exception e){
            e.printStackTrace();
            return "start";
        }
        return "start";
    }
}
