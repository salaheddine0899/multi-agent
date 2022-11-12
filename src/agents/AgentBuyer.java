package agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class AgentBuyer extends Agent {
    @Override
    protected void setup() {
        this.addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                addBehaviour(new CyclicBehaviour() {
                    @Override
                    public void action() {
                        ACLMessage message=receive();
                        if(message!=null){
                            switch (message.getPerformative()){
                                case ACLMessage.REQUEST :
                                    ACLMessage replay=message.createReply();
                                    message.setContent("252");
                                    send(replay);
                                    ACLMessage cfp=new ACLMessage(ACLMessage.CFP);
                                    cfp.addReceiver(new AID("seller",AID.ISLOCALNAME));
                                    cfp.setContent("Do you have a laptop?");
                                    send(cfp);
                                    break;
                                case ACLMessage.PROPOSE:
                                    System.out.println(message.getContent());
                                    ACLMessage acceptProposal=new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
                                    acceptProposal.addReceiver(new AID("seller",AID.ISLOCALNAME));
                                    acceptProposal.setContent("accepted!");
                                    send(acceptProposal);
                                    break;
                                case ACLMessage.CONFIRM:
                                    System.out.println(message.getContent());
                                    ACLMessage inform=new ACLMessage(ACLMessage.INFORM);
                                    inform.addReceiver(new AID("client",AID.ISLOCALNAME));
                                    inform.setContent("yes there is");
                                    send(inform);
                                    break;
                            }
                        }

                    }
                });
            }
        });
    }
}
