package jeep.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import jeep.entity.Jeep;
import jeep.entity.jeepModel;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class basicJeepSalesController implements JeepSalesController {

	
	@Autowired
	private jeep.service.JeepSalesService jeepsalesService;
	
	@Override
	public List<Jeep> fetchJeeps(jeepModel model, String trim) {
		log.debug("model={}, trim={}", model, trim);
		return jeepsalesService.fetchJeeps(model, trim);
	}

}
