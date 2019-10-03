package com.pp.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pp.model.User;
import com.pp.model.WebServiceModel;

@Repository
public class WebServiceRepository {

	@Autowired
	private HibernateTemplate template;

	public void saveWebServiceData(WebServiceModel serviceModel) {
		System.out.println("Inside WebService Repository " + serviceModel.getUname());
		template.save(serviceModel);
	}

	public List<WebServiceModel> restCallAuthentication(String umail, String upassword) {
		System.out.println("Inside Rest authentication Method " + umail + " " + upassword);
		List<WebServiceModel> ls = template.find("from WebServiceModel us where us.umail = ? and us.upassword = ?", umail, upassword);
		System.out.println(ls);
		return ls;
	}

	public List<WebServiceModel> getWebModelDetails() {
		System.out.println("GET ALL WEB MODEL DETAILS");
		List<WebServiceModel> ls = template.find("from WebServiceModel");
		return ls;
	}

	public void updateModelDataById(WebServiceModel serviceModel, int id) {
		System.out.println("Inside Update Web Service data By id");
		WebServiceModel model = (WebServiceModel) template.get(WebServiceModel.class, id);
		if(model != null) {
			model.setUid(id);
			model.setUmail(serviceModel.getUmail());
			model.setUname(serviceModel.getUname());
			model.setUpassword(serviceModel.getUpassword());
			template.update(model);	
		}else {
			System.out.println("DATA WITH ID "+id+" NOT FOUND");
		}
		
	}
	
	public void deleteModelDataById(int id) {
		System.out.println("Inside Delete Service data by id");
		template.delete(template.get(WebServiceModel.class, id));
	}
}
