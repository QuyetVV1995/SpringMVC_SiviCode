package DiamonShop.Dao;

import org.springframework.stereotype.Repository;

import DiamonShop.Entity.Users;

@Repository
public class UsersDao extends BaseDao{
	public int AddAccount(Users user) {
		StringBuffer  sql = new StringBuffer();
		sql.append("insert into users ( ");
		sql.append("	user, ");
		sql.append("	password, ");
		sql.append("	display_name, ");
		sql.append("	address ) ");
		sql.append("values ");
		sql.append("( ");
		sql.append(" '"+user.getUser()+"' , ");
		sql.append(" '"+user.getPassword()+"' , ");
		sql.append(" '"+user.getDisplay_name()+"' , ");
		sql.append(" '"+user.getAddress()+"' ");
		sql.append(")");
		
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}

}
