import javax.swing.AbstractAction;

abstract class Question{
    public abstract int getId();
    public abstract String getQues();
    public abstract int getVersion();
    public abstract String getSubject();
    public abstract boolean isSubjective();
    public abstract void initialize(int ID, String subject);
    public abstract void addQ(String q);
    public abstract void storeFile(String path);
    public abstract void setVersion(int ver);
    
    public void addOptions(String[] inp) {}
    public String[] getOptions() {
        return null;
    }
}