class QuestionFactory{

    static int ID = 1;

    QuestionFactory(){}

    Question Create(String subject, int type, String qStmt, String[] options){
        // Question q;

        // if(type == 1){
            Question q = new MCQ();
            q.initialize(subject, qStmt, ID);
            q.addOptions(options);
        // }

        ID++;

        return q;
    }

    Question Create(String subject, int type, String qStmt){
        // Question q;

        // if(type == 2){
            Question q = new Subjective();
            q.initialize(subject, qStmt, ID);
        // }

        ID++;

        return q;
    }

    Question NewVer(int ID, String subject, String qStmt, String[] options){
        Question q = new MCQ();
        q.addOptions(options);
        return q;
    }

    Question NewVer(int ID, String subject, String qStmt){
        Question q = new Subjective();
        return q;
    }
}
