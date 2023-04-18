package ma.enset.hospitalapp.web;

import jakarta.validation.Valid;
import ma.enset.hospitalapp.entities.Patient;
import ma.enset.hospitalapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller //annotation spring : indicates that this class is a controller
//Un controller prend la requette depuis la servlet, et selon le type de la requette et l'url spécifié,
//il execute la methode qui convient en faisant l'appel à la couche metier
public class PatientController {
    @Autowired //annotation spring : permet de faire l'injection des dépendences,
    //quand l'application démarre, si elle trouve un objet de type patientRepository, elle va l'injecter içi
    private PatientRepository patientRepository;//pour avoir access aux methodes

    @GetMapping("/user/index")
    public String index(Model model, //Class adaptable à toutes les classes models,
                        //Utiliser pour que la vue puisse acceder aux données récupérer par le controlleur de la BD
                        @RequestParam(name = "page",defaultValue = "0") int page,
                        @RequestParam(name = "size",defaultValue = "5") int size,
                        @RequestParam(name = "keyword",defaultValue = "") String kw
                        //@RequestParam : fait la liaison entre les parametres passés dans l'url avec les parametres de la fonction
                        ){
        Page<Patient> pagePatients = patientRepository.findByNomContains(kw, PageRequest.of(page,size));//Pagination
        //Définition des attributs de la classe model
        //Association des données récupérés aux attributs de la classe model
        model.addAttribute("listPatients",pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",kw);
        return "patients";//La vue nommée patients
    }
    @GetMapping("/admin/deletePatient")
    @PreAuthorize("hasRole('ROLE_ADMIN')")//cette fonction peut être utiliser que par un user avec le role admin
    public String deletePatient(@RequestParam(name = "id") Long id,
                                String keyword, int page){
        patientRepository.deleteById(id);
        //retourner vers la page précedente après suppression
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/admin/formPatient")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String formPatient(Model model ){
        //création d'un patient sans valeurs pour le formulaire vide
        model.addAttribute("patient",new Patient());

        return "formPatient";
    }
    @PostMapping("/admin/savePatient")//POST REQUEST
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String savePatient(@Valid Patient patient,//si les champs du formulaire sont valides
                              BindingResult bindingResult//Stock et récupére les erreurs de la validation
                              // (les annotations de validation dans le model)
                              ){
        if (bindingResult.hasErrors()) return "formPatient";
        patientRepository.save(patient);
        return "formPatient";
    }
    @GetMapping("/admin/editPatient")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String editPatient(@RequestParam(name = "id") Long id, Model model){
        Patient patient=patientRepository.findById(id).get();
        model.addAttribute("patient",patient);
        return "editPatient";
    }

    @GetMapping("/")
    public String home()
    {
        return "redirect:/user/index";
    }
}
