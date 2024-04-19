//import java.util.Scanner;
import java.util.ArrayList; // import the ArrayList class
import java.util.Random;


/**
 * class Garden implements methods from the interface Contract
 */
public class Garden implements Contract {
      ArrayList<String> wickerBasket; // wicker basket to hold items
      String item; // items - can be stored, dropped, examined, used
      String direction; // four directions - forward, left, right, and backward
      int numFlowers; // number of flowers in the garden
      int numWeeds; // nuumber of weeds in the garden
      String gardenName; // name of garden
      String gardener; // name of the gardener
      int x; // x coordinate for flying coordinates
      int y; // y coordinate for flying coordinates
      int lengthMeters; // length of the garden in meters
      int widthMeters; // width of the garden in meters

      /**
       * Constructor for Garden 
       * @param gardenName the name of the garden
       * @param gardener the name of the gardener
       * @param numFlowers the number of flowers in the garden
       * @param numWeeds the number of weeds in the garden
       * @param lengthMeters sets the length of the garden in meters
       * @param widthMeters sets the width of the garden in meters
       */
      public Garden (String gardenName, String gardener, int numFlowers, int numWeeds, int lengthMeters, int widthMeters){
            this.gardenName = gardenName;
            this.gardener = gardener;
            this.numFlowers = numFlowers;
            this.numWeeds = numWeeds;
            this.wickerBasket = new ArrayList <>();
            this.lengthMeters = lengthMeters;
            this.widthMeters = widthMeters;
      }
      /**
       * Grabs item and adds it to the wicker basket
       * @param item the item grabbed
       */
      public void grab(String item){
            wickerBasket.add(item);
            System.out.println("The following has/have been added to the wicker basket: " + item);
      }
      /** Drops item and removes it from the wicker basket 
       * @param item the item dropped 
       * @return string statement about whether or not the item has been removed or if it can't be removed because it's not in the basket
       */
      public String drop(String item){
            if (!wickerBasket.contains(item)){
                  return ("This item isn't in the wicker basket, so you can't get rid of it. Try something else!");
            } else {
                  wickerBasket.remove(item);
                  return ("The following has/have been removed from the wicker basket: " + item);
            }
      }
      /**
       * Examines item and throw out a random phrase about the item being examined
       * @param item the item examined
       */
      public void examine(String item){
            System.out.println("Examining " + item + "... looking close... hmm...");
            String [] canned = {"Interesting.", "Pretty.", "Put that down!", "EWW.", "Cool!"};
            Random rnd = new Random();
            String output = canned[rnd.nextInt(5)];
            System.out.println(output); 
      }
      /** Uses one of the following items: watering can, shovel, or gardening sheers and prints out a corresponding statement
       * @param item the item used
       */
      public void use(String item){
            if (item.equalsIgnoreCase("watering can")){
                  System.out.println("Now watering the plants!");
            }
            else if (item.equalsIgnoreCase("shovel")){
                  String [] veg = {"carrot", "potato", "radish"};
                  Random rnd = new Random();
                  String rndVeg = veg[rnd.nextInt(3)];
                  System.out.println("You digged up a " + rndVeg + "...");
            }
            else if (item.equalsIgnoreCase("gardening sheers")){
                  String [] flowers = {"hydrangeas", "sunflowers", "roses", "peonies"};
                  Random rnd = new Random();
                  String rndFlowers = flowers[rnd.nextInt(4)];
                  System.out.println("You cut up some " + rndFlowers + "!");
            }
            else {
                  System.out.println("Sorry that's not an option. Please try using another tool!");
            }
      }
      /**
       * Gardener walks in an inputed direction. The goal is to be near the garden. 
       * @param direction the garderner walks in
       * @returns True if the gardener is in front of the garden, else False if not
       */
      public boolean walk (String direction){
            if (direction.equalsIgnoreCase("forward") || direction.equalsIgnoreCase("right") || direction.equalsIgnoreCase("left")){
                  System.out.println("You're right in front of the garden!");
                  return true;
            }
            else {
                  System.out.println("Sorry, you're not close to the garden. Try again!");
                  return false;
            }
      }
      /**
       * Gardener flys over garden. The coordinates must be within the set length/width meter bounds for them to be flying over the garden.
       * @param x coordinate of flying 
       * @param y coordinate of flying 
       * @return True if the gardener is flying over the garden, else returns False
       */
      public boolean fly(int x, int y){
            if (x > 0 && y > 0){
                  if (x<this.lengthMeters && y<this.widthMeters){
                        System.out.println("You're flying over the garden!");
                        return true;
                  } else {
                        System.out.println("You're not flying above the garden... Check your coordinates.");
                        return false;
                  }
            } else {
                  System.out.println("Please enter appropriate coordinates.");
                  return false;
            }
      }
      /**
       * Shrinks the number of weeds in the garden or removes them completely.
       */
      public Number shrink(){
            if (this.numWeeds > 0){
                  int pullWeeds = this.numWeeds - 500;
                  if (pullWeeds < 0) {
                        return 0;
                  } else {
                        return pullWeeds;
                  }
            }
            else {
                  return 0;
            }
      }
      /**
       * Grows the number of flowers in the garden. Adds 100 more flowers.
       */
      public Number grow(){ 
            return this.numFlowers + 100;
      }
      /**
       * Prints that the gardener is resting against a tree.
       */
      public void rest(){
            System.out.println(this.gardener + " is now resting against a tree!");
      }
      /**
       * Resets the number of flower to 1 and number of weeds to 100. Garden is #destroyed.
       */
      public void undo(){
            this.numFlowers = 1;
            this.numWeeds = 1000;
            System.out.println("The next day... \nOh no! A bad storm and some wicked bad luck has ruined " + this.gardenName + " :(");
            System.out.println("Number of flowers: " + this.numFlowers + "\nNumber of weeds: " + this.numWeeds);

      }
      public static void main(String[] args) {
            Garden myGarden = new Garden("The Wonderful Garden", "Abril", 2000, 800, 20, 10);
            myGarden.grab("Roses");
            myGarden.grab("Hat");
            System.out.println(myGarden.drop("Roses"));
            System.out.println(myGarden.drop("Sunglasses"));
            myGarden.examine("carrot");
            myGarden.use("gardening sheers");
            myGarden.use("Shovel");
            myGarden.walk("right");
            myGarden.fly(18, 20);
            myGarden.fly(18, 8);
            System.out.println("Number of flowers: " + myGarden.grow());
            System.out.println("Number of weeds: " + myGarden.shrink());
            myGarden.rest();
            myGarden.undo();
      }
}