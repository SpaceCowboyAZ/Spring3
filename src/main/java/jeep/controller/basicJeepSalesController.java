package jeep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import entity.Jeep;
import entity.jeepModel;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class basicJeepSalesController implements JeepSalesController {

	
	@Autowired
	private service.JeepSalesService jeepSalesService;
	@Override
	public List<Jeep> fetchJeeps(jeepModel model, String trim) {
		log.debug("model={}, trim={}", model, trim);
		return jeepSalesService.fetchJeeps(model, trim);
	}

}
