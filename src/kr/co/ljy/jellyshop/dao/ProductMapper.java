package kr.co.ljy.jellyshop.dao;


import java.util.List;

import kr.co.ljy.jellyshop.vo.Product;

public interface ProductMapper {
	
	public void WriteProductController(Product product);
	
	public void UpdateProductController(Product product);

	public Product selectProductInfo(int no);

	public List<Product> SelectListProductByItemController(String string);

	public List<Product> SelectListProductByNameController(String string);

	public void DeleteProductController(int no);



}
