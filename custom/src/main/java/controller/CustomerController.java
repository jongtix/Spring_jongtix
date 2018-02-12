package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Customer;
import service.CustomerService;

@Controller
public class CustomerController { // POJO객체(특정 클래스를 상속받지 않은 보통의 자바객체)
	@Autowired
	private CustomerService cs;

	@RequestMapping("/customer")
	public String customerAll(Model model) {
		System.out.println("customerController");

		List<Customer> list = cs.findAll();

		model.addAttribute("list", list);

		return "customer/list2";
	}

	@RequestMapping("viewCustomer")
	public String customerInfo(HttpServletRequest req, Model model) throws Exception {
		int id = Integer.parseInt(req.getParameter("id"));

		Customer customer = cs.findById(id);

		model.addAttribute("customer", customer);

		return "customer/view";
	}

	@RequestMapping("editCustomer")
	public String editCustomer(HttpServletRequest req, Model model) throws Exception {
		int id = Integer.parseInt(req.getParameter("id"));

		Customer customer = cs.findById(id);

		model.addAttribute("customer", customer);

		return "customer/edit";
	}

	@RequestMapping("customerEditPro")
	public String customerEditPro(Customer customer, Model model) throws Exception {
		cs.update(customer);
		return "redirect:customer.do";
	}

	@RequestMapping("newCustomer")
	public String newCustomer() {
		return "customer/new";
	}

	@RequestMapping("newCustomerPro")
	public String newCustomerPro(@ModelAttribute("Customer") Customer customer) {
		cs.register(customer);
		return "redirect:customer.do";
	}

	@RequestMapping("deleteCustomer")
	public String deleteCustomer(@RequestParam("id") int id) throws Exception {
		cs.delete(id);
		return "redirect:customer.do";
	}

	@RequestMapping("/customer/{id}")
	public String customerById(@PathVariable int id, Model model) throws Exception {
		Customer customer = cs.findById(id);

		model.addAttribute("customer", customer);

		return "customer/view";
	}

	@RequestMapping("/customer/{id}/edit")
	public String customerEditById(@PathVariable int id, Model model) throws Exception {
		Customer customer = cs.findById(id);

		model.addAttribute("customer", customer);

		return "customer/edit";
	}

	@RequestMapping("/customer/editCustomer")
	public String editCustomer(@PathVariable int id, Model model) throws Exception {
		Customer customer = cs.findById(id);
		customer = cs.editCustomer(customer);
		model.addAttribute("customer", customer);
		return "customer/resend";
	}

}
