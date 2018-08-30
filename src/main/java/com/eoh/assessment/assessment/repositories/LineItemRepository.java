package com.eoh.assessment.assessment.repositories;

import com.eoh.assessment.assessment.domain.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineItemRepository extends JpaRepository<LineItem, Long> {
}
