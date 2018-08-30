package com.eoh.assessment.assessment.repositories;

import com.eoh.assessment.assessment.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
