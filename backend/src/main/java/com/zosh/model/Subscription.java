package com.zosh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zosh.domain.PlanType;
import com.zosh.domain.SubscriptionType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate subscriptionStartDate;
    private LocalDate subscriptionEndDate;

    @Enumerated(EnumType.STRING)
    private SubscriptionType subscriptiontype;

    @Enumerated(EnumType.STRING)
    private PlanType planType;

    private boolean isValid;

    @OneToOne
    private User user;

    // -------------------------
    // No-args constructor
    // -------------------------
    public Subscription() {
    }

    // -------------------------
    // All-args constructor
    // -------------------------
    public Subscription(Long id, LocalDate subscriptionStartDate, LocalDate subscriptionEndDate,
                        SubscriptionType subscriptiontype, PlanType planType,
                        boolean isValid, User user) {
        this.id = id;
        this.subscriptionStartDate = subscriptionStartDate;
        this.subscriptionEndDate = subscriptionEndDate;
        this.subscriptiontype = subscriptiontype;
        this.planType = planType;
        this.isValid = isValid;
        this.user = user;
    }

    // -------------------------
    // Getters & Setters
    // -------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getSubscriptionStartDate() {
        return subscriptionStartDate;
    }

    public void setSubscriptionStartDate(LocalDate subscriptionStartDate) {
        this.subscriptionStartDate = subscriptionStartDate;
    }

    public LocalDate getSubscriptionEndDate() {
        return subscriptionEndDate;
    }

    public void setSubscriptionEndDate(LocalDate subscriptionEndDate) {
        this.subscriptionEndDate = subscriptionEndDate;
    }

    public SubscriptionType getSubscriptiontype() {
        return subscriptiontype;
    }

    public void setSubscriptiontype(SubscriptionType subscriptiontype) {
        this.subscriptiontype = subscriptiontype;
    }

    public PlanType getPlanType() {
        return planType;
    }

    public void setPlanType(PlanType planType) {
        this.planType = planType;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
