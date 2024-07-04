package com.onlinebanking.bank.controller;

import com.itextpdf.text.DocumentException;
import com.onlinebanking.bank.dto.GenerateStatementDTO;
import com.onlinebanking.bank.entity.Transaction;
import com.onlinebanking.bank.service.impl.BankStatement;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bankStatement")
public class TransactionController {

  @Autowired
  private BankStatement bankStatement;

  @GetMapping
  public List<Transaction> transactionList(@RequestParam("accountNumber") String accountNumber,
      @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
    GenerateStatementDTO statementDTO = GenerateStatementDTO.builder()
        .accountNumber(accountNumber)
        .startDate(startDate)
        .endDate(endDate)
        .build();
    return bankStatement.generateStatement(statementDTO);
  }
}
