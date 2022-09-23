abstract class Question{
    public abstract int getId();
    public abstract String getQues();
    public abstract int getVersion();
    public abstract String getSubject();
    public abstract boolean isSubjective();
    public abstract void initialize(String subject, String q, int ID);
    public abstract void newVer(int ID, String subject, String q);
    public abstract void storeFile(String path);
    public abstract void setVersion(int ver);
    
    protected int type;
    public int getType(){return type;}
    
    public void addOptions(String[] inp) {}
    public String[] getOptions() {
        return null;
    }
}
