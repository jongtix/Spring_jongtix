package controller;

import javax.validation.Valid;
import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import service.CustomerService;

@Controller
@RequestMapping("/customer/{id}")
@SessionAttributes("editCustomer")
public class CustomEditController {
	@Autowired
	private CustomerService cs;

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model) throws Exception {
		Customer customer = cs.findById(id);
		model.addAttribute("editCustomer", customer);
		return "redirect:enter";
	}

	@RequestMapping(value = "/enter", method = RequestMethod.GET)
	public String enter(@ModelAttribute("editCustomer") Customer customer) {
		return "customer/edit/enter";
	}

	@RequestMapping(value = "/enter", params = "_event_proceed")
	public String valid(@Valid @ModelAttribute("editCustomer") Customer cs, Errors errors) {
		if (errors.hasErrors())
			return "customer/edit/enter";
		return "redirect:review";
	}

	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public String showReview(@ModelAttribute("editCustomer") Customer customer) {
		return "customer/edit/review";
	}

	@RequestMapping(value = "/review", params = "_event_revise", method = RequestMethod.POST)
	public String revise() {
		return "redirect:enter";
	}

	@RequestMapping(value = "/review", params = "_event_confirmed", method = RequestMethod.POST)
	public String confirm(@ModelAttribute("editCustomer") Customer customer) throws Exception {
		System.out.println("����");
		cs.update(customer);
		return "redirect:/customer";
	}
}