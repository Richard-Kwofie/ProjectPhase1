package com.controller;

import java.net.http.HttpRequest;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.Login;
import com.bean.Orders;
import com.bean.Product;
import com.repository.OrdersRepository;
import com.service.OrdersService;
import com.service.ProductService;


@Controller
public class OrdersController {

	@Autowired
	ProductService productService;
	@Autowired
	OrdersService ordersService;
	@Autowired
	OrdersRepository ordersRepository;
	
	@RequestMapping(value = "placeOrder/{pid}")
	public String placeOrder(Model mm,@PathVariable("pid") int pid,HttpSession hs,Orders order) {
		System.out.println("Pid is "+pid);
		String emailid = (String)hs.getAttribute("emailid");
		
		order.setEmailid(emailid);
		order.setOrderplaced(LocalDate.now());
		order.setProductid(pid);
		String result = ordersService.placeOrder(order);
		productService.decrementQty(pid);
		List<Product> listOfProducts = productService.findAllProduts();
		mm.addAttribute("products", listOfProducts);
		mm.addAttribute("msg", result);
		return "viewProductsByCustomer";
		
	}
		@RequestMapping(value = "/viewPurchaseReportByAdmin",method = RequestMethod.GET)
		public String viewPurchase(Model mm, Login ll) {
			List<Orders> listofPurchase = ordersService.viewAllOrderDetails();
			mm.addAttribute("orders", listofPurchase);
			return "viewPurchaseReport";
	}	

		@RequestMapping(value = "/viewReportPage",method = RequestMethod.GET)
		public String showOrders(Model model,

		                         @RequestParam(name = "start", required = false)

		                         @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,

		                         @RequestParam(name = "end", required = false)

		                         @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {

		    List<Orders> orders;

		    if (startDate != null && endDate != null) {

		        orders = ordersRepository.findByOrderplacedBetween(startDate, endDate);

		    } else {

		        orders = ordersRepository.findAll();

		    }

		    model.addAttribute("orders", orders);

		    return "viewReport";

		}
}
