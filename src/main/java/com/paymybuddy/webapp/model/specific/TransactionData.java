package com.paymybuddy.webapp.model.specific;

import lombok.Data;


@Data
public class TransactionData {


   private String description;

   private Float amount;

   private String receiverEmail;
}