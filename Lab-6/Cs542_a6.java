
package cs542_a6;

/**
 *
 * @author Jack and Duran
 */
public class Cs542_a6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String agency = "FBI";
        ObjectPool server;
        
        if(agency.equals("FBI")){
            server = ObjectPool.getPoolInstance(new FBI_Agent_Creator(), 5);
            for(int i = 0; i < 10; i++){
                TaskRequester tr = new TaskRequester(server, i);
                Thread t = new Thread(tr, "Requester " + i);
                t.start();
            }
            
        }
        else if(agency.equals("CIA")){
            server = ObjectPool.getPoolInstance(new CIA_Agent_Creator(), 5);
            for(int i = 0; i < 10; i++){
                TaskRequester tr = new TaskRequester(server, i);
                Thread t = new Thread(tr, "Requester " + i);
                t.start();
            }
            
        }
        
    }
    
}
