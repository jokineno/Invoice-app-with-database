/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskutusohjelma.domain;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 *
 * @author ollijokinen
 */
public class PDFCreator {
    public static final String DEST = "PDFfiles/invoiceAppFile.pdf";
    
    public void runPDF(Product product, User user, Asiakas customer) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new PDFCreator().createPDF(DEST, product, user, customer);
    }
    
     public void createPDF(String dest, Product product, User user, Asiakas customer) throws IOException {
        FileOutputStream fos = new FileOutputStream(dest);
        PdfWriter writer = new PdfWriter(fos);
        
        PdfDocument pdf = new PdfDocument(writer);
        
        Document document = new Document(pdf);
        invoiceText(document, product, user, customer);
        
       
    }
     
    public void invoiceText(Document document, Product product, User user, Asiakas customer) {
        
        document.add(new Paragraph("Invoice"));
        document.add(new Paragraph("Sending date"));
        
        document.add(new Paragraph("Customer information"));
        document.add(new Paragraph(customer.getName()));
        document.add(new Paragraph(customer.getyTunnus()));
        
        document.add(new Paragraph("Product: " + product.getPname() + "  " + "Amount: " + product.getAmount() +"  "+ "VAT%: " + product.getVat()));
        document.add(new Paragraph("FINAL PRICE: " + product.getPrice()));
        document.add(new Paragraph("Message: ")); //from the user
        document.add(new Paragraph("Date")) ;  //from the user
        document.add(new Paragraph("\n" + "\n"));  //from the user
        document.add(new Paragraph("\n" + "\n"));  
        document.add(new Paragraph(user.getName() + "    " + user.getTilinumero() + "     "+ user.getYtunnus()));  
        
        
        document.close(); 
    }
}
