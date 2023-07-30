/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author Carlos Coelho
 */
public class Movie {
    private String name;
    private String releaseDate;
    private String category;
    
    public Movie(String name, String releaseDate, String category){
        this.name = name;
        this.releaseDate = DateFormatConverter.convertFormat(releaseDate);
        this.category = category;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getReleaseDate(){
        return this.releaseDate;
    }
    
    public String getCategory(){
        return this.category;
    }
}
