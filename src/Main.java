import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;

public class Main {
    public static void main(String[] args) {

        Runtime runtime=Runtime.instance();
        ProfileImpl profileImpl=new ProfileImpl();
        profileImpl.setParameter(ProfileImpl.GUI,"true");
        AgentContainer mainContainer=  runtime.createMainContainer(profileImpl);
        try {
            mainContainer.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}