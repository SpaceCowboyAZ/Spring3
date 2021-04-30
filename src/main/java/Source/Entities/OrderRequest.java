package Source.Entities;

import java.util.List;

import lombok.Builder;
import lombok.Data;




@Data
@Builder
public class OrderRequest {
  private String customer;
  private String model;
  private String trim;
  private int doors;
  private String color;
  private String engine;
  private String tire;

  private List<String> options;
}
