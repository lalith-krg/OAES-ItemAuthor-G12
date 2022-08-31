import java.io.File;
import java.util.Scanner;

public class Subjective extends Question{
    int id, version;
    String subject, Ques;
    String[] options = null;

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public int getVersion() {
        return this.version;
    }

    @Override
    public String getSubject() {
        return this.subject;
    }

    @Override
    public String getQues(){
        return this.Ques; 
    }

    @Override
    public boolean isSubjective() {
        if (options == null) {
            return true;
        }
        return false;
    }

    @Override
    public void initialize (int ID, String subject) {
        this.id = ID;
        this.subject = subject;
    }

    @Override
    public void addQ (String q) {
        this.Ques = q;
    }

    @Override
    public void storeFile(String path) {
        StringBuilder sb = new StringBuilder();
        
        try {
            File file = new File(path);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                sb.append(sc.nextLine());
            }
            this.Ques = sb.toString();
            sc.close();
        } catch(Exception e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void setVersion(int ver) {
        this.version = ver;
    }
}
