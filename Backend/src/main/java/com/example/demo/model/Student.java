package com.example.demo.model;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class Student {
	private int rollNo;
	private String name;
	private int marks;
}

