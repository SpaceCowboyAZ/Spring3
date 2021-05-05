package service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import entity.Jeep;
import entity.jeepModel;

public interface JeepSalesService {
	 @Autowired
	/**
	   * Return a list of Jeeps given a model and trim level.
	   * @param model
	   * @param trim
	   * @return
	   */
	List<Jeep> fetchJeeps(jeepModel model, String trim);
}