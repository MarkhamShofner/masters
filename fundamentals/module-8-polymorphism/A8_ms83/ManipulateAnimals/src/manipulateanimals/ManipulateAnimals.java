/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipulateanimals;

/**
 *
 * @author mark8604
 * Java application that will serve as an educational tool
to help children learn about various concepts such as vehicles, animals, sounds, etc.
 */
public class ManipulateAnimals {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ManipulateAnimals animalz = new ManipulateAnimals();
        animalz.init();
    }

    public void init() {
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        Vehicle vehicle1 = new Vehicle();
        Vehicle vehicle2 = new Vehicle();

        Animal aCollection[] = new Animal[2];
        aCollection[0] = animal1;
        aCollection[1] = animal2;

        Vehicle vCollection[] = new Vehicle[2];
        vCollection[0] = vehicle1;
        vCollection[1] = vehicle2;

        for (int i = 0; i < aCollection.length; i++) {
            aCollection[i].drawObject();
            aCollection[i].rotateObject();
            aCollection[i].resizeObject();
            aCollection[i].playSound();
        }

        for (int i = 0; i < vCollection.length; i++) {
            vCollection[i].drawObject();
            vCollection[i].rotateObject();
            vCollection[i].resizeObject();
            vCollection[i].playSound();
        }
    }

    class Animal implements Drawable, Rotatable, Resizable, Sounds {
        private String name;

        // non-interface methods
        public String getName() {
            return name;
        }
        public void setName(String n) {
            name = n;
        }

        // interface overrides
        public void drawObject() {
            System.out.println("Drawing an Animal");
        }
        public void rotateObject() {
            System.out.println("Rotating an Animal");
        }
        public void resizeObject() {
            System.out.println("Resizing an Animal");
        }
        public void playSound() {
            System.out.println("Animal Sound");
        }
    }

    class Vehicle implements Drawable, Rotatable, Resizable, Sounds {
        private String name;
        private int age;

        // non-interface methods
        public String getName() {
            return name;
        }
        public void setName(String n) {
            name = n;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int i) {
            age = i;
        }

        // interface overrides
        public void drawObject() {
            System.out.println("Drawing a Vehicle");
        }
        public void rotateObject() {
            System.out.println("Rotating a Vehicle");
        }
        public void resizeObject() {
            System.out.println("Resizing a Vehicle");
        }
        public void playSound() {
            System.out.println("Vehicle Sound");
        }
    }

    // draw objects (animals, vehicles, etc...)
    public interface Drawable {
        void drawObject();
    }

    // rotate objects
    public interface Rotatable {
        void rotateObject();
    }

    // resize objects
    public interface Resizable {
        void resizeObject();
    }

    // play sounds associated with objects
    public interface Sounds {
        void playSound();
    }
}
