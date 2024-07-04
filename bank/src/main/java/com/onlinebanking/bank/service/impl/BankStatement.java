package com.onlinebanking.bank.service.impl;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.onlinebanking.bank.dto.GenerateStatementDTO;
import com.onlinebanking.bank.entity.Transaction;
import com.onlinebanking.bank.entity.User;
import com.onlinebanking.bank.repository.TransactionRepository;
import com.onlinebanking.bank.repository.UserRepository;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class BankStatement {
  @Autowired
  private TransactionRepository transactionRepository;
  private UserRepository userRepository;

  public static final String filePath = "./bankStatement.pdf";

  public List<Transaction> generateStatement(GenerateStatementDTO statementDTO){
    LocalDate start = LocalDate.parse(statementDTO.startDate(), DateTimeFormatter.ISO_DATE);
    LocalDate end = LocalDate.parse(statementDTO.endDate(), DateTimeFormatter.ISO_DATE);

    return transactionRepository.findAll()
        .stream()
        .filter(transaction ->
            transaction.getAccountNumber().equals(statementDTO.accountNumber()))
        .filter(transaction ->
            !transaction.getCreatedAt().isBefore(start))
        .filter(transaction ->
            !transaction.getCreatedAt().isAfter(end))
        .toList();
  }

  private void designStatement(List<Transaction> transactionList, GenerateStatementDTO statementDTO)
      throws FileNotFoundException, DocumentException {
    Rectangle statementSize = new Rectangle(PageSize.A4);
    Document document = new Document(statementSize);
    log.info("Setting size of document");
    OutputStream outputStream = new FileOutputStream(filePath);
    PdfWriter.getInstance(document, outputStream);
    document.open();

    PdfPTable bankInfoTable = new PdfPTable(1);

    PdfPCell bankName = new PdfPCell(new Phrase("3ank"));
    bankName.setBorder(0);
    bankName.setBackgroundColor(BaseColor.BLUE);
    bankName.setPadding(20f);

    PdfPCell bankAddress = new PdfPCell(new Phrase("Lagos, Nigeria"));
    bankAddress.setBorder(0);
    bankInfoTable.addCell(bankName);
    bankInfoTable.addCell(bankAddress);

    PdfPTable statementInfo = new PdfPTable(2);
    PdfPCell customerInfo = new PdfPCell(new Phrase("Start Date: " + statementDTO.startDate()));
    customerInfo.setBorder(0);
    PdfPCell statement = new PdfPCell(new Phrase("Statement of Account"));
    statement.setBorder(0);

    PdfPCell stopDate = new PdfPCell(new Phrase("End Date: " + statementDTO.endDate()));
    stopDate.setBorder(0);

    User user = userRepository.findByAccountNumber(statementDTO.accountNumber());
    String customerName = user.getFirstName() +  " " + user.getLastName();

    PdfPCell name = new PdfPCell(new Phrase("Customer Name: " + customerName));
    name.setBorder(0);
    PdfPCell space = new PdfPCell();

    PdfPCell customerAddress = new PdfPCell(new Phrase("Customer Address: " + user.getAddress() ));
  }
}
