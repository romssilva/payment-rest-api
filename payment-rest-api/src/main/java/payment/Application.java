package payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import payment.model.Payment;
import payment.repository.PaymentRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	PaymentRepository paymentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		paymentRepository.save(new Payment(null, new Long(1), new Long("4111111111111111"), 123, "04/21", "ROMULO S NASCIMENTO", "PROCESSING", 14.95));
	}
}
