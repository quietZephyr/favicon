package com.to.crayon.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.to.crayon.dto.FaviconDTO;
import com.to.crayon.service.FaviconService;

/**
 * Web controller for the Favicon application. Contains GET and POST methods.
 * 
 * @author TOliveira
 *
 */
@Controller
public class FaviconController {
	
	@Resource(name = "faviconService")
	FaviconService faviconService;
	
	@PostMapping("/favicon")
    public String faviconSubmit(@ModelAttribute FaviconDTO faviconDTO) {
		faviconService.updateFaviconDTO(faviconDTO);
		return "favicon";
    }
	
	
	@GetMapping(value="/")
    public String homepage(Model model) {
		model.addAttribute("faviconDTO", new FaviconDTO());
        return "favicon";
    }
	

}
