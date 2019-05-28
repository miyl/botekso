package kea.botxo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kea.botxo.models.User;
import kea.botxo.models.Customer;
import kea.botxo.models.Webhook;

import kea.botxo.services.SeCustomer;
import kea.botxo.services.SeWebhook;
import kea.botxo.services.SeUser;
import kea.botxo.services.SeAuthType;
import kea.botxo.services.SeHttpRequestType;
import kea.botxo.services.SeApiKey;

import javax.validation.Valid;


@Controller
public class FrontendController implements WebMvcConfigurer {

    //Kode vedr. validering af form er fundet her https://spring.io/guides/gs/validating-form-input/

    @Autowired
    SeCustomer seCustomer;
    @Autowired
    SeWebhook seWebhook;
    @Autowired
    SeUser seUser;
    @Autowired
    SeApiKey seApiKey;
    @Autowired
    SeAuthType seAuthType;
    @Autowired
    SeHttpRequestType seHttpRequestType;


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/Results").setViewName("Results");
    }

    // LOGIN

    //Se her https://spring.io/guides/gs/securing-web/
    //Show Login Page
    @GetMapping("/")
    public String showLoginPage(){
        return "Login";
    }

    @PostMapping("/ValidateLogin")
    public String validateLogin(WebRequest webRequest, Model model){
        String loginname = webRequest.getParameter("name");
        String password = webRequest.getParameter("password");
        if(seUser.validateLogin(loginname, password)){
            return "Results";
        }

        return "errorpage";

    }

    // WEBHOOK

    //Vis Webhook Formular
    @GetMapping("/WebhookForm")
    public String showWebhookForm(Webhook webhook, Model model){
        //tilføjelse af customers til webhook formular.
        model.addAttribute("customers", seCustomer.fetchAll());
        return "WebhookForm";
    }

    //Post webhook
    @PostMapping("/WebhookForm")
    public String checkWebhookInfo(@Valid Webhook webhook, BindingResult bindingResult, Model model){
        model.addAttribute("customers", seCustomer.fetchAll());
        if(bindingResult.hasErrors()){
            return "WebhookForm";
        }
        addWebhook(webhook);
        return "redirect:/Results";
    }

    public String addWebhook(Webhook webhook){
        seWebhook.add(webhook);
        return "redirect:/Results";
    }

    @GetMapping("/ListWebhooks")
    public String showListWebhooks(Model model){
        model.addAttribute("ListWebhooks", seWebhook.fetchAll());
        return "ListWebhooks";
    }

    // CUSTOMER

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
        return "redirect:/Results";
    }

    // USER

    //vis create user formular
    @GetMapping("/CreateUserForm")
    public String showCreateUserForm(User user){
        return "CreateUserForm";
    }

    @PostMapping("/CreateUserResults")
    public String checkUserInfo(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "CreateUserForm";
        }
        return "redirect:/Results";
    }

    // API-KEY
    
    @GetMapping("/ListApiKeys")
    public String showListApiKeys(Model model){
        // Udkommenteret indtil metoden er lavet
        // model.addAttribute("ListApiKeys", seApiKey.fetchAll());
        return "ListApiKeys";
    }
    
    // HTTP REQUEST TYPES
    
    @GetMapping("/ListHttpRequestTypes")
    public String showListHttpRequestTypes(Model model){
        model.addAttribute("ListHttpRequestTypes", seHttpRequestType.fetchAll());
        return "ListHttpRequestTypes";
    }
    
    // AUTH TYPES
    
    @GetMapping("/ListAuthTypes")
    public String showListAuthTypes(Model model){
        model.addAttribute("ListAuthTypes", seAuthType.fetchAll());
        return "ListAuthTypes";
    }
}
