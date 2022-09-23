// import java.io.File;
import java.util.*;
import java.sql.*;

public class Items{
    static Connection con;    

    Items(){
        con = connect.getConnection();

        if (con == null) {
            System.out.println("Connection failed!");
        } else {
            System.out.println("Successfully Connected to the Database!");
            // create if author already doesn't exist
        }
    }

    void Create(Question q){

        if (con == null) {
            System.out.println("Not connected to Database!");

            return;
        }
        
        try {
            Statement st = con.createStatement();
            String qr = "insert into questions values (" + Integer.toString(q.getId()) + "," + Integer.toString(q.getVersion()) + ",'" + Integer.toString(q.getType()) + ",'" + q.getSubject() + "','" + q.getQues() + "', null, null, null, null);";
            
            if (!q.isSubjective()) {
                String[] temp = q.getOptions();

                qr = "insert into questions values (" + Integer.toString(q.getId()) + "," + Integer.toString(q.getVersion()) + ",'" + q.getSubject() + "','" + q.getQues() + "','" + temp[0]+ "','" + temp[1]+ "','" + temp[2]+ "','" + temp[3] + "');";
            }
            
            int mod = st.executeUpdate(qr);

            System.out.println("Number of statements affected: " + Integer.toString(mod));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    // void ReadFile(Question q, String path){

    //     if (con == null) {
    //         System.out.println("Not connected to Database!");

    //         return;
    //     }
    // }
    
    void ReplaceVer(Question q, int ver){

        if (con == null) {
            System.out.println("Not connected to Database!");

            return;
        }

        try {
            Statement st = con.createStatement();
            String query = "update questions set Question='" + q.getQues() + "' where ID=" + Integer.toString(q.getId()) + " and Subject like '" + q.getSubject() + "' and Version=" + Integer.toString(ver) + ";";
            int mod = st.executeUpdate(query);

            System.out.println("Number of statements affected: " + Integer.toString(mod));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    void Delete(int ID, int ver){

        if (con == null) {
            System.out.println("Not connected to Database!");

            return;
        }

        try {
            Statement st = con.createStatement();
            String query = "delete from questions where ID=" + Integer.toString(ID) + "' and Version=" + Integer.toString(ver) + ";";
            int mod = st.executeUpdate(query);

            System.out.println("Number of statements affected: " + Integer.toString(mod));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    void Display(){

        if (con == null) {
            System.out.println("Not connected to Database!");

            return;
        }

        try {
            Statement st = con.createStatement();
            String query = "select * from questions";
            ResultSet rs = st.executeQuery(query);

            // System.out.println("Number of statements affected: " + Integer.toString(mod));
            while(rs.next()){
                int id = rs.getInt("ID");
                int ver = rs.getInt("Version");
                int type = rs.getInt("Type");
                String subject = rs.getString("Subject");
                String ques = rs.getString("Question");
                String Option1 = rs.getString("Option1");
                String Option2 = rs.getString("Option2");
                String Option3 = rs.getString("Option3");
                String Option4 = rs.getString("Option4");

                System.out.println(Integer.toString(id)+"\t"+Integer.toString(ver)+"\t"+Integer.toString(type)+"\t"+subject+"\t"+ques+"\t"+Option1+"\t"+Option2+"\t"+Option3+"\t"+Option4);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    static void closeConnection() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

