import java.io.File;
import java.util.*;

public class Menu{
    
    Items items = new Items();
    QuestionFactory qf = new QuestionFactory();
    public static void main(String[] args) {
        File file = new File("Instructions.txt");
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

        // System.out.println("Enter ID:");
        // int ID = inp.nextInt();
        // inp.nextLine();
    
        // System.out.println("Enter Version:");
        // int ver = inp.nextInt();
        // inp.nextLine();
        
        System.out.println("Type of question\n  1 MCQ\t2 Subjective\n");
        int type = inp.nextInt();
        inp.nextLine();

        // while(true){
        //     System.out.println("1 To type down question\n2 To upload file\n");
        //     int flow = inp.nextInt();
        //     inp.nextLine();

        //     if(flow==1){
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

                    Question q = qf.Create(subject, type, qStmt, options);
            
                    items.Create(q);
                }
                else{
                    Question q = qf.Create(subject, type, qStmt);

                    items.Create(q);
                }
        //         break;
        //     }
        //     else if(flow==2){
        //         System.out.println("Enter the file path:");
        //         String path = inp.nextLine();
                    
        //         // Question q = new qf.Create(subject, type, qStmt);
        
        //         // items.ReadFile(q, path);
        //         break;
        //     }
        //     else{
        //         System.out.println("\nInvalid option. Please choose one of the below\n\n");
        //     }
        // }

    }
    
    void Modify(Scanner inp){

        // Display questions
        Display();

        System.out.println("Enter ID of question you want to edit:");
        int ID = inp.nextInt();
        inp.nextLine();

        String qStmt, subject="";
        String[] options = new String[4];
        String path;

        // check type of question
        int type = 1;

        System.out.println("Type your question below\n");
        qStmt = inp.nextLine();

        if(type==1){
            // mcq
            System.out.println("Enter option 1:");
            options[0] = inp.nextLine();

            System.out.println("Enter option 2:");
            options[1] = inp.nextLine();

            System.out.println("Enter option 3:");
            options[2] = inp.nextLine();

            System.out.println("Enter option 4:");
            options[3] = inp.nextLine();
        }
        else{
            // subjective
        }

        Question q;

        if(type==1){
            q = qf.NewVer(ID, subject, qStmt, options);
        }
        else{
            q = qf.NewVer(ID, subject, qStmt);
        }

        while(true){
            System.out.println("1 To create new version of question\n2 To replace last version");
            int flow = inp.nextInt();
            inp.nextLine();

            if(flow==1){
                items.Create(q);
                break;
            }
            else if(flow==2){
                System.out.println("Enter version: ");
                int ver = inp.nextInt();
                inp.nextLine();
                items.ReplaceVer(q, ver);
                break;
            }
            else{
                System.out.println("Invalid option. Please choose one of the below");
            }
        }

        // items.Modify(subject, ID, ver, mod);
    }
    
    void Delete(Scanner inp){
        items.Display();
    
        System.out.println("Id of the question: ");
        int ID = inp.nextInt();
        inp.nextLine();
    
        System.out.println("Enter Version: ");
        int ver = inp.nextInt();
        inp.nextLine();
    
        items.Delete(ID, ver);
    }

    void Display(){
        items.Display();
    }
}

