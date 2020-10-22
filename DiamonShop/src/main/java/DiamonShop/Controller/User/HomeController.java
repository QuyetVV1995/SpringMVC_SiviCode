package DiamonShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Service.User.HomeServiceImpl;

@Controller
public class HomeController {
	@Autowired
	HomeServiceImpl homeService;
	
	@RequestMapping(value = {"/", "/trang-chu/"})
		public ModelAndView index() {
			ModelAndView mv = new ModelAndView("user/index");
			mv.addObject("slides", homeService.getDataSlide());
			mv.addObject("catelogy", homeService.getDataCatelogy());
			return mv;
		}
	
	@RequestMapping(value = "product")
	public ModelAndView product() {
		ModelAndView mv = new ModelAndView("user/product");
		return mv;
	}
}

