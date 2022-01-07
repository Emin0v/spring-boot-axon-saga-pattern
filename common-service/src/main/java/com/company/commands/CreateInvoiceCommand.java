package com.company.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateInvoiceCommand {

    @TargetAggregateIdentifier
    public String paymentId;

    public String orderId;

}
