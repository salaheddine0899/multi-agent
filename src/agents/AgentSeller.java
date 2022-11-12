package agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;

public class AgentSeller extends Agent {
    @Override
    protected void setup() {
        System.out.println("this is "+getAID());
        /*ServiceDescription serviceDescription=new ServiceDescription();
        serviceDescription.setType("Buy a laptop");
        serviceDescription.setName("Jade-commerce");*/
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage message=receive();
                if(message!=null)
                    switch (message.getPerformative()){
                        case ACLMessage.CFP :
                            System.out.println(message.getContent());
                            ACLMessage propose=new ACLMessage(ACLMessage.PROPOSE);
                            propose.addReceiver(new AID("buyer",AID.ISLOCALNAME));
                            propose.setContent("334");
                            send(propose);
                            break;
                        case ACLMessage.ACCEPT_PROPOSAL:
                            System.out.println(message.getContent());
                            ACLMessage confirm=new ACLMessage(ACLMessage.CONFIRM);
                            confirm.addReceiver(new AID("buyer",AID.ISLOCALNAME));
                            confirm.setContent("it is okay!");
                            send(confirm);
                            break;
                    }
            }
        });
    }
}
