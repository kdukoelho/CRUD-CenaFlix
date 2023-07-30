/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Carlos Coelho
 */
public class DateFormatConverter {
    
    public static String convertFormat(String date){
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy"); 
            SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date data = inputFormat.parse(date);
            return newFormat.format(data);
        } catch (ParseException ex) {
            return ex.getMessage();
        }
    }
}