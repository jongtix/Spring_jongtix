package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Customer;
import service.CustomerService;

@Controller
public class CustomerController { // POJO객체(특정 클래스를 상속받지 않은 보통의 자바객체)
	@Autowired
	private CustomerService cs;

	@RequestMapping("customer")
	public String customerAll(Model model) {
		System.out.println("customerController");

		List<Customer> list = cs.findAll();

		model.addAttribute("list", list);

		return "customer/list";
	}

}
