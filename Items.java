import java.io.File;
import java.util.*;

public class Items{
    
    ArrayList<HashMap<String, ArrayList<Question>>> versions = new ArrayList<HashMap<String, ArrayList<Question>>>();

    public void Items(){}

    void Create(int ID, String subject, int ver, int type, String q){
    
        if (versions.size() < ver) {
            HashMap<String, ArrayList<Question>> map = new HashMap<String, ArrayList<Question>>();
            versions.add(map);
        }

        Subjective sub = new Subjective();

        sub.initialize(ID, subject);
        
        if (!versions.get(ver - 1).containsKey(subject)) {
            versions.get(ver - 1).put(subject, new ArrayList<Question>());
        }
        versions.get(ver - 1).get(subject).add(sub);
    
    }
    
    void Create(int ID, String subject, int ver, int type, String q, String[] options){
    
        if (versions.size() < ver) {
            HashMap<String, ArrayList<Question>> map = new HashMap<String, ArrayList<Question>>();
            versions.add(map);
        }
    
        MCQ mcq = new MCQ();

        mcq.initialize(ID, subject);
        
        if (!versions.get(ver - 1).containsKey(subject)) {
            versions.get(ver - 1).put(subject, new ArrayList<Question>());
        }

        versions.get(ver - 1).get(subject).add(mcq);
        
    }
    
    void ReadFile(int ID, String subject, int ver, String path){
        for (int i = 0; i < versions.get(ver - 1).get(subject).size(); i++) {
            if (versions.get(ver - 1).get(subject).get(i).getId() == ID) {
                versions.get(ver - 1).get(subject).get(i).storeFile(path);
                
                break;
            }
        }
    }
    
    void Modify(String subject, int ID, int ver, String mod){
    
        for (int i = 0; i < versions.get(ver - 1).get(subject).size(); i++) {                        
            if (versions.get(ver - 1).get(subject).get(i).getId() == ID) {
                versions.get(ver - 1).get(subject).get(i).addQ(mod);
    
                break;
            }
        }
    }
    
    void ReplaceVer(String subject, int ID, int ver, String mod){
        for (int i = 0; i < versions.get(ver - 1).get(subject).size(); i++) {                        
            if (versions.get(ver - 1).get(subject).get(i).getId() == ID) {
                versions.get(ver - 1).get(subject).get(i).addQ(mod);
    
                break;
            }
        }
    }
    
    void Delete(String subject, int ID, int ver){
    
        for (int i = 0; i < versions.get(ver - 1).get(subject).size(); i++) {
            if (ID == versions.get(ver - 1).get(subject).get(i).getId()) {
                versions.get(ver - 1).get(subject).remove(versions.get(ver - 1).get(subject).get(i));
    
                break;
            }
        }
    }
}

