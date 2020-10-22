package DiamonShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShop.Entity.Catelogy;
import DiamonShop.Entity.MapperCatelogy;

@Repository
public class CatelogyDao extends BaseDao {

	public List<Catelogy> getDataCatelogy(){
		List<Catelogy> list = new ArrayList<Catelogy>();
		String sql = "select * from catelogy";
		list = _jdbcTemplate.query(sql, new MapperCatelogy());
		return list;	
	}
}
