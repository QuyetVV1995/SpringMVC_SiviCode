package DiamonShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dto.PaginatesDto;
import DiamonShop.Service.User.CatelogyServiceImpl;
import DiamonShop.Service.User.PaginatesServiceImpl;

@Controller
public class CatelogyController extends BaseController {
	@Autowired
	private CatelogyServiceImpl catelogyService;
	@Autowired
	private PaginatesServiceImpl paginatesService;
	
	@RequestMapping(value = "/san-pham/{id}")
	public ModelAndView product(@PathVariable String id) {
		int totalProductsPage = 9;
		_mvShare.setViewName("user/products/catelogy");

		int totalData = catelogyService.getAllProductsByID(Integer.parseInt(id)).size();
		PaginatesDto paginateInfo = paginatesService.getInfoPaginates(totalData, totalProductsPage, 1);
		
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("productsPaginate", catelogyService.getDataProductsPaginate(paginateInfo.getStart(), paginateInfo.getEnd()));
		return _mvShare;
	}
}
