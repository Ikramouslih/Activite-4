package ma.enset.hospitalapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller//annotation spring : indique que cette classe est un controlleur
//Un controller prend la requette depuis la servlet, et selon le type de la requette et l'url spécifié
public class SecurityController {

    @GetMapping("/notAuthorized")
    public String notAuthorized()
    {
        return "notAuthorized";
    }

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
}
