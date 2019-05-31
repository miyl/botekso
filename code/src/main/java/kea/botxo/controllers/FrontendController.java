package kea.botxo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kea.botxo.models.Customer;
import kea.botxo.models.Webhook;
import kea.botxo.models.User;
import kea.botxo.models.AuthType;
import kea.botxo.models.HttpRequestType;
import kea.botxo.models.ApiKey;

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
        registry.addViewController("/LoginSuccess").setViewName("LoginSuccess");
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
            return "LoginSuccess";
        }

        return "errorpage";

    }

    // WEBHOOK
    
    @GetMapping("/ListWebhooks")
    public String showListWebhooks(Model model){
        model.addAttribute("webhooks", seWebhook.fetchAll());
        return "ListWebhooks";
    }

    //Vis Webhook Formular
    @GetMapping("/CreateWebhook")
    public String showWebhookForm(Webhook webhook, Model model){
        //tilføjelse af customers til webhook formular.
        model.addAttribute("customers", seCustomer.fetchAll());
        return "CreateWebhook";
    }

    //Post webhook
    @PostMapping("/CreateWebhook")
    public String checkWebhookInfo(@Valid Webhook webhook, BindingResult bindingResult, Model model, WebRequest wr){
        model.addAttribute("customers", seCustomer.fetchAll());
        if(bindingResult.hasErrors()){
            return "CreateWebhook";
        }
        //String customername = wr.getParameter("customer");
        seWebhook.add(webhook);
        return "redirect:/ListWebhooks";
    }

    @PostMapping("/DeleteWebhook")
    public String deleteWebhook (@RequestParam("id") int id) {
        seWebhook.delete(id);
        return "redirect:/ListWebhooks";
    }

    // CUSTOMER
    
    @GetMapping("/ListCustomers")
    public String showListCustomers(Model model){
        model.addAttribute("customers", seCustomer.fetchAll());
        return "ListCustomers";
    }

    //customer formular
    @GetMapping("/CreateCustomer")
    public String showCustomerForm(Customer customer){
        return "CreateCustomer";
    }

    @PostMapping("/CreateCustomer")
    public String checkCustomerInfo(@Valid Customer customer, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "CreateCustomer";
        }
        return "redirect:/ListCustomers";
    }

    @PostMapping("/DeleteCustomer")
    public String deleteCustomer (@RequestParam("name") String name) {
        seUser.delete(name);
        return "redirect:/ListCustomers";
    }

    // USER

    @GetMapping("/ListUsers")
    public String showListUsers(Model model) {
        model.addAttribute("users", seUser.fetchAll());
        return "ListUsers";

    }

    //vis create user formular
    @GetMapping("/CreateUser")
    public String showCreateUserForm(User user){
        return "CreateUser";
    }

    @PostMapping("/CreateUser")
    public String checkUserInfo(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "CreateUser";
        }
        return "redirect:/ListUsers";
    }

    @PostMapping("/DeleteUser")
    public String deleteUser (@RequestParam("name") String name){
        seUser.delete(name);
        return "redirect:/ListUsers";
    }

    // API-KEY
    
    @GetMapping("/ListApiKeys")
    public String showListApiKeys(Model model){
        // Udkommenteret indtil metoden er lavet
        model.addAttribute("apiKeys", seApiKey.fetchAll());
        return "ListApiKeys";
    }

    @GetMapping("/GenerateApiKeyForm")
    public String generateApiKeyForm(Model model) {
      model.addAttribute("customers", seCustomer.fetchAll());
      return "GenerateApiKeyForm";
    }

    @PostMapping("/GenerateApiKey")
    public String generateApiKey(@RequestParam("customerName") String customerName) {
      seApiKey.generate(customerName);
      return "redirect:/ListApiKeys";
    }

    @PostMapping("/DeleteApiKey")
    public String deleteApiKey (@RequestParam("name") String key){
        seApiKey.delete(key);
        return "redirect:/ListApiKeys";
    }
    
    // HTTP REQUEST TYPES
    
    @GetMapping("/ListHttpRequestTypes")
    public String showListHttpRequestTypes(Model model){
        model.addAttribute("httpRequestTypes", seHttpRequestType.fetchAll());
        return "ListHttpRequestTypes";
    }

    @PostMapping("/DeleteHttpRequestType")
    public String deleteHttpRequestType (@RequestParam("httpRequestType") String httpRequestType){
        seHttpRequestType.delete(httpRequestType);
        return "redirect:/ListHttpRequestTypes";
    }
    
    // AUTH TYPES
    
    @GetMapping("/ListAuthTypes")
    public String showListAuthTypes(Model model){
        model.addAttribute("authTypes", seAuthType.fetchAll());
        return "ListAuthTypes";
    }

    @PostMapping("/DeleteAuthType")
    public String deleteAuthType (@RequestParam("authType") String authType){
        seAuthType.delete(authType);
        return "redirect:/ListAuthTypes";
    }

}
