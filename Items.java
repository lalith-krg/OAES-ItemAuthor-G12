// import java.io.File;
import java.util.*;
import java.sql.*;

public class Items{
    static Connection con;    
//     ArrayList<HashMap<String, ArrayList<Question>>> versions = new ArrayList<HashMap<String, ArrayList<Question>>>();

    Items(){
        con = connect.getConnection();

        if (con == null) {
            System.out.println("Connection failed!");
        } else {
            System.out.println("Successfully Connected to the Database!");
        }
    }

    void Create(Question q){

        if (con == null) {
            System.out.println("Not connected to Database!");

            return;
        }
        
        try {
            Statement st = con.createStatement();
            String qr = "insert into questions values (" + Integer.toString(q.getId()) + "," + Integer.toString(q.getVersion()) + ",'" + q.getSubject() + "','" + q.getQues() + "', null, null, null, null);";
            
            if (!q.isSubjective()) {
                String[] temp = q.getOptions();

                qr = "insert into questions values (" + Integer.toString(q.getId()) + "," + Integer.toString(q.getVersion()) + ",'" + q.getSubject() + "','" + q.getQues() + "','" + temp[0]+ "','" + temp[1]+ "','" + temp[2]+ "','" + temp[3] + "');";
            }
            
            int mod = st.executeUpdate(qr);

            System.out.println("Number of statements affected: " + Integer.toString(mod));
    
            // if (versions.size() < ver) {
            //     HashMap<String, ArrayList<Question>> map = new HashMap<String, ArrayList<Question>>();
            //     versions.add(map);
            // }

            // Subjective sub = new Subjective();

            // sub.initialize(ID, subject);
            
            // if (!versions.get(ver - 1).containsKey(subject)) {
            //     versions.get(ver - 1).put(subject, new ArrayList<Question>());
            // }
            // versions.get(ver - 1).get(subject).add(sub);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    // void Create(int ID, String subject, int ver, int type, String q, String[] options){

    //     if (con == null) {
    //         System.out.println("Not connected to Database!");

    //         return;
    //     }
    
    //     if (versions.size() < ver) {
    //         HashMap<String, ArrayList<Question>> map = new HashMap<String, ArrayList<Question>>();
    //         versions.add(map);
    //     }
    
    //     MCQ mcq = new MCQ();

    //     mcq.initialize(ID, subject);
        
    //     if (!versions.get(ver - 1).containsKey(subject)) {
    //         versions.get(ver - 1).put(subject, new ArrayList<Question>());
    //     }

    //     versions.get(ver - 1).get(subject).add(mcq);
        
    // }
    
    void ReadFile(int ID, String subject, int ver, String path){

        if (con == null) {
            System.out.println("Not connected to Database!");

            return;
        }

//         for (int i = 0; i < versions.get(ver - 1).get(subject).size(); i++) {
//             if (versions.get(ver - 1).get(subject).get(i).getId() == ID) {
//                 versions.get(ver - 1).get(subject).get(i).storeFile(path);
                
//                 break;
//             }
//         }
    }
    
    // void Modify(String subject, int ID, int ver, String mod){

    //     if (con == null) {
    //         System.out.println("Not connected to Database!");

    //         return;
    //     }
    
    //     for (int i = 0; i < versions.get(ver - 1).get(subject).size(); i++) {                        
    //         if (versions.get(ver - 1).get(subject).get(i).getId() == ID) {
    //             versions.get(ver - 1).get(subject).get(i).addQ(mod);
    
    //             break;
    //         }
    //     }
    // }
    
    void ReplaceVer(String subject, int ID, int ver, String modification){

        if (con == null) {
            System.out.println("Not connected to Database!");

            return;
        }

        try {
            Statement st = con.createStatement();
            String query = "update questions set Question='" + modification + "' where ID=" + Integer.toString(ID) + " and Subject like '" + subject + "' and Version=" + Integer.toString(ver) + ";";
            int mod = st.executeUpdate(query);

            System.out.println("Number of statements affected: " + Integer.toString(mod));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        // for (int i = 0; i < versions.get(ver - 1).get(subject).size(); i++) {                        
        //     if (versions.get(ver - 1).get(subject).get(i).getId() == ID) {
        //         versions.get(ver - 1).get(subject).get(i).addQ(mod);
    
        //         break;
        //     }
        // }
    }
    
    void Delete(String subject, int ID, int ver){

        if (con == null) {
            System.out.println("Not connected to Database!");

            return;
        }

        try {
            Statement st = con.createStatement();
            String query = "delete from questions where ID=" + Integer.toString(ID) + " and Subject like '" + subject + "' and Version=" + Integer.toString(ver) + ";";
            int mod = st.executeUpdate(query);

            System.out.println("Number of statements affected: " + Integer.toString(mod));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    
        // for (int i = 0; i < versions.get(ver - 1).get(subject).size(); i++) {
        //     if (ID == versions.get(ver - 1).get(subject).get(i).getId()) {
        //         versions.get(ver - 1).get(subject).remove(versions.get(ver - 1).get(subject).get(i));
    
        //         break;
        //     }
        // }
    }

    static void closeConnection() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

