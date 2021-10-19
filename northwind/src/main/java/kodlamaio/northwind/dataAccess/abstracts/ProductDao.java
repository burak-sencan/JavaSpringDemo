package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.conctretes.Product;
//Product nesnesi için Primary key int olacak şekilde JpaRepository generic olarak tanımland

public interface ProductDao extends JpaRepository<Product, Integer>{
	
	Product getByProductName(String productName);
	
	Product getByProductNameAndCategory(String productName, int categoryId);
	
	//select * from product where product_name = Abc or category_id = 1
	List<Product> getByProductNameOrCategory(String productName, int categoryId);
	
	//select * from product where  category_id in (1,2,3,4)
	List<Product> getByCategoryIn(List<Integer> category);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	//SELECT * FROM Product WHERE product_name = bişey and category_id = 1
	@Query("From Product where productName = :productName and category.categoryId= :categoryId")
	List<Product> getByNameAndCategory(String productName, int categoryId);

	
}
