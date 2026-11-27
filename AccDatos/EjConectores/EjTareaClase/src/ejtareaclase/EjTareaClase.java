/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejtareaclase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author profesor
 */
public class EjTareaClase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       

        try (Connection conexion = Conexiones.mysql();
            Statement sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = sentencia.executeQuery("SELECT * FROM emp")) {
            
            while(rs.next()){
               
                String job = rs.getString("job");
                LocalDate fecha = rs.getDate("hiredate").toLocalDate();
                int dept = rs.getInt("deptno");
                double sal = rs.getDouble("sal");
                
                double multi = 0;
                
                if(job.equals("MANAGER")){
                    multi = 1.10;
                }else if(fecha.isBefore(LocalDate.of(1981, 9, 1))){
                    multi = 1.15;
                }else if(job.equals("ANALYST")&& dept == 20){
                    multi = 1.05;
                }else if(job.equals("SALESMAN")){
                    multi = 1.08;
                }else{
                    multi = 1.00;
                }
                
                System.out.println("Al empleado: " + rs.getString("ename") + " se le ha cambiado el sueldo de: " + sal + " a " + Math.round(sal * multi));
                rs.updateDouble("sal", Math.round(sal * multi) );
                rs.updateRow();
                
            }
            
            
           

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        //System.out.println(empleos);
    }
    
}
