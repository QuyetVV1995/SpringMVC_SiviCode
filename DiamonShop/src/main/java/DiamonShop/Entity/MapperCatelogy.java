package DiamonShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperCatelogy implements RowMapper<Catelogy> {

	public Catelogy mapRow(ResultSet rs, int rowNum) throws SQLException {
		Catelogy catelogy = new Catelogy();	
		catelogy.setId(rs.getInt("id"));	// Lay theo field trong database
		catelogy.setName(rs.getString("name"));
		catelogy.setDescription(rs.getString("description"));
		return catelogy;
	}

}
