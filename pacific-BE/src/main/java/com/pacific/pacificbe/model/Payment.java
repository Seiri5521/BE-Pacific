package com.pacific.pacificbe.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @Size(max = 255)
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @Column(name = "total_price", precision = 19, scale = 4)
    private BigDecimal totalPrice;

    @Size(max = 255)
    @Nationalized
    @Column(name = "payment_method")
    private String paymentMethod;

    @Size(max = 255)
    @Nationalized
    @Column(name = "paymet_status")
    private String paymetStatus;

    @Size(max = 255)
    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "payment_date")
    private Instant paymentDate;

    @Size(max = 255)
    @Nationalized
    @Column(name = "notes")
    private String notes;

    @OneToMany(mappedBy = "payment")
    private Set<Invoice> invoices = new LinkedHashSet<>();

}