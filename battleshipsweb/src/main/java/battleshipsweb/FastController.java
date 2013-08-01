package battleshipsweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FastController {
	
	@RequestMapping("/")
	public String simple(Model model) {
		
		model.addAttribute("msg", "dzialam");
		
		return "WEB-INF/prosto.jsp";
	}
}
