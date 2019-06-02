package kea.botxo.testserver.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import kea.botxo.testserver.models.Response;

/**
 * Testing application to stand in for one of BotXO's third party APIs
 */
@RestController
@RequestMapping("api")
public class Controller {

  /**
   * When the API receives a GET request to /api/run it sends back the contained Response object in JSON format
   * @author Marcus
   */
  @GetMapping("/run")
  public Object list() {
    return new Response("Hey!", "There!");
  }

}
