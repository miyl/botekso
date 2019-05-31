package kea.botxo.testserver.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import kea.botxo.testserver.models.Response;

@RestController
@RequestMapping("api")
public class Controller {

  @GetMapping("/run")
  public Object list() {
    return new Response("Hey!", "There!");
  }

}
