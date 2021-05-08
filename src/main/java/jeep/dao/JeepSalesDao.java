package jeep.dao;

import java.util.List;

import jeep.entity.Jeep;
import jeep.entity.jeepModel;

public interface JeepSalesDao {

	List<Jeep> fetchJeeps(jeepModel model, String trim);

}
