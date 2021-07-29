package br.com.evandro.hrpayroll.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Worker {

	private Long id;

	private String name;
	
	private Double dailyIncome;

}
