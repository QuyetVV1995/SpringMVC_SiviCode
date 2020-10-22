package DiamonShop.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShop.Dto.ProductsDto;
import DiamonShop.Dto.ProductsDtoMapper;

@Repository
public class ProductsDao extends BaseDao {
	
	private String SqlString() {
		StringBuffer  sql = new StringBuffer();
		sql.append("select p.id as id_product, p.id_catelogy, p.size, p.name, p.price, ");
		sql.append("p.sale, p.title, p.highlight, p.new_product, p.details, p.created_at, p.update_at, ");
		sql.append("c.name as name_color, c.id as id_color, c.code as code_color, c.img  from products as p ");
		sql.append("inner join colors as c on p.id = c.id_product group by p.id, c.id_product");
		return sql.toString();
	}
	
	public List<ProductsDto> getDataProducts() {
		String sql = SqlString();
		List<ProductsDto> listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	} 
}
