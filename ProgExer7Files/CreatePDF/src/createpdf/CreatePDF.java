/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createpdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

/**
 *
 * @author User1
 */
public class CreatePDF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Document doc = new Document();
         PdfWriter docWriter = null;
         DecimalFormat df = new DecimalFormat("0.00");
         Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0));
         Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12);
  try {         
        String path = "report.pdf" ;
        docWriter = PdfWriter.getInstance(doc , new FileOutputStream(path));         
        doc.open();  
        float[] columnWidths2 = {2f, 5f};
        float[] columnWidths = {2f, 3f, 2f, 2f, 2f,2f};
        
   PdfPTable table2 = new PdfPTable(columnWidths2);
   table2.setWidthPercentage(50f);
   table2.getDefaultCell().setBorder(0);
   table2.addCell(Image.getInstance("X:\\Java\\EnrollmentSystem\\ProgExer7Files\\CreatePDF\\addulogo.jpg"));
   table2.getDefaultCell().setBorder(0);
   table2.addCell("Ateneo De Davao University\nRegistrars Office");
   doc.add(table2);
   
   PdfPTable table = new PdfPTable(columnWidths);
   table.setWidthPercentage(90f); 
   Paragraph paragraph = new Paragraph();
 
   insertCell(table, "My Grades", Element.ALIGN_LEFT, 6, bfBold12,1,255,255,255);     
   insertCell(table, "StudID", Element.ALIGN_CENTER, 1, bfBold12,1,255,255,255);  
   insertCell(table, "StudName", Element.ALIGN_CENTER, 1, bfBold12,1,255,255,255);  
   insertCell(table, "Prelim", Element.ALIGN_CENTER, 1, bfBold12,1,255,255,255);  
   insertCell(table, "Midterm", Element.ALIGN_CENTER, 1, bfBold12,1,255,255,255);  
   insertCell(table, "Prefinal", Element.ALIGN_CENTER, 1, bfBold12,1,255,255,255);  
   insertCell(table, "Final", Element.ALIGN_CENTER, 1, bfBold12,1,255,255,255);    
   
   for(int i=0;i<10;i++){
   insertCell(table, "123", Element.ALIGN_CENTER, 1, bfBold12,1,255,255,255);  
   insertCell(table, "Chris", Element.ALIGN_CENTER, 1, bfBold12,1,255,255,255);  
   insertCell(table, "A", Element.ALIGN_CENTER, 1, bfBold12,1,255,255,255);  
   insertCell(table, "B", Element.ALIGN_CENTER, 1, bfBold12,1,255,255,255);  
   insertCell(table, "C", Element.ALIGN_CENTER, 1, bfBold12,1,255,255,255);  
   insertCell(table, "C", Element.ALIGN_CENTER, 1, bfBold12,1,255,255,255);  
   }
   
   paragraph.add(table);

   doc.add(paragraph);
   
    }

  catch (DocumentException dex)
  {
   dex.printStackTrace();
  }
  catch (Exception ex)
  {
   ex.printStackTrace();
  }
  finally
  {
   if (doc != null){
    //close the document
    doc.close();
   }
   if (docWriter != null){
    //close the writer
    docWriter.close();
   }
  }  
   try{
  Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "report.pdf");
    }catch(Exception e){

    } 
  
}
    
    
  private static void insertCell(PdfPTable table, String text, int align, int colspan, Font font,int border, int r, int g, int b){
  
  //create a new cell with the specified Text and Font
  PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
  //set the cell alignment
  
  
  cell.setHorizontalAlignment(align);
  //set the cell column span in case you want to merge two or more cells
  cell.setColspan(colspan);
  //in case there is no text and you wan to create an empty row
  if(text.trim().equalsIgnoreCase("")){
   cell.setMinimumHeight(10f);
  }
  if(border==0)
    cell.setBorder(Rectangle.NO_BORDER);
  else
    cell.setBorder(Rectangle.BOX);  
  cell.setBackgroundColor(new BaseColor(r,g,b));
  //add the call to the table
  table.addCell(cell);

 }   
    
}