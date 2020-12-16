
/**
 * Write a description of class Dinosaur here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Dinosaur
{
    // instance variables - replace the example below with your own
    private String type;
    private int age;
    private String gender;
    private int health; // range between 0 - 100

    /**
     * Default Constructor for objects of class Dinosaur
     */
    public Dinosaur()
    {
        // String type = "hello"; <-----local variables can have the same name
        // as instance variables
        this.type = "Dino";
        this.age = 0;
        // write code ethat will assign a gender to this dinosaur
        // 50% male and 50% female
        int randGend = (int)(Math.random()*2);
        if(randGend == 0)
            this.gender = "male";
        if(randGend == 1)
            this.gender = "female";
        
        this.health = 10;
        
    }
    
    /**
     * Explicit constructor for the Dino Clas
     */
    public Dinosaur(String t)
    {
        this.type = t;
        this.age = 0;
        int randGend = (int)(Math.random()*2);
        if(randGend == 0)
            this.gender = "male";
        if(randGend == 1)
            this.gender = "female";
        this.health = 10; 
        
    }
    
    /********** Getters **********/
    // Getters return the private instance data
    public String getType()
    {
        return this.type;
    }
    public int getAge()
    {
        return this.age;
    }
    public String getGender()
    {
        return this.gender;
    }
    public int getHealth()
    {
        return this.health;
    }
    
    /********** Setters **********/
    // Setters allow you to change the private instance data
    public void setType(String t)
    {
        this.type = t;
    }
    public void setAge(int a)
    {
        this.age = a;
    }
    public void setGender(String g)
    {
        this.gender = g;
    }
    public void setHealth(int h)
    {
        this.health = h;
    }
    
    public boolean equals(Dinosaur d)
    {
        // write code that will return true if two dinos are "equal"
        //return true if they're equal, false otherwise. 
        if(this.type.equals(d.getType()))
        {
                if(this.gender.equals(d.getGender()))
                {
                    return true;
                }
        }
        return false;
    }
    
    public void ageUp()
    {
        if(this.health > 0) // if the dino is alive
        {
            
            // if age is less than 10, health increases by ten.
            if(this.age > 30)
                this.health = this.health - 10;
                // no change to health if age is between 10 and 24
            
                // health decrease by 5 if age is between 25 and 30
                else if(this.age >= 25 && this.age <=30)
                {
                    this.health = this.health - 5;
                }
                // Health decreases by 10 if greater than 30
                else if(this.age < 10)
                    this.health = this.health + 10;
        }
    }
    
    public int ageUp(int a)
    {
        for(int i = 0; i < a; i++)
        {
            this.age++;
            this.ageUp();
        }
        return this.age;
    }
        
    
    /**
     * Return this.Dino as a string
     */
    public String toString()
    {
        String answer = this.type + " " + this.age + " " + this.gender + " " + this.health;
        return answer;
    }
}

