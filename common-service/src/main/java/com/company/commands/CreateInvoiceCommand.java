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
    private String paymentId;

    private String productUuid;

    private String orderId;

}
