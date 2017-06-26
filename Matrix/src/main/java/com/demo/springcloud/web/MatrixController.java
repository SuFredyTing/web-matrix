package com.demo.springcloud.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MatrixController {

	private String a[][] = null;
	private String b[][] = null;
	private RestTemplate  rest = new RestTemplate();
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info() {
        return "success";
    }
	
	@RequestMapping(value = "/multiply", method = RequestMethod.GET)
    public String multiply(@RequestParam(value = "matrix_a", required = true) String matrix_a,  
            			   @RequestParam(value = "matrix_b", required = true) String matrix_b) {
		System.out.println("matrix a:");
		System.out.println(matrix_a);
		System.out.println("matrix b:");
		System.out.println(matrix_b);
		
		a = matrixSplit(matrix_a);
		b = matrixSplit(matrix_b);
		
		String ret = new String("");
		
		for (int i=0;i<a.length; i++) {			
			String vector_a = new String("");			
			for (int j=0; j<a[i].length; j++) {
				vector_a = vector_a + a[i][j] + " ";
			}
			for (int m=0; m<b[0].length; m++) {
				String vector_b = new String("");
				for (int n=0; n<b.length; n++) {
					vector_b = vector_b + b[n][m] + " ";
				}
				ret += request(vector_a, vector_b) + " ";
			}
			ret += "\n\r";
		}
		
        return ret;
    }
	
	private String[][] matrixSplit(String matrix) {
		String[] lines = matrix.split("\r\n");
		
		String ret[][] = new String[lines.length][0];
		
		int i = 0;
		for (String x : lines) {
			ret[i] = x.split("\\s+");
			i++;
		}
		
		return ret;		
	}
	
	private String request(String vector_a, String vector_b){
		String url = "http://localhost:8003/multiply?vector_a={vector_a}&vector_b={vector_b}";
    	
        Map<String, Object> values = new HashMap<String, Object>();
        values.put("vector_a", vector_a);
        values.put("vector_b", vector_b);
    	
    	return rest.getForObject(url, String.class, values);
	}
}
