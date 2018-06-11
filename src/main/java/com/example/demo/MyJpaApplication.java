package com.example.demo;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.example.demo.domain.Department;
import com.example.demo.domain.Member;
import com.example.demo.domain.repository.DepartmentRepository;
import com.example.demo.domain.repository.MemberRepository;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class MyJpaApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MyJpaApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
	{
		return builder.sources(MyJpaApplication.class);
	}
	
	
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("onStartuphere !!");
		super.onStartup(servletContext);
	}

	@Bean
	public CommandLineRunner demo(MemberRepository repository,DepartmentRepository departmentRepository, ApplicationContext ctx) {
		return (agrs) -> {
			
		Department department = new Department();
		
		department.setDepartName("인사부");
		department.setRemark("비고 란입니다. ");
		
		departmentRepository.save(department);
		
		Department department2 = new Department();
		
		department2.setDepartName("개발부");
		department2.setRemark("비고 란입니다. ");
		
		departmentRepository.save(department2);
		
		Department department3 = new Department();
		
		department3.setDepartName("판매부");
		department3.setRemark("비고 란입니다. ");
		
		departmentRepository.save(department3);
		
		
		for(int i=0; i<100; i++) {
		
			Member member = new Member();
			member.setAge(i);
			member.setUserName(i+"길동");
			member.setDepartment(department);
			if(i>50) member.setDepartment(department2);
			repository.save(member);
		}
		
		System.out.println("----");
		List<Member> resultList = null;
		
		
		System.out.println("######");
		
	
		
		
		//repository.findFirst10ByDepartment(department, request).forEach(System.out::println);
		System.out.println("######");
		List<Member> result2 =  repository.findByDepartment(department2);
		System.out.println("--------*********------");
		result2.forEach(System.out::println);
		
		
		List<Member> result3 =  repository.findByDepartment(department);
		System.out.println("--------*********------");
		result3.forEach(System.out::println);
		
//		PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Direction.DESC,"age","id"));
		PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Direction.ASC,"age","id"));

		
		
		
		System.out.println(repository.findByDepartment(department, pageRequest).getContent().size());
		List<Member> result4 = repository.findByDepartment(department, pageRequest).getContent();
		
		System.out.println("total page ::"+repository.findByDepartment(department, pageRequest).getTotalPages());
		result4.forEach(System.out::println);
		
			
		System.out.println(pageRequest.getOffset()+"::off-set");
		System.out.println(pageRequest.getPageNumber()+"::pageNumber");
		System.out.println(pageRequest.getPageSize()+"::pageSize");
		System.out.println(pageRequest.getSort().toString()+"::getSort");
		
		System.out.println(repository.findByDepartment(department, pageRequest).getTotalElements()+"::total element");
		
		Predicate<Member> myPredicate = item ->item.getDepartment().getDepartName().equals("인사부");
		Predicate<Member> myPredicate2 = item ->item.getDepartment().getDepartName().equals("개발부");
		
		List<Member> result = repository.findAll(pageRequest).stream().filter(myPredicate).collect(Collectors.toList());
		System.out.println("myPredicate1");
		result.forEach(System.out::println);
		System.out.println("myPredicate2");
		int size = repository.findAll(pageRequest).getContent().size();
		System.out.println("size::"+size);

		repository.findByDepartment(department2,pageRequest).stream().forEach(System.out::println);
		
		  System.out.println("Let's inspect the beans provided by Spring Boot:");

//          String[] beanNames = ctx.getBeanDefinitionNames();
//          Arrays.sort(beanNames);
//          for (String beanName : beanNames) {
//              System.out.println(beanName);
//          }
		};
	}
}
