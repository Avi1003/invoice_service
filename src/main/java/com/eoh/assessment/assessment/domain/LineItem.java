package com.eoh.assessment.assessment.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Data
@Getter
@Setter
@Entity(name = "line_item")
public class LineItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long quantity;

    @Column
    private String description;

    @Column
    private BigDecimal unitPrice;


    public LineItem() {
    }

    public LineItem(Long id, Long quantity, String description, BigDecimal unitPrice) {
        this.id = id;
        this.quantity = quantity;
        this.description = description;
        this.unitPrice = unitPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getLineItemTotal(){
        return BigDecimal.valueOf((unitPrice.longValue())*(quantity));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineItem lineItem = (LineItem) o;
        return Objects.equals(id, lineItem.id) &&
                Objects.equals(quantity, lineItem.quantity) &&
                Objects.equals(description, lineItem.description) &&
                Objects.equals(unitPrice, lineItem.unitPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, description, unitPrice);
    }
}
