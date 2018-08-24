package hello;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Controller
public class WebController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
		registry.addViewController("/badresultsboy").setViewName("badresultsboy");
		registry.addViewController("/login").setViewName("login");
		
		
		
		
		
		
    }
	
	//  @Override
   // public void addViewControllerss(ViewControllerRegistry registry) {
     //   registry.addViewController("/badresultsboy").setViewName("badresultsboy");
   // }

    @GetMapping("/")
    public String showForm(PersonForm personForm) {
        return "form";
    }
	
	
	@GetMapping("/login")
    public String showForms(PersonForm personForm) {
        return "login";
    }

    @PostMapping("/login")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "redirect:/badresultsboy";
        }

        return "redirect:/results";
    }
	
	//@PostMapping("/")
    //public String checkPersonInfo1(@Valid PersonForm personForm, BindingResult bindingResult) {

      //  return "redirect:/login";
    //}
	
}
