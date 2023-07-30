/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos Coelho
 */
public class Database {
    private Connection conn;
    private String url = "jdbc:mysql://localhost:3306/cenaflix";
    private String username;
    private String password;
    
    public Database(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public boolean connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            
            return true;
        } 
        catch (ClassNotFoundException ex){
            System.out.println("Driver do banco de dados não disponível na biblioteca.");
            return false;
        }
        catch (SQLException ex){
            System.out.println("Erro ao se comunicar com o danco de dados: " + ex.getMessage());
            return false;
        }
    }
    
    public void disconect(){
        try{
            if (conn != null){
                conn.close();
            }
        }
        catch (SQLException ex){
            System.out.println("Erro ao se comunicar com o danco de dados: " + ex.getMessage());
        }
    }
    
    public boolean insertMovie(Movie movie){
        try{
            String queryString = String.format("insert into cenaflix.filmes (nome, datalancamento, categoria) values ('%s', '%s', '%s');", movie.getName(), movie.getReleaseDate(), movie.getCategory());            
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(queryString);
            return true;
        }
        catch (SQLException ex){
            System.out.println("Erro ao se comunicar com o danco de dados: " + ex.getMessage());
            return false;
        }        
    }
    
    public List<Movie> getAllMovies(){
        try{
            String queryString = String.format("select * from cenaflix.filmes;");
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(queryString);
            
            List<Movie> movieList = new ArrayList();
            while (resultSet.next()){
                String movName = resultSet.getString("nome");
                String movReleaseDate = resultSet.getString("datalancamento");
                String movCategory = resultSet.getString("categoria");
                movieList.add(new Movie(movName, movReleaseDate, movCategory));
            }
            return movieList;
        } 
        catch (SQLException ex){
             System.out.print("Ocorreu um erro ao se comunicar com o banco de dados: " + ex.getMessage());
             return new ArrayList();
        }
    }
}
