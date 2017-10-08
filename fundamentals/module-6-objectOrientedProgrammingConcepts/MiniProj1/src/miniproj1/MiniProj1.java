/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproj1;

/**
 *
 * @author mark8604
 */
public class MiniProj1 {
    /**
     * A day at the racetrack with a Tortoise and a Hare!
     */
    // Initiate an instance of the project. Run the raceController function
    public static void main( String [] args )
    {        
        MiniProj1 miniProj1 = new MiniProj1();
        miniProj1.raceController();
    }

    // Overall controller of the race (initiates the constestants, the track, and manages the state of the race)
    public void raceController() {
        Tortoise larry = new Tortoise();
        Hare chancey = new Hare();
        Track raceTrack = new Track();
        int larryPosition = 1;
        int chanceyPosition = 1;
        String[] tracker = raceTrack.tracker(larryPosition, chanceyPosition);
        System.out.println("AND THEY'RE OFF!!");
        
        while (raceTrack.racing) {
            larryPosition = raceTrack.position(larryPosition, larry.takeTurn(randomInt()));
            chanceyPosition = raceTrack.position(chanceyPosition, chancey.takeTurn(randomInt()));            
            tracker = raceTrack.tracker(larryPosition, chanceyPosition);
            raceTrack.display(tracker);
            System.out.println("\n --------------------------------------------------");
        }
        System.out.println(raceTrack.endStatus);
    }
    
    // [race]Track class that keeps track of - if the race is still going, the end condition, and the position of the raceers
    // can also display the current state of the Track
    class Track {
        boolean racing = true;
        String endStatus = "";
        
        int position (int pos, int move) {
            pos = pos + move;
            if (pos < 1) pos = 1; // can’t slip any further left than position 1
            return pos;
        }
        
        void display (String[] tracker) {
            for (String tracker1 : tracker) {
                if (tracker1 != null) {
                    System.out.print(tracker1);
                } else {
                    System.out.print(" ");
                }
            }
        }
        
        String[] tracker (int tortoise, int hare) {
            String[] tracker = new String[75];
            if (tortoise == hare) {
                tracker[tortoise] = "OUCH!";
            } else {
                tracker[tortoise] = "T";
                tracker[hare] = "H";
            }
            if (tortoise > 49 || hare > 49) {
                racing = false;
                if (tortoise > 49 && hare > 49) {
                    endStatus = "IT'S A TIE!!";
                } else if (tortoise > 49) {
                    endStatus = "TORTOISE WINS!!";
                } else if (hare > 49) {
                    endStatus = "HARE WINS!!";
                }
            } 
            return tracker;
        }
    }

    // Tortoise class that offers moves based on designated outcomes
    class Tortoise {
        int takeTurn (int i) {
            int move;
            switch (i) {
                case 1: case 2: case 3: case 4: case 5:
                    move = 3;
                    break;
                case 6: case 7: case 8:
                    move = 1;
                    break;
                case 9: case 10:
                    move = -6;
                    break;
                default:
                    move = 0;
            }
            return move;
        }
    }

    // Hare class that offers moves based on designated outcomes
    class Hare {
        int takeTurn (int i) {
            int move;
            switch (i) {
                case 1: case 2:
                    move = 9;
                    break;
                case 3: case 4: case 5:
                    move = 1;
                    break;
                case 6:
                    move = -12;
                case 7: case 8:
                    move = -2;
                    break;
                case 9: case 10:
                    move = 0; // TODO handle the sleeping (assign a # outside the possible range)
                    break;
                default:
                    move = 0;
            }
            return move;
        }
    }

    // returns a random integer 1 through 10
    public static int randomInt() {
        int maximum = 10;
        int minimum = 1;
        return (minimum + (int)(Math.random() * ((maximum - minimum) + 1)));
    }
}
