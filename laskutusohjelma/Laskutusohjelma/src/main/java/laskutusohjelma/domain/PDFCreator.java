
package laskutusohjelma.domain;

import com.itextpdf.barcodes.BarcodeEAN;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Table;
//import com.itextpdf.samples.GenericTest;
import com.itextpdf.test.annotations.type.SampleTest;
//import org.junit.experimental.categories.Category;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.canvas.draw.ILineDrawer;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Tab;
import com.itextpdf.layout.element.TabStop;
import com.itextpdf.layout.property.TabAlignment;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;


public class PDFCreator {
    public static final String DEST = "PDFfiles/";
    /**
     * 
     * @param product
     * @param user
     * @param customer
     * @throws IOException 
     * runPDF metodi luo itse pdf tiedoston annettuun tallennussijaintiin
     */
    
    
    class MyLine implements ILineDrawer {
        private float lineWidth = 1;
        private float offset = 5;
        private Color color = Color.BLACK;
        @Override
        public void draw(PdfCanvas canvas, Rectangle drawArea) {
            canvas.saveState()
                .setStrokeColor(color)
                .setLineWidth(lineWidth)
                .moveTo(drawArea.getX(), drawArea.getY() + lineWidth / 2 + offset)
                .lineTo(drawArea.getX() + drawArea.getWidth(), drawArea.getY() + lineWidth / 2 + offset)
                .stroke()
                .restoreState();
        }
 
        @Override
        public float getLineWidth() {
            return lineWidth;
        }
        @Override
        public void setLineWidth(float lineWidth) {
            this.lineWidth = lineWidth;
        }
        @Override
        public Color getColor() {
            return color;
        }
        @Override
        public void setColor(Color color) {
            this.color = color;
        }
        public float getOffset() {
            return offset;
        }
        public void setOffset(float poffset) {
            this.offset = offset;
        }
 
    }
 
    
    public void runPDF(String dest, Product product, User user, Customer customer) throws IOException {
        File file = new File(DEST + dest);
        file.getParentFile().mkdirs();
        new PDFCreator().createPdf(DEST + dest + ".pdf", product, user, customer);
    }
    
    /**
     * 
     * @param dest tallennussijainti
     * @param product käyttäjä antaa
     * @param user käyttäjä antaa
     * @param customer käyttäjä antaa
     * @throws IOException 
     */
    
    public void createPDF(String dest, Product product, User user, Customer customer) throws IOException {
        FileOutputStream fos = new FileOutputStream(dest);
        PdfWriter writer = new PdfWriter(fos);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        invoiceText(document, product, user, customer);
    }
    
    /**
     * @param syötteet annetaan käyttöliittymässä käyttäjän toimesta. 
     * User tiedot täyttyvät automaattisesti, kun käyttäjä luonut profiilin. 
    *Tässä täytetään laskun tiedot 
    */
     
    public void invoiceText(Document document, Product product, User user, Customer customer) {
        //layout
        document.add(new Paragraph("\n" + "\n"));  
        document.add(new Paragraph("\n" + "\n"));  
        document.add(new Paragraph("TO: "));
        document.add(new Paragraph("Customer: " + customer.getName() + "\n" + "Customer's yNumber: " + customer.getyTunnus()));
        document.add(new Paragraph("\n" + "\n"));  
        document.add(new Paragraph("Product: " + product.getPname() + "\n " + "Price per unit: " + product.getPpu() + "\n" + "Amount: " + product.getAmount() + "\n  " + "VAT%: " + product.getVat()));
        document.add(new Paragraph("FINAL PRICE: " + product.getPrice()));
        document.add(new Paragraph("\n" + "\n")); 
        document.add(new Paragraph("Message: " + product.getMessage())); 
        document.add(new Paragraph("Date: " + product.getDate())); 
        document.add(new Paragraph("Reference number: " + referenceNumberGenerator()));
        document.add(new Paragraph("\n" + "\n"));
        document.add(new Paragraph("FROM: \n" + "Company: " + user.getName() + "\n" + "Bank account: " + user.getTilinumero() + "\n" + "yNumber: " + user.getYtunnus()));  
        
        document.close(); 
    }
    
    public void createPdf(String dest, Product product, User user, Customer customer) throws IOException {
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        PageSize pagesize = PageSize.A4; //page size is A4
        Document document = new Document(pdf, pagesize);
        
        float w = pagesize.getWidth() - document.getLeftMargin() - document.getRightMargin();
        MyLine line = new MyLine();
        List<TabStop> tabstops = new ArrayList();
        tabstops.add(new TabStop(w / 2, TabAlignment.CENTER, line));  //title to center
        tabstops.add(new TabStop(w, TabAlignment.LEFT, line));
        Paragraph p = new Paragraph();
        p.addTabStops(tabstops);
        p.add(new Tab()).add("Incredible Invoices").add(new Tab());
        document.add(p);
        //document.add(createBarcode(dest, pdf));
        
        //add invoice details - customer, price etc. 
        invoiceText(document, product, user, customer);
        
        
       
        
        document.close();
    }
    
    public Integer referenceNumberGenerator() {
        return new Random().nextInt(9999 - 1000) + 1000;
    }
   
}    
