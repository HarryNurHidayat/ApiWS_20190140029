/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.Service.ws.Cemilan;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author harry
 */
@Controller
public class DataMakanan {
    @RequestMapping("/Eeting")
    @ResponseBody
    public List<Makanan> getMakanan(){
        List<Makanan> DataMakanan = new ArrayList<>();
        
        MakananJpaController controller = new MakananJpaController() ;
        
        try {
            DataMakanan = controller.findMakananEntities();
        }catch (Exception e){}
        
        return DataMakanan;
    }
    
}
