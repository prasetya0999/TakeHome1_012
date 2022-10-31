/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.a.takehome1;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Administrator
 */

@Controller
public class thController {
    @RequestMapping("/nextpage")
    public String next(@RequestParam(value="nm") String isiPertama,
            @RequestParam(value="lok") String isiKedua,
            @RequestParam(value="pic") MultipartFile isiKetiga,
            Model kurir)
            throws IOException{
        byte[] img = isiKetiga.getBytes();
        String base64Image = Base64.encodeBase64String(img);
        String imglink ="data:image/png;base64,".concat(base64Image);
        kurir.addAttribute("paket1", isiPertama);
        kurir.addAttribute("paket2", isiKedua);
        kurir.addAttribute("paket3", imglink);
        
        return "pageview";
    }
    
}
