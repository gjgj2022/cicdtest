package com.example.springboot07.control;

import java.security.KeyStore.Entry.Attribute;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springboot07.dto.SampleDTO;

@Controller
@RequestMapping("/home")
public class HomeController {

	@GetMapping("/ex1")
	public void ex1() {
		System.out.println("------------> ex1");
	}
	
	@GetMapping("/ex2")
	public void ex2(Model model) {
		System.out.println("------------> ex2");
		List<SampleDTO> list = new ArrayList<SampleDTO>();
		for(Long i = 1L;i<10L;i++) {
			SampleDTO dto = SampleDTO.builder()
									 .sno(i)
									 .first("scott..."+i)
									 .last("tiger..."+i)
									 .regtime(LocalDateTime.now())
									 .build();
			list.add(dto);
		}
		
		model.addAttribute("list",list);
		
		System.out.println("list : "+list);
		
	}
	
	// 리다이렉트 매개변수
	@GetMapping("/ex3")
	public String ex3(RedirectAttributes redirectAttributes) {
		SampleDTO dto = SampleDTO.builder()
								 .sno(100L)
								 .first("scott")
								 .last("tiger")
								 .regtime(LocalDateTime.now())
								 .build();
		
		redirectAttributes.addFlashAttribute("result", "success");
		redirectAttributes.addFlashAttribute("dto", dto);
		
		return "redirect:/home/ex4";
	}
	
	@GetMapping("/ex4")
	public void ex4() {
		System.out.println(">>>>>>>>>>>>> : ex4");
	}
	// 표형태로 ex4.html 파일 작성
	
	@GetMapping("/ex5")
	public void ex5(Model model) {
		System.out.println("------------> ex2");
		List<SampleDTO> list = new ArrayList<SampleDTO>();
		for(Long i = 1L;i<10L;i++) {
			SampleDTO dto = SampleDTO.builder()
									 .sno(i)
									 .first("scott..."+i)
									 .last("tiger..."+i)
									 .regtime(LocalDateTime.now())
									 .build();
			list.add(dto);
		}
		
		model.addAttribute("list",list);
		
		System.out.println("list : "+list);
		
	}
	
	@GetMapping("/ex6")
	public void ex6(Model model) {
		System.out.println("------------> ex2");
		List<SampleDTO> list = new ArrayList<SampleDTO>();
		for(Long i = 1L;i<10L;i++) {
			SampleDTO dto = SampleDTO.builder()
									 .sno(i)
									 .first("scott..."+i)
									 .last("tiger..."+i)
									 .regtime(LocalDateTime.now())
									 .build();
			list.add(dto);
		}
		
		model.addAttribute("list",list);
		
		System.out.println("list : "+list);		
	}
	
	@GetMapping("/exview")
	public void exview(@RequestParam("sno")int sno, Model model) {
		model.addAttribute("sno", sno);
		
		
	}
	
	@GetMapping("/ex7")
	public void ex7(Model model) {
		System.out.println("------------> ex2");
		List<SampleDTO> list = new ArrayList<SampleDTO>();
		for(Long i = 1L;i<10L;i++) {
			SampleDTO dto = SampleDTO.builder()
									 .sno(i)
									 .first("scott..."+i)
									 .last("tiger..."+i)
									 .regtime(LocalDateTime.now())
									 .build();
			list.add(dto);
		}
		
		model.addAttribute("list",list);
		
		System.out.println("list : "+list);		
	}
	
	@GetMapping("/now")
	public void now(Model model) {
		
		Date d = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd : hh:mm:ss");
		
		String now = sdf.format(d);
		
		model.addAttribute("now", now);
		
		System.out.println("now : "+now);
		
	}
	
}
