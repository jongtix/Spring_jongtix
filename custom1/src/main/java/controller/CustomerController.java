package controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import model.Customer;
import service.CustomerService;
@Controller
public class CustomerController {
	@Autowired
	private CustomerService cs;
	@RequestMapping("/customer")
	public String customerAll(Model model) {
		List<Customer> list = cs.findAll();
		model.addAttribute("list", list);
		return "customer/list";
	}
	@RequestMapping("/customer/{id}")
	public String customerById(@PathVariable int id,Model model) throws Exception {
		Customer customer = cs.findById(id);
		model.addAttribute("customer", customer);
		return "customer/view";
	}
}