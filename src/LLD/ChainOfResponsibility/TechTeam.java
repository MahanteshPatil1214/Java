package LLD.ChainOfResponsibility;

public class TechTeam implements CustomerSupportHandler{
    @Override
    public void handleRequest(Issue issue) {
        if(issue.getPriority().equals("LEVEL3")){
            System.out.println("TechTeam resolved the issue");
            issue.setStatus("Success");
        }else {
            System.out.println("Issue cannot resolved");
            issue.setStatus("Failed");
        }
    }
}
