package co.grandcircus.springlab;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Grade {

	private Long id;
	private String name;
	private String type;
	private BigDecimal score;
	private BigDecimal total;
	
	public Grade(Long id, String name, String type, BigDecimal score, BigDecimal total) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.score = score;
		this.total = total;
	}
	
	public Grade() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	public BigDecimal getPercentage() {
		return score.divide(total, 1, RoundingMode.HALF_UP).multiply(new BigDecimal(100));
	}
}
