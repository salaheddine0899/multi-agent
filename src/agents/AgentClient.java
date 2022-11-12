package agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.lang.acl.ACLMessage;

public class AgentClient extends Agent {
    @Override
    protected void setup() {
        System.out.println("Hello, I am "+this.getAID());
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                try {
                    Thread.sleep(60*1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                ACLMessage message=new ACLMessage(ACLMessage.REQUEST);
                message.addReceiver(new AID("buyer",AID.ISLOCALNAME));
                message.setContent("I wanna a laptop!");
                send(message);
                System.out.println("message sent!!");
            }
        });
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage message=receive();
                if(message!=null){

                }
            }
        });
        //addBehaviour(parallelBehaviour);
        /*addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                ACLMessage message=new ACLMessage(ACLMessage.REQUEST);
                message.addReceiver(new AID("buyer",AID.ISLOCALNAME));
                message.setContent("I wanna a laptop!");
                send(message);
                System.out.println("message sent!!");
            }
        });*/
    }
}
