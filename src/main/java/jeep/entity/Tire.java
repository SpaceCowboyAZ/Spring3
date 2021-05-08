package jeep.entity;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Tire {
private Long tirePk;
private String tireId;
private String tireSize;
private String manufacture;
private BigDecimal price;
private int warrantyMiles;
}
