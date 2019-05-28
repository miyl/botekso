package kea.botxo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

  @GetMapping("/execute")
  public Object execute() {
    return new Object(); // What return value should execute have?! 
  }

}
