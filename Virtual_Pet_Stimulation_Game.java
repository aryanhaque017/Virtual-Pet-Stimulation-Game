import java.util.InputMismatchException;
import java.util.Scanner;

class Pet {     // creating the base class pet 
    private String name;    // Providing attributes of a pet
    private int age;
    private String color;
    private int happiness_Level;
    private int hunger_Level;

    private int dup_Happiness_Level;    // creating duplicate of happines and hunger level for check health method
    private int dup_Hunger_Level;
    
    private int times_Feeded;   // To track that how many time user had played and feeded his or her pet
    private int times_Played;

    Pet (String name, int age, String color, int happiness_Level, int hunger_Level, int times_Feeded, int times_Played) {   // Constructor for initializing the attributes of the pet
        this.name = name;
        this.age = age;
        this.color = color;
        this.happiness_Level = happiness_Level;
        this.hunger_Level = hunger_Level;

        dup_Happiness_Level = happiness_Level;
        dup_Hunger_Level = hunger_Level;
    }

    public String get_Name ()  {       // Providing getter methods to show the attributes of a pet
        return name;            
    }
    public int get_Age () {
        return age;
    }
    public String get_color () {
        return color;
    }
    public int get_Happiness_Level () {
        return happiness_Level;
    }
    public int get_Hunger_Level () {
        return hunger_Level;
    }
    public int get_Times_Feeded () {
        return times_Feeded;
    }
    public int get_Times_Played () {
        return times_Played;
    }
    public void set_Name (String new_Name) {        // Providing setter methods to change the attributes of a pet
        this.name = new_Name;
    }
    public void set_Age (int new_Age) {
        this.age = new_Age;
    }
    public void set_Color (String new_Color) {
        this.color = new_Color;
    }
    public void set_Hunger_Level (int inc_Or_Dec_Hunger_Level) {
        hunger_Level+=inc_Or_Dec_Hunger_Level;
    }
    public void set_Happiness_Level (int inc_Or_Dec_Happiness_Level) {
        happiness_Level+=inc_Or_Dec_Happiness_Level;
    }
    public void times_Feeded () {
        times_Feeded++;
    }
    public void times_Played () {
        times_Played++;
    }

     public void fed () {        // Providing methods for pets
         // eating capabilies changes according to different pets. It will be overridden  
    }
    public void play () {
         // playing capabilities change according to different pets. It will be overridden
    }
    public void sleep () {
        // animal type change according to user
    }
    public void makeSound() {
        // sound will change according to different pets. It will be overridden
    }
    public void pet_Description () {
        // description will change according to the features of animals
    }

    public void display_Status () {     // method for understanding the condition of pet 
       System.out.println("Hunger level: "+hunger_Level);
       System.out.println("Happiness level: "+happiness_Level);
    }
    public void check_Health () {       // method for understanding health and condition of pet 
        boolean happiness_Condition;
        boolean hunger_Condition;

        if (happiness_Level > (dup_Happiness_Level/2)) {
            System.out.println("Happiness level is good.");
            happiness_Condition = true;
        } else {
            System.out.println("Happines level is bad.");
            happiness_Condition = false;
        }
        if (hunger_Level > (dup_Hunger_Level/2)) {
            System.out.println("No hungryness.");
            hunger_Condition = true;
        } else {
            System.out.println("Your pet is hungry.");
            hunger_Condition = false;
        }

        if (happiness_Condition == true && hunger_Condition == false) {
            System.out.println("Your pet is happy.");
            System.out.println("Keep it up.");
            System.out.println("But your pet is hungry.");
            System.out.println("Recommendation: Feed your pet as quick and as much as you can.");
        } else if (happiness_Condition == false && hunger_Condition == true) {
            System.out.println("You pet is not hungry");
            System.out.println("Keep it up.");
            System.out.println("Your pet is unhappy.");
            System.out.println("Recommendatio: Feed and play with your pet as much as you can.");
        } else if (happiness_Condition == true && hunger_Condition == true) {
            System.out.println("Your pet condition is good.");
            System.out.println("Keep it up.");
            System.out.println("Take care of your pet.");
        } else {
            System.out.println("Your pet is in poor condition.");
            System.out.println("Recommendation: Play and Feed with your pet as much as you can.");
            System.out.println("Take care of your pet.");
        }
    }
    public void pet_Information () {    // Method for detailed information of pet
        // This method will be overridden
    }
}
class Dog extends Pet {     // Cerating dog sub-class
    String breed;
    Dog (String name, int age, String color, String breed) {     // providing the attributes of dog
        super (name, age, color, 50, 50, 0, 0);
        this.breed = breed;
    }
    public void fed () {              // overriding methods to implement according to features of dog
       super.set_Hunger_Level(-7);
       super.set_Happiness_Level(7);
       this.times_Feeded();
       System.out.println("Your pet has feeded successfully.");
       System.out.println("Current hunger level of your dog is: "+this.get_Hunger_Level());
       System.out.println("Current happiness level of your dog is: "+this.get_Happiness_Level());
    }
    public void play () {
        super.set_Hunger_Level(4);
        super.set_Happiness_Level(5);
        this.times_Played();
        System.out.println("You have done playing with your pet successfully.");
        System.out.println("Current hunger level of your dog is: "+this.get_Hunger_Level());
        System.out.println("Current happiness level of your dog is: "+this.get_Happiness_Level());
    }
    public void sleep () {
        System.out.println("Your pet dog "+super.get_Name()+" is sleeping");
    }
    public void makeSound () {
        System.out.println("Your pet dog "+this.get_Name()+" is barking.");
    }
    public void pet_Description () {        // Method for displaying unique features of Dog
        System.out.println("NOTE: The medium hunger level of Dog is 50 (all the calculations are done by base on it)");
        System.out.println("      The medium happiness level Dog is 50 (all the calculations are done by base on it)");
        System.out.println("      Per feeding hunger level decreased by 7");
        System.out.println("      Per feeding happiness level is increased by 7");
        System.out.println("      Per playing hunger level increased by 4");
        System.out.println("      Per playing happiness level is increased by 5");
    }
    public void pet_Infromation () {
        System.out.println("Detailed information about your pet:");
        System.out.println("    1. Name: "+get_Name());               // To test this line 
        System.out.println("    2. Age: "+get_Age());
        System.out.println("    3. Color: "+get_color());
        System.out.println("    4. Happiness Level: "+get_Happiness_Level());
        System.out.println("    5. Hunger Level: "+get_Hunger_Level());
        System.out.println("    6. Times feeded: "+get_Times_Feeded());
        System.out.println("    7. Times played: "+get_Times_Played());
    }
}
class Cat extends Pet {     // creating Cat sub-class
    double smelling_Distance_Power;
    Cat (String name, int age, String color, double smelling_Distance_Power) {   // providing attributes to cat
        super(name, age, color,40, 40, 0, 0);
        this.smelling_Distance_Power = smelling_Distance_Power;
    }
    public void fed () {              // overriding methods to implementation according to features of cats
        super.set_Hunger_Level(-4);
        super.set_Happiness_Level(4);
        this.times_Feeded();
        System.out.println("Your pet has feeded successfully.");
        System.out.println("Current hunger level of your cat is: "+this.get_Hunger_Level());
        System.out.println("Current happiness level of your cat is: "+this.get_Happiness_Level());
     }
     public void play () {
        super.set_Hunger_Level(3);
        super.set_Happiness_Level(3);
        this.times_Played();
        System.out.println("You have done playing with your pet successfully.");
        System.out.println("Current hunger level of your cat is: "+this.get_Hunger_Level());
        System.out.println("Current happiness level of your cat is: "+this.get_Happiness_Level());
     }
     public void sleep () {
         System.out.println("Your pet cat"+this.get_Name()+" is sleeping");
     }
     public void makeSound () {
         System.out.println("Your pet cat"+this.get_Name()+" is singing");
     }
     public void pet_Description () {           // Method for displaying unique features of Cat 
        System.out.println("NOTE: The medium hunger level of Cat is 40 (all the calculations are done by base on it)");
        System.out.println("      The medium happiness level Cat is 40 (all the calculations are done by base on it)");
        System.out.println("      Per feeding hunger level decreased by 4");
        System.out.println("      Per feeding happiness level is increased by 4");
        System.out.println("      Per playing hunger level increased by 3");
        System.out.println("      Per playing happiness level is increased by 3");
    }
    public void pet_Infromation () {
        System.out.println("Detailed information about your pet:");
        System.out.println("    1. Name: "+get_Name());
        System.out.println("    2. Age: "+get_Age());
        System.out.println("    3. Color: "+get_color());
        System.out.println("    4. Smelling distance power: "+smelling_Distance_Power);
        System.out.println("    5. Happiness Level: "+get_Happiness_Level());
        System.out.println("    6. Hunger Level: "+get_Hunger_Level());
        System.out.println("    7. Times feeded: "+get_Times_Feeded());
        System.out.println("    8. Times played: "+get_Times_Played());
    }
}
class Bird extends Pet {    // creating Bird sub class
    double wingspan;
    Bird (String name, int age, String color, double wingspan) {     // providing attributes to bird
        super(name, age, color,30, 30, 0, 0); 
        this.wingspan = wingspan;
    }
    public void fed () {              // overriding methods to implementation according to features of bird
        super.set_Hunger_Level(-4);
        super.set_Happiness_Level(3);
        this.times_Feeded();
        System.out.println("Your pet has feeded successfully.");
        System.out.println("Current hunger level of your bird is: "+this.get_Hunger_Level());
        System.out.println("Current happiness level of your bird is: "+this.get_Happiness_Level());
     }
     public void play () {
        super.set_Hunger_Level(3);
        super.set_Happiness_Level(4);
        this.times_Played();
        System.out.println("You have done playing with your pet successfully.");
        System.out.println("Current hunger level of your bird is: "+this.get_Hunger_Level());
        System.out.println("Current happiness level of your bird is: "+this.get_Happiness_Level());
     }
     public void sleep () {
         System.out.println("Your pet bird "+this.get_Name()+" is sleeping");
     }
     public void makeSound () {
        System.out.println("Your pet bird "+this.get_Name()+" is singing");
    }
    public void pet_Description () {        // Method for displaying unique features of Bird
        System.out.println("NOTE: The medium hunger level of Bird is 30 (all the calculations are done by base on it)");
        System.out.println("      The medium happiness level Bird is 30 (all the calculations are done by base on it)");
        System.out.println("      Per feeding hunger level decreased by 4");
        System.out.println("      Per feeding happiness level is increased by 3");
        System.out.println("      Per playing hunger level increased by 3");
        System.out.println("      Per playing happiness level is increased by 4");
    }
    public void pet_Infromation () {
        System.out.println("Detailed information about your pet:");
        System.out.println("    1. Name: "+get_Name());
        System.out.println("    2. Age: "+get_Age());
        System.out.println("    3. Color: "+get_color());
        System.out.println("    4. Wingspan: "+wingspan);
        System.out.println("    5. Happiness Level: "+get_Happiness_Level());
        System.out.println("    6. Hunger Level: "+get_Hunger_Level());
        System.out.println("    7. Times feeded: "+get_Times_Feeded());
        System.out.println("    8. Times played: "+get_Times_Played());
    }
}
public class Virtual_Pet_Stimulation_Game {

    Scanner var;        // Declearing scanner class variable var which will be accessed by all  methods of this class 

    private Pet dog;         // Creating class memeber objects for each type of animal (generic)
    private Pet cat;
    private Pet bird;
    
    public void user_Interface () {             // Introduction method  
        System.out.println("Welcome to our Virtual Pet Stimulation Game");
        System.out.println("Here, you can create your own multiple pet (one of each type) to play and look after them.\n");
        this.repeatable_Creating_Pet_Part();
    }
    public void repeatable_Creating_Pet_Part () {          // Showing the options for creating pet
        System.out.println("Catalogue:");                
        System.out.println("    1. If you want to create a dog then, 'CD'");
        System.out.println("    2. If you want to create a cat then, 'CC'");
        System.out.println("    3. If you want to create a bird then, 'CB'\n");
        this.pet_Creating_Backend();
    }
    public void pet_Creating_Backend () {   // For creating your pet
        System.out.println("Please enter your order:");

        var = new Scanner (System.in);          
        String user_word = var.next();
        var.nextLine();

        switch (user_word) {                                      
            case "CD":          // For Dog
                int dog_Age;
                System.out.println("Please enter the detail of your Dog:");                 
                System.out.println("Dog name:");
                String dog_Name = var.nextLine();
                System.out.println("Dog age:"); 
                try {
                    dog_Age = var.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Sorry, you can enter the dog age only in Positive Integer. Please re-enter your dog age again.");
                    var.nextLine();
                    dog_Age = var.nextInt();
                }
                var.nextLine();
                System.out.println("Dog color:");
                String dog_Color = var.nextLine();
                System.out.println("Dog breed:");
                String breed = var.nextLine();

                dog = new Dog (dog_Name, dog_Age, dog_Color, breed);    
                dog.pet_Description();
                System.out.println("\nYour pet dog "+dog_Name+" has successfully created.");

                this.catalgoue_List();
                break;
            case "CC":    // For Cat
                int cat_Age;
                double smelling_Distance_Power;
                System.out.println("Please enter the detail of your Cat:");
                System.out.println("Cat name:");    
                String cat_Name = var.nextLine();
                System.out.println("Cat age:"); 
                try {
                    cat_Age = var.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Sorry, you can enter the cat age only in Positive Integer. Please re-enter your cat age again.");
                    var.nextLine();
                    cat_Age = var.nextInt();
                }         
                System.out.println("Cat color:");
                var.nextLine();
                String cat_Color = var.nextLine();
                System.out.println("Smelling distance power of cat:");
                try {
                    smelling_Distance_Power = var.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Sorry, you can enter the cat smelling distance power only in Positive decimal number. Please re-enter your cat smelling distance power again.");
                    var.nextLine();
                    smelling_Distance_Power = var.nextDouble();
                }         
                cat = new Cat (cat_Name, cat_Age, cat_Color, smelling_Distance_Power);               
                cat.pet_Description();
                System.out.println("\nYour pet cat "+cat_Name+" has successfully created.");

                this.catalgoue_List();
                break;
            case "CB":  // For Bird
                int bird_Age;
                double wingspan;
                System.out.println("Please enter the detail of your Cat:");                 
                System.out.println("Bird name:");    
                String bird_Name = var.nextLine();
                System.out.println("Bird age:"); 
                try {
                    bird_Age = var.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Sorry, you can enter the bird age only in Positive Integer. Please re-enter your bird age again.");
                    var.nextLine();
                    bird_Age = var.nextInt();
                }         
                var.nextLine();
                System.out.println("Bird color:");
                String bird_Color = var.nextLine();
                System.out.println("Wingspan:");
                try {
                    wingspan = var.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Sorry, you can enter the bird wingspan only in Positive deciaml number. Please re-enter your bird wingspan again.");
                    var.nextLine();
                    wingspan = var.nextDouble();
                }         
                bird = new Bird (bird_Name, bird_Age, bird_Color, wingspan);    
                bird.pet_Description();
                System.out.println("\nYour pet bird "+bird_Name+" has successfully created.");

                this.catalgoue_List();
                break;
            default:
                System.out.println("Sorry, you are run out of options.");
                this.pet_Creating_Backend();
        }
    }
    public void catalgoue_List () {     // For showing the way to shift the catalogue 
        System.out.println("\nCatalogue:");
        System.out.println("    1. If you want to shift to Pet Settings then, 'SPT'");
        System.out.println("    2. If you want to shift to game catalgoue then, 'SGC'\n");
        this.shift_Catalogue_Backend();
    }
    public void shift_Catalogue_Backend () {        // Backend part for changing the catalogue
        System.out.println("Please enter the catalgoue to which you want to shift:");

        var = new Scanner (System.in);
        String user_Chosed_Catalogue = var.nextLine();

        if (user_Chosed_Catalogue.equals("SPT"))
        {
            this.pet_Settings_Frontend();
        } else {
            this.repeatable_Game_Catalogue_Part();
        }
    }
    public void repeatable_Game_Catalogue_Part_Backend (String user_Order,String user_Pet_Name) {
        switch (user_Order) {
            case "FYP":     // To fed your pet 
                switch (user_Pet_Name) {
                    case "Dog":
                        if (dog != null) {
                            dog.fed();
                            this.repeatable_Game_Catalogue_Part();  
                        }
                        break;
                    case "Cat":
                    if (cat != null) {
                        cat.fed();  
                        this.repeatable_Game_Catalogue_Part();  
                    }
                        break;
                    case "Bird":
                    if (bird != null) {
                        bird.fed();  
                        this.repeatable_Game_Catalogue_Part();  
                    }
                        break;
                    default:
                        System.out.println("Sorry, we don't provide any type of animal with this name.");
                        this.repeatable_Game_Catalogue_Part();  
                }
                break;
            case "PYP":     // To play with your pet 
                switch (user_Pet_Name) {
                    case "Dog":
                        if (dog != null) {
                            dog.play();  
                            this.repeatable_Game_Catalogue_Part();  
                        }
                        break;
                    case "Cat":
                        if (cat != null) {
                            cat.play();  
                            this.repeatable_Game_Catalogue_Part();  
                        } 
                        break;
                    case "Bird":
                    if (bird != null) {
                        bird.play();  
                        this.repeatable_Game_Catalogue_Part();  
                    }
                    break;
                    default:
                        System.out.println("Sorry, we don't provide any type of animal with this name.");
                        this.repeatable_Game_Catalogue_Part();  
                }
                break;
            case "SYP":     // To make your pet sleep
                switch (user_Pet_Name) {
                    case "Dog":
                        if (dog != null) {
                            dog.sleep(); 
                            this.repeatable_Game_Catalogue_Part();  
                        }
                        break;
                    case "Cat":
                        if (cat != null) {
                            cat.sleep();  
                            this.repeatable_Game_Catalogue_Part();  
                        } 
                        break;
                    case "Bird":
                    if (bird != null) {
                        bird.sleep();  
                        this.repeatable_Game_Catalogue_Part();  
                    }
                    break;
                    default:
                        System.out.println("Sorry, we don't provide any type of animal with this name.");
                        this.repeatable_Game_Catalogue_Part();  
                    }
                break;
            case "MSYP":        // To make your pet soudnd
                switch (user_Pet_Name) {
                    case "Dog":
                        if (dog != null) {
                            dog.makeSound();
                            this.repeatable_Game_Catalogue_Part();  
                        }
                        break;
                    case "Cat":
                        if (cat != null) {
                            cat.makeSound();  
                            this.repeatable_Game_Catalogue_Part();  
                        } 
                        break;
                    case "Bird":
                    if (bird != null) {
                        bird.makeSound();
                        this.repeatable_Game_Catalogue_Part();  
                    }
                    break;
                    default:
                    System.out.println("Sorry, we don't provide any type of animal with this name.");
                    this.repeatable_Game_Catalogue_Part();  
                }
                break;
            case "CSYP":    // To show the status of your pet 
                switch (user_Pet_Name) {
                    case "Dog":
                        if (dog != null) {
                            dog.display_Status();
                            this.repeatable_Game_Catalogue_Part();  
                        }
                        break;
                    case "Cat":
                        if (cat != null) {
                            cat.display_Status();
                            this.repeatable_Game_Catalogue_Part();  
                        } 
                        break;
                    case "Bird":
                        if (bird != null) {
                        bird.display_Status();
                        this.repeatable_Game_Catalogue_Part();  
                        }
                        break;
                    default:
                    System.out.println("Sorry, we don't provide any type of animal with this name.");
                    this.repeatable_Game_Catalogue_Part();  
                }
                break;
            case "CHYP":    // To see the health of your pet 
                switch (user_Pet_Name) {
                    case "Dog":
                        if (dog != null) {
                            dog.check_Health();
                            this.repeatable_Game_Catalogue_Part();  
                        }   
                        break;
                    case "Cat":
                        if (cat != null) {
                            cat.check_Health();
                            this.repeatable_Game_Catalogue_Part();  
                        } 
                        break;
                    case "Bird":
                    if (bird != null) {
                           bird.check_Health();
                           this.repeatable_Game_Catalogue_Part();  
                    }
                    break;
                    default:
                        System.out.println("Sorry, we don't provide any type of animal with this name.");
                        this.repeatable_Game_Catalogue_Part();  
                    }
                break;
            case "SPD":     // To see the details of your pet 
                switch (user_Pet_Name) {
                    case "Dog":
                        if (dog != null) {
                            dog.pet_Information();
                            this.repeatable_Game_Catalogue_Part();  
                        }
                        break;
                    case "Cat":
                        if (cat != null) {
                            cat.pet_Information();
                            this.repeatable_Game_Catalogue_Part();  
                        } 
                        break;
                    case "Bird":
                        if (bird != null) {
                            cat.pet_Information();
                            this.repeatable_Game_Catalogue_Part();  
                        }
                    break;
                    default:
                        System.out.println("Sorry, we don't provide any type of animal with this name.");
                        this.repeatable_Game_Catalogue_Part();  
                }   
                break;      
            case "SDEP":    // TO see the unique description of your pet 
                switch (user_Pet_Name) {
                    case "Dog":
                        dog.pet_Description();
                        this.repeatable_Game_Catalogue_Part();  
                        break;
                    case "Cat":
                        cat.pet_Description();
                        this.repeatable_Game_Catalogue_Part();  
                        break;
                    case "Bird":
                        bird.pet_Description();
                        this.repeatable_Game_Catalogue_Part();  
                        break;
                    default:
                    System.out.println("Sorry, we don't provide any type of animal with this name.");
                    this.repeatable_Game_Catalogue_Part();
                }
                break;
            case "SC":      // To shift catalogue or menue
                this.catalgoue_List();
                break;
            case "Q":
                System.out.println("Thank you for playing this game.");
                var.close();
                break;
            default:        // To repeat the game settings part if your ran our of options
                System.out.println("Sorry, you are run out of options.");
                this.repeatable_Game_Catalogue_Part();
        }
    }
    public void repeatable_Game_Catalogue_Part() {              // For game catalgoue     
        System.out.println("\nGame Catalogue:");          // Showing the game catalogue
        System.out.println("    1. If you want to fed your pet then, 'FYP'");
        System.out.println("    2. If you want to play with your pet then, 'PYP'");
        System.out.println("    3. If you want to make your pet to sleep then, 'SYP'");
        System.out.println("    4. If you want to make your pet to make sound then, 'MSYP'");
        System.out.println("    5. If you want to check status of your pet then, 'CSYP'.");
        System.out.println("    6. If you want to check health of your pet then, 'CHYP");
        System.out.println("    7. If you want to see the details of your pet then, 'SPD'");
        System.out.println("    8. If you want to see the description of each pet again then, 'SDEP'");
        System.out.println("    9. If you want to shift catalogue then, 'SC'");
        System.out.println("    10. To quit 'Q'\n");

        var = new Scanner (System.in);
        System.out.println("Please enter your order:");
        String user_Order = var.next();
        var.nextLine();

        System.out.println("Enter name of the animal (provide generic name):");
        String user_Pet_Name = var.next();

        switch (user_Pet_Name) {
            case "Dog":
                if (dog != null){
                    this.repeatable_Game_Catalogue_Part_Backend(user_Order, user_Pet_Name);
                } else {
                    System.out.println("Sorry, you don't have created any pet with this name.");
                    this.repeatable_Creating_Pet_Part();
                }
                break;
            case "Cat" :
                if (cat != null){
                    this.repeatable_Game_Catalogue_Part_Backend(user_Order, user_Pet_Name);
                } else {
                    System.out.println("Sorry, you don't have created any pet with this name.");
                    this.repeatable_Creating_Pet_Part();
                }
                break;
            case "Bird":
                if (bird != null) {
                    this.repeatable_Game_Catalogue_Part_Backend(user_Order, user_Pet_Name);;
                } else {
                    System.out.println("Sorry, you don't have created any pet with this name.");
                    this.repeatable_Creating_Pet_Part();
                }
                break;
            default:
                System.out.println("Sorry, you are run out of options.");
        }

    }
    public void pet_Settings_Backend (String user_Order, String user_Pet_Name) {
        switch (user_Order) {
            case "CNYP":        // To change the name of the pet 
                switch (user_Pet_Name) {
                    case "Dog":
                        if (dog != null) {
                            System.out.println("Enter the new name of your dog");
                            String new_Dog_Pet_Name = var.nextLine();
                            dog.set_Name(new_Dog_Pet_Name); 
                            this.pet_Settings_Frontend();
                        }
                        break;
                    case "Cat":
                        if (cat != null) {
                            System.out.println("Enter the new name of your cat:");
                            String new_Cat_Pet_Name = var.nextLine();
                            cat.set_Name(new_Cat_Pet_Name); 
                            this.pet_Settings_Frontend();
                        }
                        break;
                    case "Bird":
                        if (bird != null) {
                            System.out.println("Enter the new name of your bird:");
                            String new_Bird_Pet_Name = var.nextLine();
                            bird.set_Name(new_Bird_Pet_Name); 
                            this.pet_Settings_Frontend();
                        }
                        break;
                    default:
                        System.out.println("Sorry, we don't provide any type of animal with this name.");
                        this.pet_Settings_Frontend();
                }
                break;
            case "CAYP":        // To change the age of the pet 
                switch (user_Pet_Name) {
                    case "Dog":
                        int new_Dog_Age;
                        if (dog != null) {
                            System.out.println("Enter your new age of your dog");
                            try {
                                new_Dog_Age = var.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Sorry, you can enter the dog age only in Positive Integer. Please re-enter your dog age again.");
                                var.nextLine();
                                new_Dog_Age = var.nextInt();
                            }
                            dog.set_Age(new_Dog_Age);   
                            this.pet_Settings_Frontend();
                        }
                        break;
                    case "Cat":
                        if (cat != null) {
                            int new_Cat_Age;
                            System.out.println("Enter  the new age of your cat:");
                            try {
                                new_Cat_Age = var.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Sorry, you can enter the cat age only in Positive Integer. Please re-enter your cat age again.");
                                var.nextLine();
                                new_Cat_Age = var.nextInt();
                            }         
                            cat.set_Age(new_Cat_Age);   
                            this.pet_Settings_Frontend();
                        } 
                        break;
                    case "Bird":
                        int new_Bird_Age;
                        if (bird != null) {
                            System.out.println("Enter your new age of your bird:");
                            try {
                                new_Bird_Age = var.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Sorry, you can enter the bird age only in Positive Integer. Please re-enter your bird age again.");
                                var.nextLine();
                                new_Bird_Age = var.nextInt();
                            }         
                            bird.set_Age(new_Bird_Age);   
                            this.pet_Settings_Frontend();
                    }
                    break;
                    default:
                        System.out.println("Sorry, we don't provide any type of animal with this name.");
                        this.pet_Settings_Frontend();
                }
                break;
            case "CCYP":        // To change the color of the pet 
                switch (user_Pet_Name) {
                    case "Dog":
                        if (dog != null) {
                            System.out.println("Enter your new color of your dog:");
                            String new_Dog_Color = var.nextLine();
                            dog.set_Color(new_Dog_Color);
                            this.pet_Settings_Frontend();
                        }
                        break;
                    case "Cat":
                        if (cat != null) {
                            System.out.println("Enter your new color of your cat:");
                            String new_Cat_Color = var.nextLine();
                            cat.set_Color(new_Cat_Color);
                            this.pet_Settings_Frontend();
                        } 
                        break;
                    case "Bird":
                        if (bird != null) {
                            System.out.println("Enter your new color of your bird:");
                            String new_Bird_Color = var.nextLine();
                            bird.set_Color(new_Bird_Color);
                            this.pet_Settings_Frontend();
                        }
                    break;
                    default:
                        System.out.println("Sorry, we don't provide any type of animal with this name.");
                        this.pet_Settings_Frontend();
                    }
                break;
            case "CNP":         // To create a new pet (of different type)
                this.repeatable_Creating_Pet_Part();
                break;
            case "SC":      // To shif  catalogue or menue
                this.catalgoue_List();
                break;
            case "Q":
                System.out.println("Thank you for playing this game.");
                var.close();
                break;
            default:    // To repeat the pet settings part if your ran our of options
                System.out.println("Sorry, you are run out of options.");
                this.pet_Settings_Frontend();
        }
    }
    public void pet_Settings_Frontend () {                  // To chgange pet settings  
        System.out.println("Your pet settings:");       // Showing the command to change the description of your pet
        System.out.println("    1. If you want to change the name of your pet then, 'CNYP'");
        System.out.println("    2. If you want to change the age of your pet then, 'CAYP'");
        System.out.println("    3. If you want to change the color of your pet then, CCYP'");
        System.out.println("    4. If you want to create a new pet (of different type) then, 'CNP'");      
        System.out.println("    5. If you want to shift catalogue then, 'SC'");
        System.out.println("    6. To quit 'Q'\n");

        Scanner var = new Scanner (System.in);
        System.out.println("Please enter your order:");
        String user_Order = var.next();
        var.nextLine();

        System.out.println("Enter name of the animal (provide generic name & it should be prepared in advance, earlier) with to change the description of your pet:");
        String user_Pet_Name = var.nextLine();
        switch (user_Pet_Name) {
            case "Dog":
                if (dog != null){
                    this.pet_Settings_Backend(user_Order, user_Pet_Name);
                } else {
                    System.out.println("Sorry, you don't have created any pet with this name.");
                    this.pet_Settings_Frontend();
                }
                break;
            case "Cat" :
                if (cat != null){
                    this.pet_Settings_Backend(user_Order, user_Pet_Name);
                } else {
                    System.out.println("Sorry, you don't have created any pet with this name.");
                    this.pet_Settings_Frontend();
                }
                break;
            case "Bird":
                if (bird != null) {
                    this.pet_Settings_Backend(user_Order, user_Pet_Name);
                } else {
                    System.out.println("Sorry, you don't have created any pet with this name.");
                    this.pet_Settings_Frontend();
                }
                break;
            default:
                System.out.println("Sorry, you are run out of options.");
        }
    }
    public static void main(String[] args) {        

        Virtual_Pet_Stimulation_Game vpsg = new Virtual_Pet_Stimulation_Game();
        vpsg.user_Interface();      // Invoking user interface to execute the whole programme 
        }
}