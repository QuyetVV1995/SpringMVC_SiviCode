package DiamonShop.Dao;

import java.util.HashMap;

import DiamonShop.Dto.CartDto;
import DiamonShop.Dto.ProductsDto;

public class CartDao extends BaseDao {

	ProductsDao productsDao = new ProductsDao();
	
	public CartDto addCart(long id, HashMap<Long, CartDto> cart) {
		CartDto itemCart = new CartDto();
		ProductsDto product = productsDao.findProductById(id);
		if(product != null) {
			itemCart.setProduct(product);
			itemCart.setQuanty(1);
			itemCart.setTotalPrice(product.getPrice());
		}
		return itemCart;
	}
}
