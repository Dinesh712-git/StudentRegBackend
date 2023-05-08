package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.student;
import com.example.demo.Repository.repository;

@RestController
public class controller {
	@Autowired
	private repository rep;
	//add student
	@PostMapping("/save")
	public student addstudent(@RequestBody student st) {
        return rep.save(st);
	}
	//add more student
	@PostMapping("/saveall")
	public List<student> multiplestudent(@RequestBody List<student> stt){
		return rep.saveAll(stt);
	}
	//delete student using id
	@DeleteMapping("/delete/{id}")
	public String deleteusingid(@PathVariable Long id)
	{
		rep.deleteById(id);
		return("delete successful");
	}
	
	//find all
	@GetMapping("/findall")
	public List<student> findall()
	{
		return rep.findAll();
	}
	
	//find using id
	@GetMapping("/findbyid/{id}")
	public student finduserid(@PathVariable Long id)
	{
		return rep.findById(id).orElse(null);
	}
	//update
	@PutMapping("/update")
	public student updatestudent(student st)
	{
		student stu=rep.findById(st.getId()).orElse(null);
		stu.setName(st.getName());
		stu.setAddress(st.getAddress());
		stu.setCard(st.getCard());
		
		return rep.save(stu);
	}

}
