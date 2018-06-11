package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Member;
import com.example.demo.domain.repository.DataTable;
import com.example.demo.domain.repository.DepartmentRepository;
import com.example.demo.domain.repository.MemberRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller()
public class MyController {

	@Autowired
	MemberRepository repository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	
	@RequestMapping("/")
	String goIndex() {
		
		return "index";
	}
	
	@RequestMapping("/h1")
	String goPageb() {
		
		return "dataTable/myJsp";
	}
	
	
	@RequestMapping("/hello")
	String goPagea() {
		
//		System.out.println("dh::");
//		repository.findAll(PageRequest.of(0,50)).getContent().stream().forEach(System.out::println);
//		System.out.println("dh::");
		
		return "hello";
	}
	
	@RequestMapping("/hi")
	String goPage() {
		
//		System.out.println("dh::");
//		repository.findAll(PageRequest.of(0,50)).getContent().stream().forEach(System.out::println);
//		System.out.println("dh::");
		
		return "dataTable/dataTableMain";
	}
	@RequestMapping("/hi2")
	String goPage2() {
		
//		System.out.println("dh::");
//		repository.findAll(PageRequest.of(0,50)).getContent().stream().forEach(System.out::println);
//		System.out.println("dh::");
		
		return "dataTable/dataTableMain2";
	}
	
	@RequestMapping("/hi3")
	String goPage3() {
		
//		System.out.println("dh::");
//		repository.findAll(PageRequest.of(0,50)).getContent().stream().forEach(System.out::println);
//		System.out.println("dh::");
		
		return "dataTable/dataTableMain3";
	}
	
	@RequestMapping("/hi4")
	String goPage4() {
		
//		System.out.println("dh::");
//		repository.findAll(PageRequest.of(0,50)).getContent().stream().forEach(System.out::println);
//		System.out.println("dh::");
		
		return "dataTable/dataTableMain4";
	}
	
	@RequestMapping("/tom")
	@ResponseBody 
	Map tomcatAjaxTest() throws JsonProcessingException {
		System.out.println("com here tom");
		System.out.println("com here version2");
		Map map = new HashMap<>();
		
		map.put("myData", "this is my data");
		
		
		return map;
		
	}
	
	
	@RequestMapping("/dataTable/myAjaxTable")
	@ResponseBody 
	Map goAjax() throws JsonProcessingException {
		
		
		ObjectMapper mapper =  new ObjectMapper();
		
		
		System.out.println("here");
		
		repository.findAll(PageRequest.of(0,50)).getContent().stream().forEach(System.out::println);
		
		System.out.println(repository.findAll(PageRequest.of(0,50)).getContent().size()+"dh size::");
		
		
		Map<String, Object> mymap = new HashMap<>(); 
//		mymap.put("data",  repository.findAll(PageRequest.of(0,50)).getContent());
		mymap.put("data",  repository.findAll());
		System.out.println(mymap);
		//myMap.put("data", "홍길동");
		
		//System.out.println(mapper.writeValueAsString(myMap));
		
	return mymap;
	}

	@RequestMapping("/dataTable/myAjaxTable3")
	@ResponseBody 
	Map goAjax3(DataTable dataDO) throws JsonProcessingException {
		
		ObjectMapper mapper =  new ObjectMapper();
		
		

		System.out.println("getiDisplayStart" + dataDO.getiDisplayStart());
		System.out.println("getiDisplayLength" + dataDO.getiDisplayLength());
		System.out.println("##########################################################################################");
		Page<Member> myPage = repository.findAll(PageRequest.of(dataDO.getiDisplayStart()/dataDO.getiDisplayLength(), dataDO.getiDisplayLength()));
		
		Map<String, Object> mymap = new HashMap<>(); 
		System.out.println("myData size "+myPage.getContent().size());
		List<Member> myData = myPage.getContent();
		
		long iTotalRecords  = myPage.getTotalElements();
		myData.stream().forEach(System.out::println);
		
		mymap.put("data",  myData);
		mymap.put("recordsTotal",  iTotalRecords);
		mymap.put("recordsFiltered",  iTotalRecords);
		
		
		System.out.println(mymap);

		
	return mymap;
	}
	
	
	@RequestMapping("/dataTable/myAjaxTable2")
	@ResponseBody 
	Map goAjax2() throws JsonProcessingException {
		
		
	
		System.out.println("myAjaxTable2 :: start");
		departmentRepository.findAll().stream().forEach(System.out::println);;		
		System.out.println("myAjaxTable2 :: end");
		Map<String, Object> mymap = new HashMap<>(); 
		mymap.put("data",  departmentRepository.findAll());
		System.out.println(mymap);
		
		
	return mymap;
	}
	
	@RequestMapping("/dataTable/myAjaxTable4")
	@ResponseBody 
	Map goAjax4(DataTable dataDO) throws JsonProcessingException {
		
		System.out.println("11111111111111111111111111111111");
		ObjectMapper mapper =  new ObjectMapper();
		System.out.println("11111111111111111111111111111111");
//		int param1 = (int) request.getAttribute("iDisplayStart");
//
//		System.out.println("param1 : "+param1);
		
		System.out.println("getiDisplayStart" + dataDO.getiDisplayStart());
		System.out.println("getiDisplayLength" + dataDO.getiDisplayLength());
		System.out.println("##########################################################################################");
		
		Member member = new Member();
//		System.out.println("member::"+member.toString());
		Page<Member> myPage =null;
		Optional<Member> myOptional = Optional.ofNullable(member);
		
		if(!dataDO.getsSearch().equals("")) {
			System.out.println("here");
			System.out.println("datado:"+dataDO.toString());
			System.out.println("dataDO:"+dataDO.getsSearch());
			
			System.out.println("member "+myOptional.isPresent());
			myOptional.get().setUserName(dataDO.getsSearch());
			System.out.println("memberUserName::"+myOptional.get().getUserName());
			myPage = repository.findByUserNameContaining(myOptional.get().getUserName(),(PageRequest.of(dataDO.getiDisplayStart()/dataDO.getiDisplayLength(), dataDO.getiDisplayLength())));
//			myPage = repository.findAll(PageRequest.of(dataDO.getiDisplayStart()/dataDO.getiDisplayLength(), dataDO.getiDisplayLength()));
			
		}else {
			System.out.println("else");
			myPage = repository.findAll(PageRequest.of(dataDO.getiDisplayStart()/dataDO.getiDisplayLength(), dataDO.getiDisplayLength()));
			System.out.println("here ");
		}
//		member.setUserName(dataDO.getsSearch());
		
		
		Map<String, Object> mymap = new HashMap<>(); 
		System.out.println("myData size "+myPage.getContent().size());
		List<Member> myData = myPage.getContent();
		
		long iTotalRecords  = myPage.getTotalElements();
		myData.stream().forEach(System.out::println);
		
		mymap.put("data",  myData);
		mymap.put("recordsTotal",  iTotalRecords);
		mymap.put("recordsFiltered",  iTotalRecords);
		
		
		System.out.println(mymap);

		
	return mymap;
	}
}
