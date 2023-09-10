package com.parkinglot.controllers;

import com.parkinglot.dto.BillRequestDto;
import com.parkinglot.dto.BillResponseDto;
import com.parkinglot.models.Bill;
import com.parkinglot.services.BillService;

public class BillController {

    private BillService billService;

    public BillController(BillService billService){
        this.billService = billService;
    }

    BillResponseDto generateBill(BillRequestDto request){
        BillResponseDto response = new BillResponseDto();

        Long ticketId = request.getTicketId();
        Long gateId = request.getGateId();

        Bill bill;
        bill = billService.generateBill(ticketId, gateId);
        return response;

    }
}

