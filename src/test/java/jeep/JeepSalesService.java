package jeep;

import java.util.List;

import org.springframework.stereotype.Service;

import entity.Jeep;
import entity.jeepModel;
@Service
public interface JeepSalesService {

	List<Jeep> fetchJeeps(jeepModel model, String trim);

}
