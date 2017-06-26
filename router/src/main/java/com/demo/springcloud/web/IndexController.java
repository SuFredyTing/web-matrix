package com.demo.springcloud.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(value = {"","/index","/home"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }
    
}


@RestController
class UploadController {
	
	private RestTemplate  rest = new RestTemplate();

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(MultipartHttpServletRequest multiReq) {
    	MultipartFile file_matrix_a = multiReq.getFile("matrix_a");
    	MultipartFile file_matrix_b = multiReq.getFile("matrix_b");

    	String str_matrix_a = null;
    	String str_matrix_b = null; //"c c  c \n\rc";

    	try {
			str_matrix_a = new String(file_matrix_a.getBytes());
			System.out.println("matrix a");
			System.out.println(str_matrix_a);
			
			str_matrix_b = new String(file_matrix_b.getBytes());
			System.out.println("matrix b");
			System.out.println(str_matrix_b);
		} catch (IOException e) {
			e.printStackTrace();
		}	
    	    	
        return "计算结果:\n\r" + request(str_matrix_a, str_matrix_b);
    }

    private String request(String matrix_a, String matrix_b){
    	
    	String url = "http://localhost:8002/multiply?matrix_a={matrix_a}&matrix_b={matrix_b}";
    	
        Map<String, Object> values = new HashMap<String, Object>();
        values.put("matrix_a", matrix_a);
        values.put("matrix_b", matrix_b);
    	
    	return rest.getForObject(url, String.class, values);
    }
}
