package containers;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;

public class ContainerSeller {
    public static void main(String[] args) {
        Runtime runtime=Runtime.instance();
        ProfileImpl profile=new ProfileImpl();
        profile.setParameter(ProfileImpl.MAIN_HOST,"localhost");
        AgentContainer agentContainer=runtime.createAgentContainer(profile);
        try {
            AgentController agentController=agentContainer.createNewAgent("seller",
                    "agents.AgentSeller",new Object[]{});
            agentController.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
