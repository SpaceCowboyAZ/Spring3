package service;



import java.util.List;

import entity.Jeep;
import entity.jeepModel;

public interface JeepSalesService {

	List<Jeep> fetchJeeps(jeepModel model, String trim);
}