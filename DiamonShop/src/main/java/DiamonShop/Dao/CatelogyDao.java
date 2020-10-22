package DiamonShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import DiamonShop.Entity.Catelogy;
import DiamonShop.Entity.MapperCatelogy;

@Repository
public class CatelogyDao {
	@Autowired
	JdbcTemplate _jdbcTemplate;
	public List<Catelogy> getDataCatelogy(){
		List<Catelogy> list = new ArrayList<Catelogy>();
		String sql = "select * from catelogy";
		list = _jdbcTemplate.query(sql, new MapperCatelogy());
		return list;	
	}
}
