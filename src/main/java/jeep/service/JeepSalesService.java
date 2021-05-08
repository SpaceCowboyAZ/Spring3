package jeep.service;



import java.util.List;

import jeep.entity.Jeep;
import jeep.entity.jeepModel;

public interface JeepSalesService {
	
	/**
	   * Return a list of Jeeps given a model and trim level.
	   * @param model
	   * @param trim
	   * @return
	   */
	List<Jeep> fetchJeeps(jeepModel model, String trim);
}