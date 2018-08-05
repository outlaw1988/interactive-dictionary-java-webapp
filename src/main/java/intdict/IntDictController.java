package intdict;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IntDictController {

	@RequestMapping("/")
	public String showLoginPage(ModelMap model){
		return "index";
	}

}
