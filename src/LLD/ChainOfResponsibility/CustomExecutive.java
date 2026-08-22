package LLD.ChainOfResponsibility;

public class CustomExecutive implements CustomerSupportHandler{

    private TechTeam techTeam;

    public CustomExecutive(TechTeam techTeam) {
        this.techTeam = techTeam;
    }

    @Override
    public void handleRequest(Issue issue) {
        if(issue.getPriority().equals("LEVEL2")){
            System.out.println("CustomExecutive resolved the issue");
            issue.setStatus("Success");
        }
        else {
            System.out.println("CustomerExecutive could not resolve issue. Moving to the next handler i.e TechTeam");
            issue.setStatus("Pending");
            techTeam.handleRequest(issue);
        }

    }
}
