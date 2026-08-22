package LLD.ChainOfResponsibility;

public class Chatbot implements CustomerSupportHandler{

    private CustomExecutive customExecutive;

    public Chatbot(CustomExecutive customExecutive) {
        this.customExecutive = customExecutive;
    }

    @Override
    public void handleRequest(Issue issue) {
         if(issue.getPriority().equals("LEVEL1")){
System.out.println("Chatbot resolved the issue");
issue.setStatus("Success");
         }
         else{
             System.out.println("Chatbot could not resolve issue. Moving to the next handler i.e CustomerExecutive");
             issue.setStatus("Pending");
             customExecutive.handleRequest(issue);
         }
    }
}
