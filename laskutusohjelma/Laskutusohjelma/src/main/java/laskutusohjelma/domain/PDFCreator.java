
package laskutusohjelma.domain;

import com.itextpdf.barcodes.BarcodeEAN;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Table;
import com.itextpdf.test.annotations.type.SampleTest;

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

/**
 * Creates pdf file
 * @author ollijokinen
 */
public class PDFCreator {
    public static final String DEST = "PDFfiles/";
   
    /**
     * Defines layout parameters
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
        
        /**
         * MyLine's Override method. 
         * @return float lineWidth
         */
        @Override
        public float getLineWidth() {
            return lineWidth;
        }
        /**
         * MyLine's Override method. 
         * @param float user input
         */
        @Override
        public void setLineWidth(float lineWidth) {
            this.lineWidth = lineWidth;
        }
        /**
         * MyLine's overridable method. Returns color
         * @return Color
         */
        @Override
        public Color getColor() {
            return color;
        }
        
        /**
         * Set text color
         * @param color user input
         */
        @Override
        public void setColor(Color color) {
            this.color = color;
        }
        
        /**
         * get offSet
         * @return float offset
         */
        public float getOffset() {
            return offset;
        }
        
        /**
         * set offSet
         * @param poffset user input
         */
        public void setOffset(float poffset) {
            this.offset = offset;
        }
 
    }
 
    /**
     * Creates a pdf file with .pdf ending. Fills a form with product, user and customer details. 
     * @param dest user input
     * @param product user input
     * @param user user input
     * @param customer user input
     * @throws IOException database error catched
     */
    public void runPDF(String dest, Product product, User user, Customer customer) throws IOException {
        File file = new File(DEST + dest);
        file.getParentFile().mkdirs();
        new PDFCreator().createPdf(DEST + dest + ".pdf", product, user, customer);
    }
    
   
     /**
      * Text and layout for a pdf file
      * @param document user input
      * @param product user input
      * @param user user input
      * @param customer user input
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
    
    /**
     * Sets a title and its format. adds invoice details by using invoiceText method 
     * 
     * @param dest user input + defined .pdf
     * @param product user input
     * @param user user input
     * @param customer user input
     * @throws IOException database error catched
     */
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
        invoiceText(document, product, user, customer);
        document.close();
    }
    
    /**
     * generates a random reference number. 
     * @return Integer
     */
    public Integer referenceNumberGenerator() {
        return new Random().nextInt(9999 - 1000) + 1000;
    }
   
}    
