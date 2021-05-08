package jeep.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
private Long customerPK;
private String customerID;
private String firstName;
private String lastName;
private String phone;
}
