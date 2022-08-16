package module;

import java.util.List;

public interface store {
	
	public void insertProduct(product item) throws Exception;

	public product searchProductByType(String type) throws Exception;
			
	public List<product> orderByASC() throws Exception;

	public List<product> listExpiration() throws Exception;
	

}
