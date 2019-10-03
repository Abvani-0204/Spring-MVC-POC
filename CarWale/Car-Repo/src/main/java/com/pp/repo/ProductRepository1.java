package com.pp.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pp.model.Product;

@Repository
public class ProductRepository1 {
	@Autowired
	  private HibernateTemplate template;
	
	public void saveDataRepo(Product bk) {
		if(bk!= null && bk.getProductPrice()!=0) {
		System.out.print(bk.getProductName());
		System.out.println(bk.getProductDescription() );
		System.out.println(bk.getProductPrice() );
		System.out.println(bk.getDateOfIssue() );
		template.save(bk);
		System.out.println("product saving");
		}
		else
		{
			System.out.print("empty object");	
		}
}
	 public List<Product> fetchDataRepo(){
		  List<Product> pList= template.find("from Product");
		  return pList;
	  }

}