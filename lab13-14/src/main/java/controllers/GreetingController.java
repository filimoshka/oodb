package controllers;

import models.Client;
import models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import repositories.ClientRepository;
import repositories.OrderRepository;

@Controller
public class GreetingController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        Iterable<Order> orders = orderRepository.findAll();
        Client client = new Client();
        client.setDiscount(5);
        clientRepository.save(client);
        return "greeting";
    }

}
