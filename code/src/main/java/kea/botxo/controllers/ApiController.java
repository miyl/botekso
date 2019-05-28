package kea.botxo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.context.request.WebRequest;

import kea.botxo.services.SeWebhook;

import kea.botxo.models.Webhook;

import java.util.List;

@RestController
@RequestMapping("api")
public class ApiController {

  @Autowired
  SeWebhook seWebhook;

  @GetMapping("/list")
  public List<Webhook> list() {
    return seWebhook.fetchAll();
  }

  @PostMapping("/execute/{idp}")
  public Object execute(@PathVariable("idp") int id) {
    // 1. Fetch the requested webhook
    Webhook w = seWebhook.fetch(id);
    
    // 2. Validate that the API Key matches the requested Webhook:
    // Find the webhook's customer
    // Customer c = w.getCustomer();
    // Compare all api keys that customer has to the api key provided in the request

    // 3. Execute the webhook

    // 4. Send the response to the virtual assistant


    return new Object(); // What return value should execute have?! 
  }

}
