package entity;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
	private String orderID;
	private Customer customerID;
	private LocalDate orderDate;
	private LocalDate requiredDate;
	private float freight;

	private List<OrderDetail> orderDetails;
}
