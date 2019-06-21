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

// Make HTTP request and handle server response
import kea.botxo.models.ServerResponse;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * The controller for our API
 */
@RestController
@RequestMapping("api")
public class ApiController {

  @Autowired
  SeWebhook seWebhook;

  @Autowired
  SeApiKey seApiKey;

  @Autowired
  SeCustomer seCustomer;

  /**
   *
   * @author Marcus
   * @return Returns a list of webhooks in JSON format to the source of the HTTP GET Request.
   */
  @GetMapping("/list")
  public List<Webhook> list() {
    return seWebhook.fetchAll();
  }

  /**
   *
   * @author Marcus
   * @param id The ID for the webhook that should be executed
   * @param receivedKey The API Key that should match the webhook ID if the webhook is to be executed.
   * @return If the key is valid the key is returned. Otherwise an errormessage is returned.
   */
  @PostMapping("/execute/{idp}")
  public Object execute(@PathVariable("idp") int id, @RequestParam("key") String receivedKey) {
    // 1. Fetch the requested webhook
    // TODO: What should seWebhook return if the ID does not exist? I should call it and check for errors here!
    Webhook w = seWebhook.fetch(id);
    
    // 2. Validate that the API Key matches the requested Webhook:
    // Get the webhook's customer
    String customerName = w.getCustomerName();
    // System.out.println("Customer name: " + customerName);
    // Customer c = seCustomer.fetch(customerName);
    // Compare all api keys that customer has to the api key provided in the request
    List<ApiKey> keys = seApiKey.fetchAllForCustomer(customerName);

    boolean authenticated = false;
    // System.out.println("Key passed in request: " + receivedKey);
    // System.out.println("Number of keys found for customer: " + keys.size());
    for (ApiKey k : keys) {
      // System.out.println(k);
      String keyStr = k.getKey();
      if ( keyStr.equals(receivedKey) ) { 
        authenticated = true;
        break; // No need to check additional API keys when the valid one is found
      }
    }

    if (!authenticated) {
      // TODO: Send some proper ERROR to virtual assistant
      return "This key is not authorised for the given webhook";
    }
    else {
      // 3. Make appropriate request to third party (execute the webhook)
      RestTemplate restTemplate = new RestTemplate();
      ServerResponse sr = restTemplate.getForObject("http://localhost:9090/api/run", ServerResponse.class);
      // System.out.println(sr);

      // 4. Send the response to the virtual assistant
      return sr;
    }
  }
}
