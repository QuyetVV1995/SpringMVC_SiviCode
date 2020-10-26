package DiamonShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Service.User.IProductService;

@Controller
public class ProductController extends BaseController {
	
	@Autowired
	private IProductService _productService;
	
	@RequestMapping(value = {"/chi-tiet-san-pham/{id}"})
	public ModelAndView index(@PathVariable long id) {
	_mvShare.setViewName("user/products/product");
	_mvShare.addObject("product", _productService.getProductById(id));
	int idCatelogy = _productService.getProductById(id).getId_catelogy();
	_mvShare.addObject("productByIdCatelogy", _productService.getProductByIdCatelogy(idCatelogy));
		return _mvShare;
	}
}
