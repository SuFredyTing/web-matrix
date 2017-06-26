package com.demo.springcloud.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VectorController {
	
	private String a[] = null;
	private String b[] = null;

	@RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info() {
        return "success";
    }
	
	@RequestMapping(value = "/multiply", method = RequestMethod.GET)
    public String multiply(@RequestParam(value = "vector_a", required = true) String vector_a,  
            			   @RequestParam(value = "vector_b", required = true) String vector_b) {
		System.out.println("vector a:");
		System.out.println(vector_a);
		System.out.println("vector b:");
		System.out.println(vector_b);
		
		a = vectorSplit(vector_a);
		b = vectorSplit(vector_b);
		
		int ret = 0;
		for (int i=0;i<a.length;i++) {
			//a[i].replaceAll(" ", "");
			//a[i].replaceAll("\n", "");
			//b[i].replaceAll(" ", "");
			b[i].replaceAll("\n\r", "");
			b[i].replaceAll("\r\n", "");
			System.out.println("*"+a[i] + "*" + b[i]+"*");
			int l = Integer.valueOf(a[i]);
			int r = Integer.valueOf(b[i]);
			ret = ret + l * r;
		}
		
		return "" + ret;
	}
	
	private String[] vectorSplit(String vector) {	
		return vector.split("\\s+");		
	}
	
}
