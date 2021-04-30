package dao;

import java.util.List;

import entity.Jeep;
import entity.jeepModel;

public interface JeepSalesDao {

	List<Jeep> fetchJeeps(jeepModel model, String trim);

}
