package DiamonShop.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CatelogyController {
	@RequestMapping(value = "/san-pham/{id}")
	public ModelAndView product(@PathVariable String id) {
		ModelAndView mv = new ModelAndView("user/catelogy");
		mv.addObject("idCatelogy", id);
		return mv;
	}
}
