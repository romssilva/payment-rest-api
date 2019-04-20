package payment.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import payment.model.Payment;
import payment.repository.PaymentRepository;

@RestController
public class PaymentController {
	
	@Autowired
	PaymentRepository paymentRepository;
	
	private final String API_VERSION = "/v1";
	
	@GetMapping(API_VERSION + "/payments")
    public Page<Payment> getAllPayments(
    		@RequestParam(value="pageNumber", required=false, defaultValue="0") int pageNumber,
    		@RequestParam(value="pageSize", required=false, defaultValue="10") int pageSize
		) {
		return paymentRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }
	
	@GetMapping(API_VERSION + "/payments/{id}")
    public Payment getPayment(@PathVariable Long id, HttpServletResponse response) {
		Optional<Payment> payment = paymentRepository.findById(id);
		
		if (payment.isPresent()) {
			return payment.get();
		}
		
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return null;
    }
	
	@PostMapping(API_VERSION + "/payments")
    public Payment addPayment(@RequestBody Payment newPayment, HttpServletResponse response) {
		Payment payment = paymentRepository.save(newPayment);
		response.setStatus(HttpServletResponse.SC_CREATED);
		return payment;
    }
	
	@PutMapping(API_VERSION + "/payments/{id}")
    public Payment updatePayment(@PathVariable Long id, @RequestBody Payment newPayment, HttpServletResponse response) {
		if (!paymentRepository.existsById(id)) {
			response.setStatus(HttpServletResponse.SC_CREATED);
		}
		return paymentRepository.save(newPayment);
    }
	
	@DeleteMapping(API_VERSION + "/payments/{id}")
    public void deletePayment(@PathVariable Long id, HttpServletResponse response) {
		paymentRepository.deleteById(id);
    }
}
