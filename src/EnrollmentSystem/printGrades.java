/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnrollmentSystem;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.ResultSet;

/**
 *
 * @author Viver
 */
public class printGrades {
    
    public static void main(String[] args){
        
        
        
        
    }
    
    
    public void printGrades(){
        Document doc = new Document();
        PdfWriter docWriter = null;
        
        
        try{
            Font textBold12 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0));
            Font text12 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, new BaseColor(0, 0, 0));
            docWriter = PdfWriter.getInstance(doc, new FileOutputStream("Report.pdf"));
            doc.open();
//            int pdfWidth = columnArr.size();
//            float perWidth = 100/pdfWidth;
            
            float[] columnWidths = {2f, 5f};
            float[] columnWidths2 = {2f, 2f, 2f, 2f, 2f,2f};
            
            PdfPTable table = new PdfPTable(columnWidths);
            table.setWidthPercentage(50f);
            table.getDefaultCell().setBorder(0);
            table.addCell(Image.getInstance("addulogo.jpg"));
            table.getDefaultCell().setBorder(0);
            table.addCell("Ateneo De Davao University\nRegistrars Office");
            doc.add(table);
            
            PdfPTable table2 = new PdfPTable(columnWidths2);
            table2.setWidthPercentage(90f);
            Paragraph paragraph = new Paragraph();
            
            insertSpace(table2, 6);
            insertCell(table2, "Student Grade Sheet", Element.ALIGN_CENTER, 6, textBold12, 0, 255, 255, 255);
            
            insertSpace(table2, 6);
            insertCell(table2, "Student ID: " + Login.pickedId, Element.ALIGN_LEFT, 3, textBold12, 0, 255, 255, 255);
            insertCell(table2, "School Year: " + Login.loggedDatabase, Element.ALIGN_LEFT, 3, textBold12, 0, 255, 255, 255);
            
            insertSpace(table2, 6);
            insertCell(table2, "Student Name: " + Login.studentName, Element.ALIGN_LEFT, 3, textBold12, 0, 255, 255, 255);
            insertCell(table2, "Student Course: " + Login.studentCourse,Element.ALIGN_LEFT, 3, textBold12, 0, 255, 255, 255);
            
            insertSpace(table2, 6);
            insertCell(table2, "Student Year: " + Login.studentYear, Element.ALIGN_LEFT, 6, textBold12, 0, 255, 255, 255);
            
            insertSpace(table2, 6);
            insertCell(table2, "Subject ID", Element.ALIGN_CENTER, 1, textBold12, 1, 255, 255, 255);
            insertCell(table2, "Subject Code", Element.ALIGN_CENTER, 1, textBold12, 1, 255, 255, 255);
            insertCell(table2, "Prelim", Element.ALIGN_CENTER, 1, textBold12, 1, 255, 255, 255);
            insertCell(table2, "Midterm", Element.ALIGN_CENTER, 1, textBold12, 1, 255, 255, 255);
            insertCell(table2, "Pre-Final", Element.ALIGN_CENTER, 1, textBold12, 1, 255, 255, 255);
            insertCell(table2, "Final", Element.ALIGN_CENTER, 1, textBold12, 1, 255, 255, 255);
            
            insertSpace(table2, 6);
            
            String query = String.format("SELECT subjects.subject_id, subjects.subject_code, prelim, midterm, prefinal, final FROM subjects INNER JOIN enroll ON subjects.subject_id = enroll.subject_id AND enroll.student_id = %s INNER JOIN grades ON enroll.enroll_id = grades.enroll_id", Login.pickedId);
            ResultSet rs = EnrollmentSystem.con.createStatement().executeQuery(query);
            
            int count = 0;
            while(rs.next()){
                if (rs.getString("subject_id").length() > 0){
                    insertCell(table2, rs.getString("subject_id"), Element.ALIGN_CENTER, 1, text12, 1, 255, 255, 255);
                }else{
                    insertCell(table2, "null" , Element.ALIGN_CENTER, 1, text12, 1, 255, 255, 255);
                }
                
                if (rs.getString("subject_code").length() > 0){
                    insertCell(table2, rs.getString("subject_code"), Element.ALIGN_CENTER, 1, text12, 1, 255, 255, 255);
                }else{
                    insertCell(table2, "null" , Element.ALIGN_CENTER, 1, text12, 1, 255, 255, 255);
                }
                
                if (rs.getString("prelim").length() > 0){
                    insertCell(table2, rs.getString("prelim"), Element.ALIGN_CENTER, 1, text12, 1, 255, 255, 255);
                }else{
                    insertCell(table2, "null" , Element.ALIGN_CENTER, 1, text12, 1, 255, 255, 255);
                }
                
                if (rs.getString("midterm").length() > 0){
                    insertCell(table2, rs.getString("midterm"), Element.ALIGN_CENTER, 1, text12, 1, 255, 255, 255);
                }else{
                    insertCell(table2, "null" , Element.ALIGN_CENTER, 1, text12, 1, 255, 255, 255);
                }
                
                if (rs.getString("prefinal").length() > 0){
                    insertCell(table2, rs.getString("prefinal"), Element.ALIGN_CENTER, 1, text12, 1, 255, 255, 255);
                }else{
                    insertCell(table2, "null" , Element.ALIGN_CENTER, 1, text12, 1, 255, 255, 255);
                }
                
                if (rs.getString("final").length() > 0){
                    insertCell(table2, rs.getString("final"), Element.ALIGN_CENTER, 1, text12, 1, 255, 255, 255);
                }else{
                    insertCell(table2, "null" , Element.ALIGN_CENTER, 1, text12, 1, 255, 255, 255);
                }
              
                count++;
                
            }
            
            insertSpace(table2, 6);
            insertCell(table2, "Number of Subjects Listed: " + count, Element.ALIGN_LEFT, 6, textBold12, 0, 255, 255, 255);
            paragraph.add(table2);
            doc.add(paragraph);
        }
        catch(Exception ex){
            System.out.println(ex);
            ex.printStackTrace();
        }
        if (doc != null){
            doc.close();
        }
        
        if (docWriter != null){
            docWriter.close();
        }
        
        try{
            Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "Report.pdf");
        }
        catch(Exception ex){
        }
    }
    
    
    
    public void insertCell(PdfPTable table, String text, int align, int colspan, Font font, int border, int r, int g, int b){
        PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
        cell.setHorizontalAlignment(align);
        cell.setColspan(colspan);
        if (border == 0){
            cell.setBorder(Rectangle.NO_BORDER);
        }
        else{
            cell.setBorder(Rectangle.BOX);
        }
        cell.setBackgroundColor(new BaseColor(r, g, b));
        table.addCell(cell);
    }
    
    public void insertSpace(PdfPTable table, int pdfWidth){
        PdfPCell cell = new PdfPCell();
        cell.setColspan(pdfWidth);
        cell.setMinimumHeight(15f);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);
    }
}
