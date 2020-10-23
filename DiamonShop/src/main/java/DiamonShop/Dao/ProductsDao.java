package DiamonShop.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShop.Dto.ProductsDto;
import DiamonShop.Dto.ProductsDtoMapper;

@Repository
public class ProductsDao extends BaseDao {
	
	private final boolean YES = true;
	private final boolean NO = false;
	
	private StringBuffer SqlString() {
		StringBuffer  sql = new StringBuffer();
		sql.append("select p.id as id_product, p.id_catelogy, p.size, p.name, p.price, ");
		sql.append("p.sale, p.title, p.highlight, p.new_product, p.details, p.created_at, p.update_at, ");
		sql.append("c.name as name_color, c.id as id_color, c.code as code_color, c.img  from products as p ");
		sql.append("inner join colors as c on p.id = c.id_product ");
	
		return sql;
	}
	
	private String SqlProduct(boolean highlight, boolean newProduct) {
		StringBuffer  sql = SqlString() ;
		sql.append("where 1 = 1 ");
		if(highlight) {
			sql.append("and p.highlight = true ");
		}
		if(newProduct) {
			sql.append("and p.new_product = true ");
		}	
		sql.append("group by p.id, c.id_product ");
		sql.append("order by rand() ");
		
		if(highlight) {
			sql.append("limit 2 ");
		}
		if(newProduct) {
			sql.append("limit 3 ");
		}	
		return sql.toString();
	}
	
	public List<ProductsDto> getDataProducts() {
		String sql = SqlProduct(NO, YES);
		List<ProductsDto> listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	} 
}
