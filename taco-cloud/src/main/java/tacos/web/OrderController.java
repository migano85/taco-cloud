package tacos.web;
import javax.validation.Valid;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import lombok.extern.slf4j.Slf4j;
import tacos.TacoOrder;
import tacos.User;
import tacos.data.OrderRepository;
@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
@ConfigurationProperties(prefix="taco.orders")
public class OrderController {
	
//	private int pageSize = 20;
//	@Autowired
	private OrderRepository orderRepo;
	private OrderProps props;
	
	public OrderController(OrderRepository orderRepo,
			OrderProps props) {
			this.orderRepo = orderRepo;
			this.props = props;
			}
	
	@GetMapping("/current")
	public String orderForm(Model model) {
		model.addAttribute("tacoOrder", new TacoOrder());
		return "orderForm";
	}
	
	@PostMapping
	public String processOrder(@Valid TacoOrder order, Errors errors) {
	  log.info("Order submitted: {}", order);
//********I dont need vlaidation for now it's just waste of learning time****
//	  if (errors.hasErrors()) {
//	      return "orderForm";
//	  }
	  return "redirect:/";
	}
	
	@GetMapping
	public String ordersForUser(@AuthenticationPrincipal User user, Model model) {
	Pageable pageable = PageRequest.of(0, props.getPageSize());
	model.addAttribute("orders",
	orderRepo.findByUserOrderByPlacedAtDesc(user, pageable));
	return "orderList";
	}
}