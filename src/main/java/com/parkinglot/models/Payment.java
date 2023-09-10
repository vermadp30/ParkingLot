package com.parkinglot.models;

import com.parkinglot.enums.PaymentMethod;
import com.parkinglot.enums.PaymentStatus;
import java.util.Date;
import java.util.List;

public class Payment extends BaseModel {
  private Bill bill;
  private List<PaymentMethod> paymentMethod;
  private List<PaymentStatus> paymentStatus;
  private String refId;
  private Date time;

  public Bill getBill() {
    return bill;
  }

  public void setBill(Bill bill) {
    this.bill = bill;
  }

  public List<PaymentMethod> getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(List<PaymentMethod> paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public List<PaymentStatus> getPaymentStatus() {
    return paymentStatus;
  }

  public void setPaymentStatus(List<PaymentStatus> paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }
}
