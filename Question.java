abstract class Question{
    public abstract int getId();
    public abstract String getQues();
    public abstract void initialize(int ID, String subject);
    public abstract void addQ(String q);
    public abstract void storeFile(String path);
    public abstract void setVersion(int ver);
}