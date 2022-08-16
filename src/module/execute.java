package module;


import config.DBhelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class execute implements store {

	private String name;
	
	
	public execute(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void insertProduct(product item) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = DBhelper.getDefaultInstance().getConnection();
		Statement stmt = connection.createStatement();
		String queryString = String.format("INSERT IN TO product VALUES('%d',N'%s','%s','%f','%s',N'%s','%s')",1,item.getName(),item.getType(),item.getPrice(),item.getImportDate(),item.getMadeIn(),item.getDescription().toString());
		stmt.executeUpdate(queryString);
		stmt.close();
	}

	@Override
	public product searchProductByType(String type) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = DBhelper.getDefaultInstance().getConnection();
		Statement stmt = connection.createStatement();
        String queryString2 = String.format("SELECT * FROM product WHERE type='%s'",type);
        product itemProduct = null;
        ResultSet rs = stmt.executeQuery(queryString2);
        if (rs.next()) 
        {
		  itemProduct = new product();
		  itemProduct.setName(rs.getNString("name"));
		  itemProduct.setType(rs.getString("type"));
		  itemProduct.setPrice(rs.getDouble("price"));
		  itemProduct.setImportDate(rs.getDate("importDate"));
		  itemProduct.setMadeIn(rs.getNString("madeIn"));
		  itemProduct.setDescription(rs.getString("description"));
		}
        rs.close();
        stmt.close();
		return itemProduct;
	}

	@Override
	public List<product> orderByASC() throws Exception {
		// TODO Auto-generated method stub
		Connection connection = DBhelper.getDefaultInstance().getConnection();
		Statement stmt = connection.createStatement();
        String sql = "SELECT * FROM product ODER BY price";
		ResultSet rs = stmt.executeQuery(sql);
		List<product> list = new ArrayList<product>();
		while(rs.next()) {
			  product item = new product();
			  item.setName(rs.getNString("name"));
			  item.setType(rs.getString("type"));
			  item.setPrice(rs.getDouble("price"));
			  item.setImportDate(rs.getDate("importDate"));
			  item.setMadeIn(rs.getNString("madeIn"));
			  item.setDescription(rs.getString("description"));
			  list.add(item);
		}
		return list;
	}

	@Override
	public List<product> listExpiration() throws Exception {
		// TODO Auto-generated method stub
		Connection connection = DBhelper.getDefaultInstance().getConnection();
		Statement stmt = connection.createStatement();
        String sql ="SELECT * FROM TOYS WHERE DATEDIFF(year, receiptDate, CURRENT_TIMESTAMP ) >  1;GO";
		
		ResultSet rs = stmt.executeQuery(sql);
		List<product> list = new ArrayList<product>();
		while(rs.next()) {
			product item = new product();
			item.setId(rs.getLong("id"));
			item.setName(rs.getNString("name"));
			item.setType(rs.getString("type"));
		    item.setPrice(rs.getDouble("price"));
			item.setImportDate(rs.getDate("importDate"));
			item.setMadeIn(rs.getNString("madeIn"));
			item.setDescription(rs.getString("description"));
			list.add(item);
		}
		rs.close();
		stmt.close();
		return list;
	}

}
