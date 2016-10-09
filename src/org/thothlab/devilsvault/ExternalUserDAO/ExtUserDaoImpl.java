package org.thothlab.devilsvault.ExternalUserDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.core;
import org.thothlab.devilsvault.ExternalUserModel.ExtUser;


public class ExtUserDaoImpl implements ExtUserDao{
	private JDBCType jdbcTemplate;
	public ExtUserDaoImpl(){}
	public ExtUserDaoImpl(DataSource dataSource) {
		this.jdbcTemplate = new JDBCType();
	}
	
	public ArrayList<Float> ViewBalance(ExtUser user)
	{
		String sql ="SELECT * FROM  savings_accounts WHERE id="+user.getID();
		ArrayList<Float> balances= new ArrayList<Float>();
		List accounts = jdbcTemplate.queryForList(sql);
		balances.add((Float)accounts.get(0));
		sql ="SELECT * FROM  checkings_accounts WHERE id="+user.getID();
		accounts = jdbcTemplate.queryForList(sql);
		balances.add((Float)accounts.get(0));
		return balances;
     }
}