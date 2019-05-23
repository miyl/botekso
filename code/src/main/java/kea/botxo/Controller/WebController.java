package kea.botxo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import kea.botxo.Model.User;
import kea.botxo.Model.Customer;
import kea.botxo.Model.Webhook;
import kea.botxo.Service.SeCustomer;
import kea.botxo.Service.SeWebhook;

import javax.validation.Valid;
import java.util.List;

@Controller
public class WebController implements WebMvcConfigurer {

    //Kode vedr. validering af form er fundet her https://spring.io/guides/gs/validating-form-input/

    @Autowired
    SeCustomer seCustomer;


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/WebhookFormResults").setViewName("WebhookFormResult");
        registry.addViewController("/CustomerFormResults").setViewName("CustomerFormResults");
        registry.addViewController("/CreateuserResults").setViewName("CreateUserResults");
    }

    //Vis Webhook Formular
    @GetMapping("/WebhookForm")
    public String showWebhookForm(Webhook webhook, Model model){
        //tilføjelse af customers til webhook formular.
        model.addAttribute("customers", seCustomer.fetchAll());
        return "WebhookForm";
    }

    //Post webhook
    @PostMapping("/WebhookForm")
    public String checkWebhookInfo(@Valid Webhook webhook, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "WebhookForm";
        }
        return "redirect:/WebhookFormResults";
    }

    //customer formular
    @GetMapping("/CustomerForm")
    public String showCustomerForm(Customer customer){
        return "CustomerForm";
    }
    @PostMapping("/CustomerForm")
    public String checkCustomerInfo(@Valid Customer customer, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "CustomerForm";
        }
        return "redirect:/CustomerFormResults";
    }

    //create user formular
    @GetMapping("/CreateUserForm")
    public String showCreateUserForm(User user){
        return "CreateUserForm";
    }
    @PostMapping("/CreateUserResults")
    public String checkUserInfo(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "CreateUserForm";
        }
        return "redirect:/CreateUserResults";
    }


    //List Webhooks
    @Autowired
    SeWebhook seWebhook;

    @GetMapping("/ListWebhooks")
    public String showListWebhooks(Model model){
        model.addAttribute("ListWebhooks", seWebhook.fetchAll());
        return "ListWebhooks";
    }


}
