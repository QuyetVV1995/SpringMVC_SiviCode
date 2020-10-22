package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.CatelogyDao;
import DiamonShop.Dao.MenusDao;
import DiamonShop.Dao.SlidesDao;
import DiamonShop.Entity.Catelogy;
import DiamonShop.Entity.Menus;
import DiamonShop.Entity.Slides;

@Service
public class HomeServiceImpl implements IHomeService {
	@Autowired
	private SlidesDao slidesDao;
	
	@Autowired
	private CatelogyDao catelogyDao;
	
	@Autowired
	private MenusDao menusDao;
	
	
	public List<Slides> getDataSlide() {
		
		return slidesDao.getDataSlide();
	}

	public List<Catelogy> getDataCatelogy() {
		
		return catelogyDao.getDataCatelogy();
	}

	public List<Menus> getDataMenus() {
		return menusDao.getDataMenus();
	}

}
