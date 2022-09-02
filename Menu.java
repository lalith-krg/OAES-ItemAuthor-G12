import java.io.File;
import java.util.*;

public class Menu{
    
    Items items = new Items();
    public static void main(String[] args) {
        File file = new File("/Users/tarunreddy/Desktop/Semester 7/SA/OAES/OAES-ItemAuthor-G12/Instructions.txt");
        Menu menu = new Menu();
        
        try {
            Scanner sc = new Scanner(file);
            
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            boolean loop = true;
            Scanner inp = new Scanner(System.in);

            while (loop) {
                int op = inp.nextInt();
                inp.nextLine();

                if (op == 0) {
                    loop = false;
                } else if (op == 1) {
                    menu.Create(inp);
                } else if (op == 2) {
                    menu.Modify(inp);
                } else if (op == 3) {
                    menu.Delete(inp);
                }
            }

            inp.close();
            sc.close();
            Items.closeConnection();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    void Create(Scanner inp){

        System.out.println("Enter Subject:");
        String subject = inp.nextLine();

        System.out.println("Enter ID:");
        int ID = inp.nextInt();
        inp.nextLine();
    
        // System.out.println("Enter Version:");
        // int ver = inp.nextInt();
        // inp.nextLine();
        
        System.out.println("Type of question\n  1 MCQ\t2 Subjective\n");
        int type = inp.nextInt();
        inp.nextLine();

        while(true){
            System.out.println("1 To type down question\n2 To upload file\n");
            int flow = inp.nextInt();
            inp.nextLine();

            if(flow==1){
                System.out.println("Type your question below\n");
                String qStmt = inp.nextLine();
                
                if(type==1){

                    String[] options = new String[4];

                    System.out.println("Enter option 1:");
                    options[0] = inp.nextLine();

                    System.out.println("Enter option 2:");
                    options[1] = inp.nextLine();

                    System.out.println("Enter option 3:");
                    options[2] = inp.nextLine();

                    System.out.println("Enter option 4:");
                    options[3] = inp.nextLine();
                    
                    // Question q = QFactory.create(ID, subject, type, qStmt, options);
                    Question q = new MCQ();
                    q.initialize(ID, subject);
                    q.addQ(qStmt);
                    q.addOptions(options);
            
                    items.Create(q);
                }
                else{
                    
                    // Question q = QFactory.create(ID, subject, type, qStmt, options);
                    Question q = new Subjective();
                    q.initialize(ID, subject);
                    q.addQ(qStmt);

                    items.Create(q);
                }
                break;
            }
            else if(flow==2){
                System.out.println("Enter the file path:");
                String path = inp.nextLine();
                    
                Question q = new Subjective();
                q.initialize(ID, subject);
        
                items.ReadFile(q, path);
                break;
            }
            else{
                System.out.println("\nInvalid option. Please choose one of the below\n\n");
            }
        }

    }
    
    void Modify(Scanner inp){
        // System.out.println("Which subject do you want to modify:");
        // String subject = inp.nextLine();
    
        // System.out.println("Id of the question:");
        // int ID = inp.nextInt();
        // inp.nextLine();
    
        // System.out.println("Enter Version:");
        // int ver = inp.nextInt();
        // inp.nextLine();
    
        // System.out.println("Modification:");
        // String mod = inp.nextLine();

        // Display questions

        System.out.println("Enter ID of question you want to edit:");
        int ID = inp.nextInt();
        inp.nextLine();

        // check type of question
        int type = 1;

        while(true){
            System.out.println("1 To type down question\n2 To upload file\n");
            int flow = inp.nextInt();
            inp.nextLine();

            if(flow==1){
                System.out.println("Type your question below\n");
                String q = inp.nextLine();
                
                if(type==1){
                    // mcq
                    
                    // ques = new MCQ();
                    // ques.initialize(ID, subject);

                    String[] options = new String[4];

                    System.out.println("Enter option 1:");
                    options[0] = inp.nextLine();

                    System.out.println("Enter option 2:");
                    options[1] = inp.nextLine();

                    System.out.println("Enter option 3:");
                    options[2] = inp.nextLine();

                    System.out.println("Enter option 4:");
                    options[3] = inp.nextLine();
                    
                    // ques.addQ(q);
                    // ques.addOptions(options);
                    // items.Create(ques);
                }
                else{
                    // subjective
                }
                break;
            }
            else if(flow==2){
                System.out.println("Enter the file path:");
                String path = inp.nextLine();
        
                // items.ReadFile(ID, subject, ver, path);
                break;
            }
            else{
                System.out.println("Invalid option. Please choose one of the below\n");
            }
        }

        while(true){
            System.out.println("1 To create new version of question\n2 To replace last version");
            int flow = inp.nextInt();
            inp.nextLine();

            if(flow==1){
                // System.out.println("Type your question below");
                // String q = inp.nextLine();
                // inp.nextLine();

                System.out.println("Enter Version:");
                int ver = inp.nextInt();
                inp.nextLine();

                // check which type of question
                // AND ask new statements OR file upload

                break;
            }
            else if(flow==2){
                // System.out.println("Enter the file path:");
                // String path = inp.nextLine();
        
                // items.ReadFile(ID, subject, ver, path);

                // ReplaceVer(inp);
            }
            else{
                System.out.println("Invalid option. Please choose one of the below");
            }
        }

        // items.Modify(subject, ID, ver, mod);
    }
    
    // void ReplaceVer(Scanner inp){
    //     System.out.println("Which subject do you want to modify:");
    //     String subject = inp.nextLine();
    
    //     System.out.println("Id of the question:");
    //     int ID = inp.nextInt();
    //     inp.nextLine();
    
    //     System.out.println("Enter Version:");
    //     int ver = inp.nextInt();
    //     inp.nextLine();
    
    //     System.out.println("Modification:");
    //     String mod = inp.nextLine();

    //     items.ReplaceVer(subject, ID, ver, mod);
    // }
    
    void Delete(Scanner inp){
        System.out.println("From which subject do you want to delete:");
        String subject = inp.nextLine();
    
        System.out.println("Id of the question:");
        int ID = inp.nextInt();
        inp.nextLine();
    
        System.out.println("Enter Version:");
        int ver = inp.nextInt();
        inp.nextLine();
    
        items.Delete(subject, ID, ver);
    }

    void Display(){
        //
    }
}

