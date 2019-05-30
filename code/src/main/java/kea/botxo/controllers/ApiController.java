package kea.botxo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.context.request.WebRequest;

import kea.botxo.services.SeWebhook;
import kea.botxo.services.SeApiKey;
import kea.botxo.services.SeCustomer;

import kea.botxo.models.Webhook;
import kea.botxo.models.Customer;
import kea.botxo.models.ApiKey;

import java.util.List;

@RestController
@RequestMapping("api")
public class ApiController {

  @Autowired
  SeWebhook seWebhook;

  @Autowired
  SeApiKey seApiKey;

  @Autowired
  SeCustomer seCustomer;

  @GetMapping("/list")
  public List<Webhook> list() {
    return seWebhook.fetchAll();
  }

  @PostMapping("/execute/{idp}")
  public Object execute(@PathVariable("idp") int id, @RequestParam("key") String key) {
    // 1. Fetch the requested webhook
    // TODO: What should seWebhook return if the ID does not exist? I should call it and check for errors here!
    Webhook w = seWebhook.fetch(id);
    
    // 2. Validate that the API Key matches the requested Webhook:
    // Get the webhook's customer
    String customerName = w.getCustomerName();
    // Customer c = seCustomer.fetch(customerName);
    // Compare all api keys that customer has to the api key provided in the request
    List<ApiKey> keys = seApiKey.fetchAllForCustomer(customerName);

    boolean authenticated = false;
    for (ApiKey k : keys) {
      if ( k.equals(key) ) { 
        authenticated = true;
        break;
      }
    }

    if (!authenticated) {
      // TODO: Send some proper ERROR to virtual assistant
      return "This key is not authorised for the given webhook";
    }
    else {
      // 3. Make appropriate request to third party (execute the webhook)

      // 4. Send the response to the virtual assistant
      return new Object(); // What return value should execute have?! 
    }
  }
}
