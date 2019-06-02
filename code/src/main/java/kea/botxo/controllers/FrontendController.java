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

/**
 * The Frontend Controller
 */
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


    /**
     * Used for login validation (Spring Security)
     * @author Andreas
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/LoginSuccess").setViewName("LoginSuccess");
    }


    // LOGIN

    //Se her https://spring.io/guides/gs/securing-web/

    /**
     * Show login page
     * @author Andreas
     * @return The login page
     */
    @GetMapping("/")
    public String showLoginPage(){
        return "Login";
    }

    /**
     * For validating the filled in login details
     * @author Andreas
     * @param webRequest Used to retrieve parameters passed from the login form
     * @return The LoginSuccess page if login was successful, or otherwise an error
     */
    @PostMapping("/ValidateLogin")
    public String validateLogin(WebRequest webRequest){
        String loginname = webRequest.getParameter("name");
        String password = webRequest.getParameter("password");
        if(seUser.validateLogin(loginname, password)){
            return "LoginSuccess";
        }

        return "errorpage";
    }


    // WEBHOOK

    /**
     * Show list of webhooks
     * @author Andreas
     * @param model Contains variables to be passed to the template
     * @return The list of webhooks template
     */
    @GetMapping("/ListWebhooks")
    public String showListWebhooks(Model model){
        model.addAttribute("webhooks", seWebhook.fetchAll());
        return "ListWebhooks";
    }

    /**
     * Show webhook form
     * @author Andreas
     * @param webhook The webhook object is passed in for validation purposes
     * @param model Contains variables to be passed to the template
     * @return The webhooks form template
     */
    @GetMapping("/CreateWebhook")
    public String showWebhookForm(Webhook webhook, Model model){
        //tilføjelse af customers til webhook formular.
        model.addAttribute("customers", seCustomer.fetchAll());
        return "CreateWebhook";
    }

    /**
     * Receives the filled in form details for creating a webhook
     * @author Andreas
     * @param webhook The webhook object is passed in for validation purposes
     * @param bindingResult Used for form validation
     * @param model Contains variables to be passed to the template
     * @return If the webhook form was valid the list of webhooks is returned. Otherwise the webhook create form is returned.
     */
    @PostMapping("/CreateWebhook")
    public String checkWebhookInfo(@Valid Webhook webhook, BindingResult bindingResult, Model model){
        model.addAttribute("customers", seCustomer.fetchAll());
        if(bindingResult.hasErrors()){
            return "CreateWebhook";
        }
        seWebhook.add(webhook);
        return "redirect:/ListWebhooks";
    }

    /**
     * For deleting a webhook
     * @author Andreas
     * @param id The ID of the webhook to be deleted
     * @return The list of users.
     */
    @PostMapping("/DeleteWebhook")
    public String deleteWebhook (@RequestParam("id") int id) {
        seWebhook.delete(id);
        return "redirect:/ListWebhooks";
    }


    // CUSTOMER

    /**
     * Shows the list of customers
     * @author Marcus
     * @param model Contains variables to be passed to the template
     * @return The list of customers
     */
    @GetMapping("/ListCustomers")
    public String showListCustomers(Model model){
        model.addAttribute("customers", seCustomer.fetchAll());
        return "ListCustomers";
    }

    /**
     * Shows the add customer form
     * @author Marcus
     * @param customer The customer object is passed in for validation purposes
     * @return The customer form
     */
    //customer formular
    @GetMapping("/CreateCustomer")
    public String showCustomerForm(Model model){
        model.addAttribute("cm", new Customer());
        return "CreateCustomer";
    }

    /**
     * Receives the form input from the template for creating a customer
     * @author Marcus
     * @param customer The customer object is passed in for validation purposes
     * @param bindingResult Used for validation
     * @return If successful the list of customers is returned, otherwise the customer form is returned
     */
    @PostMapping("/CreateCustomer")
    public String checkCustomerInfo(Model model, @Valid Customer customer, BindingResult bindingResult){
      if(bindingResult.hasErrors()) { 
        model.addAttribute("cm", customer);
        model.addAttribute("bindingResult", bindingResult);
        return "CreateCustomer"; 
      }
      else {
        seCustomer.add(customer);
        return "redirect:/ListCustomers";
      }
    }

    /**
     * For deleting a Customer
     * @author Marcus
     * @param name The name of the Customer to be deleted
     * @return The list of customers
     */
    @PostMapping("/DeleteCustomer")
    public String deleteCustomer (@RequestParam("name") String name) {
        seCustomer.delete(name);
        return "redirect:/ListCustomers";
    }


    // USER

    /**
     * For listing users
     * @author Tariq
     * @param model Contains variables to be passed to the template
     * @return The list of users
     */
    @GetMapping("/ListUsers")
    public String showListUsers(Model model) {
        model.addAttribute("users", seUser.fetchAll());
        return "ListUsers";

    }

    /**
     * The create user form
     * @author Tariq
     * @param user
     * @return The create User form
     */
    //vis create user formular
    @GetMapping("/CreateUser")
    public String showCreateUserForm(Model model){
        model.addAttribute("u", new User()); // TODO: Maybe this is wrong, maybe it SHOULD take a user if validation is to work?
        return "CreateUser";
    }

    /**
     * Receives the details filled into the create User form
     * @author Tariq, Marcus
     * @param user The user to be created
     * @param bindingResult Used for validation
     * @return
     */
    @PostMapping("/CreateUser")
    public String checkUserInfo(Model model, @Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("u", user);
            model.addAttribute("bindingResult", bindingResult);
            return "CreateUser"; 
        }
        else {
          seUser.add(user);
          return "redirect:/ListUsers";
        }
    }

    /**
     * For deleting a User
     * @author Tariq
     * @param name The name of the User to be deleted
     * @return The list of Users
     */
    @PostMapping("/DeleteUser")
    public String deleteUser (@RequestParam("name") String name){
        seUser.delete(name);
        return "redirect:/ListUsers";
    }


    // API-KEY

    /**
     * For listing API-Keys
     * @author Esben
     * @param model Contains variables to be passed to the template
     * @return The list of API-Keys
     */
    @GetMapping("/ListApiKeys")
    public String showListApiKeys(Model model){
        // Udkommenteret indtil metoden er lavet
        model.addAttribute("apiKeys", seApiKey.fetchAll());
        return "ListApiKeys";
    }

    /**
     * For generating an API-Key
     * @author Esben
     * @param model Contains variables to be passed to the template
     * @return The generate API-Key form, for selecting which Customer the API-Key should be created for
     */
    @GetMapping("/GenerateApiKeyForm")
    public String generateApiKeyForm(Model model) {
      model.addAttribute("customers", seCustomer.fetchAll());
      return "GenerateApiKeyForm";
    }

    /**
     * Receives the selected user from the Generate API Key form
     * @author Esben
     * @param customerName The selected user
     * @return The list of API-Keys
     */
    @PostMapping("/GenerateApiKey")
    public String generateApiKey(@RequestParam("customerName") String customerName) {
      seApiKey.generate(customerName);
      return "redirect:/ListApiKeys";
    }

    /**
     * For deleting API-Keys
     * @author Esben
     * @param key The key to be deleted
     * @return The list of API-Keys
     */
    @PostMapping("/DeleteApiKey")
    public String deleteApiKey (@RequestParam("name") String key){
        seApiKey.delete(key);
        return "redirect:/ListApiKeys";
    }
    

    // HTTP REQUEST TYPES

    /**
     * Shows the list of HTTP Request Types
     * @author Marcus
     * @param model Contains variables to be passed to the template
     * @return
     */
    @GetMapping("/ListHttpRequestTypes")
    public String showListHttpRequestTypes(Model model){
        model.addAttribute("httpRequestTypes", seHttpRequestType.fetchAll());
        return "ListHttpRequestTypes";
    }

    /**
     * Shows the form for adding a new HTTP Request Type
     * @author Marcus
     * @param model Contains variables to be passed to the template
     * @return The form for adding a new HTTP Request Type
     */
    @GetMapping("/CreateHttpRequestType")
    public String showCreateHttpRequestType(Model model) {
      model.addAttribute("hrt", new HttpRequestType());
       return "CreateHttpRequestType"; 
    }

    /**
     * Validates HTTP Request Type form input and passes it to be inserted into the database if successful, otherwise returning the create form with errors
     * @author Marcus
     * @param model Contains variables to be passed to the template
     * @param httpRequestType The Authentication Type to be added
     * @param bindingResult For form validation
     * @return If successful the list of Authentication Types is returned, otherwise the form is returned
     */
    @PostMapping("/CreateHttpRequestType")
    public String createHttpRequestType(Model model, @Valid HttpRequestType httpRequestType, BindingResult bindingResult) {
      if(bindingResult.hasErrors()) { 
        model.addAttribute("hrt", httpRequestType);
        model.addAttribute("bindingResult", bindingResult);
        return "CreateHttpRequestType"; 
      }
      else {
        seHttpRequestType.add(httpRequestType);
        return "redirect:/ListHttpRequestTypes";
      }
    }

    /**
     * For deleting an HTTP Request Type
     * @author Marcus
     * @param httpRequestType The HTTP Request Type to be deleted
     * @return The list of HTTP Request Types
     */
    @PostMapping("/DeleteHttpRequestType")
    public String deleteHttpRequestType (@RequestParam("httpRequestType") String httpRequestType){
        seHttpRequestType.delete(httpRequestType);
        return "redirect:/ListHttpRequestTypes";
    }
    

    // AUTH TYPES

    /**
     * Shows the list of Authentication Types
     * @author Marcus
     * @param model Contains variables to be passed to the template
     * @return The list of Authentication Types
     */
    @GetMapping("/ListAuthTypes")
    public String showListAuthTypes(Model model){
        model.addAttribute("authTypes", seAuthType.fetchAll());
        return "ListAuthTypes";
    }

    /**
     * Shows the form for adding a new Authentication Type
     * @author Marcus
     * @param model Contains variables to be passed to the template
     * @return The form for adding a new Authentication Type
     */
    @GetMapping("/CreateAuthType")
    public String showCreateAuthType(Model model) {
      model.addAttribute("at", new AuthType());
       return "CreateAuthType"; 
    }

    /**
     * Validates Auth Type form input and passes it to be inserted into the database if successful, otherwise returning the create form with errors
     * @author Marcus
     * @param model Contains variables to be passed to the template
     * @param authType The Authentication Type to be added
     * @param bindingResult For form validation
     * @return If successful the list of Authentication Types is returned, otherwise the form is returned
     */
    @PostMapping("/CreateAuthType")
    public String createAuthType(Model model, @Valid AuthType authType, BindingResult bindingResult) {
      if(bindingResult.hasErrors()) { 
        model.addAttribute("at", authType);
        model.addAttribute("bindingResult", bindingResult);
        return "CreateAuthType"; 
      }
      else {
        seAuthType.add(authType);
        return "redirect:/ListAuthTypes";
      }
    }

    /**
     * For deleting authentication types
     * @author Marcus
     * @param authType The authentication type to be deleted
     * @return The list of authentication types
     */
    @PostMapping("/DeleteAuthType")
    public String deleteAuthType (@RequestParam("authType") String authType){
        seAuthType.delete(authType);
        return "redirect:/ListAuthTypes";
    }

}
