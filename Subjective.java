import java.io.File;
import java.util.Scanner;

public class Subjective extends Question{
    int id, version;
    String subject, Ques;
    String[] options = null;
    static int versions = 1;

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
    public void initialize (String subject, String q, int ID) {
        this.id = ID;
        this.subject = subject;
        this.type = 2;
        this.version = 1;
        this.Ques = q;
        versions=1;
    }

    @Override
    public void newVer(int ID, String subject, String q){
        this.id = ID;
        this.version = versions+1;
        this.type = 2;
        this.subject = subject;
        this.Ques = q;
        versions++;
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
