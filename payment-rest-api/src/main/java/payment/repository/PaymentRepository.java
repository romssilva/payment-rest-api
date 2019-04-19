package payment.repository;

import org.springframework.data.repository.CrudRepository;

import payment.model.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {}
