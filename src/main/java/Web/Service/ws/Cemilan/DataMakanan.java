/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.Service.ws.Cemilan;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author harry
 */
@CrossOrigin
@RestController
@RequestMapping("/data")
public class DataMakanan {
    @Autowired
    private DataMakanan eat;
    
    @GetMapping("/Eating")
    public List<DataMakanan> getAllMakanan(){
        return eat.getAllMakanan();
    }
    
    @GetMapping ("/Eating/{IDMakan}")
    public DataMakanan getMakanById(@PathVariable String IDMakan){
        return eat.getMakanById(IDMakan);
    }
    
    @PostMapping ("/Eating")
    public DataMakanan saveDataMakananDetails(@RequestBody DataMakanan s){
        return eat.saveDataMakananDetails(s);
    }
    
    @PutMapping("/Eating")
    public DataMakanan updateDataMakanan(@RequestBody DataMakanan s){
        return eat.updateDataMakanan(s);
    }
    
    @DeleteMapping("/Eating/{IDMakan}")
    public ResponseEntity<HttpStatus> deleteDataMakananById(@PathVariable String IDMakan){
        eat.deleteDataMakananById(IDMakan);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}