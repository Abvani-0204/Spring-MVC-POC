package com.pp.ws;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pp.model.WebServiceModel;
import com.pp.service.WebSrvService;

@Controller
public class LoginWebServiceController {

	static final Logger logger = Logger.getLogger(LoginWebServiceController.class);
	
	@Autowired
	private WebSrvService webSrvService;

	@Autowired
	private HttpServletRequest request;

	@RequestMapping(method = RequestMethod.GET, value = "ws")
	@ResponseBody
	public ResponseEntity getAllDetailsFromTable() {
		System.out.println("WEB SERVICE TO GET ALL DETAILS");
		List<WebServiceModel> ls = new ArrayList<WebServiceModel>();
		ls = webSrvService.getAllValuesFromWebServiceModel();
		ResponseEntity responseEntity = new ResponseEntity(ls, HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(method = RequestMethod.POST, value = "ws/save")
	@ResponseBody
	public ResponseEntity saveServiceModelData(@RequestBody WebServiceModel serviceModel) {
		System.out.println("Inside WebService SaveData " + serviceModel.getUname());
		ResponseEntity entity = new ResponseEntity(HttpStatus.OK);
		String message = (String) request.getAttribute("message");
		if (message.equalsIgnoreCase("CREDENTIALS MISMATCH")) {
			return new ResponseEntity(message, HttpStatus.UNAUTHORIZED);
		} else {
			webSrvService.saveWebsServiceDataFromServiceLayer(serviceModel);
			return new ResponseEntity(message, HttpStatus.OK);
		}

	}

	@RequestMapping(method = RequestMethod.PUT, value = "ws/update/{id}")
	@ResponseBody
	public ResponseEntity updateServiceModelDataById(@RequestBody WebServiceModel serviceModel, @PathVariable int id) {
		System.out.println("Inside WebService update Data");
		webSrvService.updateWebServiceDataById(serviceModel, id);
		ResponseEntity entity = new ResponseEntity(HttpStatus.OK);
		return entity;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "ws/delete/{id}")
	@ResponseBody
	public ResponseEntity deleteServiceDataById(@PathVariable int id) {
		System.out.println("INSIDE WEB SERVICE DELETE DATA");
		webSrvService.deleteWebServiceDataById(id);
		ResponseEntity entity = new ResponseEntity(HttpStatus.OK);
		return entity;
	}
}
