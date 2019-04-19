package payment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long ccNumber;
    private int ccVerificationValue;
    private String ccExpiration;
    private String ccOwner;
    private String status;
    private Double amount;
    
    public Payment() {}

    public Payment(Long id, Long userId, Long ccNumber, int ccVerificationValue, String ccExpiration, String ccOwner, String status, Double amount) {
    	this.id = userId;
    	this.userId = userId;
        this.ccNumber = ccNumber;
        this.ccVerificationValue = ccVerificationValue;
        this.ccExpiration = ccExpiration;
        this.ccOwner = ccOwner;
        this.status = status;
        this.amount = amount;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(Long ccNumber) {
		this.ccNumber = ccNumber;
	}

	public int getCcVerificationValue() {
		return ccVerificationValue;
	}

	public void setCcVerificationValue(int ccVerificationValue) {
		this.ccVerificationValue = ccVerificationValue;
	}

	public String getCcExpiration() {
		return ccExpiration;
	}

	public void setCcExpiration(String ccExpiration) {
		this.ccExpiration = ccExpiration;
	}

	public String getCcOwner() {
		return ccOwner;
	}

	public void setCcOwner(String ccOwner) {
		this.ccOwner = ccOwner;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
