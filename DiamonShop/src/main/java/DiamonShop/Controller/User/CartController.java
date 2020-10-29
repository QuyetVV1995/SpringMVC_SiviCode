package DiamonShop.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dto.CartDto;
import DiamonShop.Entity.Bills;
import DiamonShop.Service.User.CartServiceImpl;

@Controller
public class CartController extends BaseController {
	
	@Autowired
	private CartServiceImpl cartService = new CartServiceImpl();
	
	@RequestMapping(value = "gio-hang")
	public ModelAndView ListCart() {		
	_mvShare.addObject("slides", _homeService.getDataSlide());
	_mvShare.addObject("catelogy", _homeService.getDataCatelogy());
	_mvShare.addObject("products", _homeService.getDataProducts());
	_mvShare.setViewName("user/cart/list_cart");
		return _mvShare;
	}

	
	@RequestMapping(value = "addCart/{id}")
	public String addCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
		if(cart ==  null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.addCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.totalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.totalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value = "editCart/{id}/{quanty}")
	public String editCart(HttpServletRequest request, HttpSession session,@PathVariable int id, @PathVariable int quanty) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
		if(cart ==  null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart =  cartService.editCart(id, quanty, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.totalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.totalPrice(cart));
		
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value = "deleteCart/{id}")
	public String deleteCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
		if(cart ==  null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart =  cartService.deleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.totalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.totalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value = "checkout", method = RequestMethod.GET)
	public ModelAndView checkout(HttpServletRequest request, HttpSession session) {
		_mvShare.setViewName("user/bills/checkout");
		_mvShare.addObject("bills", new Bills());
		return _mvShare;
	}
	
	@RequestMapping(value = "checkout", method = RequestMethod.POST)
	public ModelAndView checkoutBill(HttpServletRequest request, HttpSession session, @ModelAttribute("bills") Bills bills) {
		_mvShare.setViewName("user/bills/checkout");
		return _mvShare;
	}
	
}
