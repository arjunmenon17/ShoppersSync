//Author: Zachary M. Solomon
//Date Started: May 22, 2020
//Purpose: To randomly generate different types of environments such as deserts, forests, wetlands etc., which require varying types of traits among the organisms in the
//environment for their success. The environments created should also be able to change over time to reflect environmental changes that occur in nature and the adaptations
//or extinctions that organisms may experience in nature.
//Most Recent Modification: May 31, 2020
public class FSTEnvironment {
    private int terreOuEau; //To determine whether the environment is aquatic or terrestrial.
    private int enviroChange; // Determines if there will be an environmental condition shift after each generation occurs.
    private int climate; //To determine the average daily temperature (Can change every 6 months).
    private int terrain1;// Determines terrain on a scale of 0-5 based on how "soft" or "harsh" the environment is, i.e. a soft grassy meadow or or a woodland forest might
    // score a 0 but the Grand Canyon or the cliffs of Dover might score a 5.
    private int terrain2;//Determines terrain on a scale of 0-5 based on how structurally diverse the environment is, i.e. the african savannah or the antarctic might score
    //0, while the Brazilian rain forest or a coral reef might score a 5.
    private int foodAbundanceInOrganic;//Will determine how the amount of inorganic food is available to primary producers on a scale of 1-10.
    private int inorganicResourceAbundance;//Will determine the amount of inorganic resources are available in the environment for the organisms on a scale of 1-10.

    public FSTEnvironment(){
        //These are being given dummy values as they will have randomly generated values later.
        this.terreOuEau=3;
        this.enviroChange=3;
        this.climate=60;
        this.terrain1=6;
        this.terrain2=7;
        this.foodAbundanceInOrganic=11;
        this.inorganicResourceAbundance=11;
    }
    //Gives values for terreOuEau and Envirochange.
    public FSTEnvironment(int terreOuEau, int climate, int terrain1, int terrain2, int enviroChange, int foodAbundanceInOrganic, int inorganicResourceAbundance)throws Exception{
        setTerreOuEau(terreOuEau);
        setEnviroChange(enviroChange);
        setClimate();
        setTerrain1();
        setTerrain2();
        setFoodAbundanceInOrganic();
        setInorganicResourceAbundance();
    }
    public FSTEnvironment(int terreOuEau, int enviroChange)throws Exception{
        setTerreOuEau(terreOuEau);
        setEnviroChange(enviroChange);
        setClimate();
        setTerrain1();
        setTerrain2();
        setFoodAbundanceInOrganic();
        setInorganicResourceAbundance();
    }

    //Start of setTerreOuEau.
    //When called upon, it will randomly generate a number, either 0 or 1, to determine whether the environment will be terrestrial or aquatic, which may influence which
    //traits are favourable for organisms to thrive and reproduce. If the number generated is 1 then the environment will be terrestrial and if the number generated is 0
    //then it will be aquatic and text will be printed to indicate that.
    public void setTerreOuEau(int terreOuEau)throws Exception{
        for (int i = 0; i < 2; i++) {
            int min = 0;
            int max = 1;
            terreOuEau = (int) (Math.random() * ((max - min) + 1)) + min;
            System.out.println("val is:"+terreOuEau);
            if (terreOuEau==1){
                System.out.println("The environment where life and its further evolution will begin is terrestrial.");
            } else {
                System.out.println("The environment where life and its further evolution will begin is aquatic.");
            }
            System.exit(0);
        }
    }//End of setTerreOuEau.

    //Start of setEnviroChange
    //Calls on FstTime, using its getTimePeriod method to determine when to see if there should be any environmental change. When the generation changes, as indicated by
    //getTimePeriod, setEnviroChange randomly generates a number, either 1 or 0, to determine if there should be environmental changes. If the number generated is 0 there
    //will be no change, if the number generated is 1 there will be environmental changes, to be carried out by the method's calling on the setClimate, setTerrain1 and
    //setTerrain2 methods to cause them to run again, replacing the previous values for those methods with new randomly generated ones.
    public void setEnviroChange(int enviroChange)throws Exception{
        FstTime x = new FstTime();
            long gtpx = x.getTimePeriod();
        do {
            if (gtpx==x.getTimePeriod()){} else{
                gtpx=x.getTimePeriod();
                    int min = 0;
                    int max = 1;
                    enviroChange = (int) (Math.random() * ((max - min) + 1)) + min;
                    System.out.println("val is:" + enviroChange);
                    if (enviroChange == 0) {
                        System.out.println("There was no shift in the environmental conditions between this generation and the last.");
                    } else {
                        System.out.println("There were extreme climactic or geologic events that occurred between this generation and the last, causing change to the environmental conditions.");
                        //This is to randomly generate a number indicating how many environmental factors should be allowed to change at a given time. 1 means one factor
                        //can change while 5 means that all 5 factors (indicated below) will be allowed to change
                        int howManyChanges=97;//Giving dummy value to initialize the variable.
                        for (int i = 0; i < 1; i++) {
                            int minimum = 1;
                            int maximum = 5;
                            howManyChanges = (int) (Math.random() * ((maximum - minimum) + 1)) + minimum;
                            System.out.println("number of environmental factors that may change are :"+howManyChanges);
                        }
                        if (howManyChanges==5){//If all 5 environmental factors are allowed to change then they will all automatically be called
                            setClimate();
                            setTerrain1();
                            setTerrain2();
                            setFoodAbundanceInOrganic();
                            setInorganicResourceAbundance();
                        }
                        //Trues act like part of a switch to regulate which numbers can and can't be generated in a given generation. This is intended to stop multiple
                        //values being generated for a particular method, ensuring that there are effectively no repeatedly generated numbers, as if a number is generated
                        //once in a generation, it triggers the false part of the  code below and can't be used again in the same generation, forcing the code to generate
                        //and use a new number previously unused in that particular generation. Each method below is associated with a number indicating their position i.e.
                        //setClimate is associated with the number 1, which is also its position. While the "switch" is still on (true) the code can run the number a
                        //particular method is associated with, but once that number is run, it triggers the false section of the code at the bottom (relevant code indicated
                        //by a * in the comments) and as such may no longer be run again in that generation.

                        //This allows for the randomization of which changeable environmental conditions (methods below) will have their values altered and how many of them
                        //can have their values altered during the generations when the values are allowed to change. This will better emulate nature's random changes,
                        //rather than forcing all environmental factors (methods below) to change if enviroChange=1.

                        boolean [] noRepPerGen =new boolean [] {true,true,true,true,true,true};
                        for (int i = 0; i < howManyChanges & howManyChanges!=5; i++) {
                            int mi = 1;
                            int ma = 5;
                            int whoChanges =89;//Dummy value to initialize the variable.
                            whoChanges = (int) (Math.random() * ((ma - mi) + 1)) + mi;
                            System.out.println("val is:"+whoChanges);
                            if (whoChanges==1 & noRepPerGen [1]){
                                setClimate();
                            } else if (whoChanges==2 & noRepPerGen [2]){
                                setTerrain1();
                            }else if (whoChanges==3 & noRepPerGen [3]){
                                setTerrain2();
                            }else if (whoChanges==4 & noRepPerGen [4]){
                                setFoodAbundanceInOrganic();
                            }else if(whoChanges==5 & noRepPerGen [5]){
                                setInorganicResourceAbundance();
                            }else {
                                i--;
                            }noRepPerGen[whoChanges] = false;//*Triggers like the second part of my "switch" after a number is generated once in a generation to ensure it
                            //can't be used again in the same generation.
                        }
                    }
                    //System.exit(0); causes this to only run once, if commented out it runs continuously, deciding whether the environment will change after each gen.
            }
        }while (true);
    }//End of setEnviroChange.

    //Start of setClimate.
    //Randomly generates a temperature from -45°C - 53°C for the climate in which the organisms will live and evolve. This method is called by setEnvirochange, if it
    //determines that random climatic changes will occur, causing it to generate a new temperature for the climate of the organisms' ecosystem. It will also generate an
    //initial temperature for the climate when called upon by the natural selection class when it starts running.
    public void setClimate()throws Exception{
            int min = -45;
            int max = 53;
            climate = (int) (Math.random() * ((max - min) + 1)) + min;
            //System.out.println("val is: "+climate+"°C");
            //The code that is commented out above is used for testing purposes in conjunction with a separate rough testing class as it prints out the value of climate
            //immediately after setting it, outside of testing, the value of climate would be obtained separately through the getClimate method so that one can get the
            //value of climate without changing it in the process of getting it every time.
            //System.exit(0);
    }//End of setClimate.

    //Start of setTerrain1.
    //Randomly generates a value between 1-5 for the "harshness" of the location the where organisms will live and evolve. This method is called by setEnvirochange, if it
    //determines that random landscape changes will occur, causing it to generate a new value for the "harshness" of the organisms' ecosystem.
    public void setTerrain1()throws Exception{
        int min = 0;
        int max = 5;
        terrain1 = (int) (Math.random() * ((max - min) + 1)) + min;
        //System.out.println("terrain 1 val is: "+terrain1);
        //The code that is commented out above is used for testing purposes in conjunction with a separate rough testing class as it prints out the value of terrain1
        //immediately after setting it, outside of testing, the value of terrain1 would be obtained separately through the getTerrain1 method so that one can get the value
        //of terrain1 without changing it in the process of getting it every time.
        //System.exit(0);
    }//End of setTerrain1.

    //Start of setTerrain2.
    //Randomly generates a value between 1-5 for the structural diversity of the location where the organisms will live and evolve. This method is called by setEnvirochange,
    //if it determines that random landscape changes will occur, causing it to generate a new value to indicate the structural diversity of the organisms' ecosystem.
    public void setTerrain2()throws Exception{
        int min = 0;
        int max = 5;
        terrain2 = (int) (Math.random() * ((max - min) + 1)) + min;
        //System.out.println("terrain 2 val is: "+terrain2);
        //The code that is commented out above is used for testing purposes in conjunction with a separate rough testing class as it prints out the value of terrain2
        //immediately after setting it, outside of testing, the value of terrain2 would be obtained separately through the getTerrain2 method so that one can get the value
        //of terrain2 without changing it in the process of getting it every time.
        //System.exit(0);
    }//End of setTerrain2.

    //Start of setFoodAbundanceInOrganic.
    //Sets a value between 1-10 to determine the amount of inorganic food available to the primary producer organisms in their environment. This method is called by
    //setEnvirochange if it determines that random changes in availability of inorganic food substances to primary producers will occur, causing it to generate a new value
    //to indicate the availability of inorganic food substances to primary producers in their ecosystem.
    public void setFoodAbundanceInOrganic()throws Exception{
        int min = 0;
        int max = 10;
        foodAbundanceInOrganic = (int) (Math.random() * ((max - min) + 1)) + min;
        //System.out.println("food abundance val is: "+foodAbundanceInOrganic);
        //The code that is commented out above is used for testing purposes in conjunction with a separate rough testing class as it prints out the value of
        //foodAbundanceInOrganic immediately after setting it, outside of testing, the value of foodAbundanceInOrganic would be obtained separately through the
        //getFoodAbundanceInOrganic method so that one can get the value of foodAbundanceInOrganic without changing it in the process of getting it every time.
    }//End of setFoodAbundanceInOrganic.

    //Start of setInorganicResourceAbundance.
    //Sets a value between 1-10 to determine the amount of inorganic resources available to the organisms in their environment. This method is called by setEnvirochange if
    //it determines that a random change in availability of inorganic resources will occur, causing it to generate a new value to indicate the availability of inorganic
    //resources to the organisms in their ecosystem.
    public void setInorganicResourceAbundance()throws Exception{
        int min = 0;
        int max = 10;
        inorganicResourceAbundance = (int) (Math.random() * ((max - min) + 1)) + min;
       // System.out.println("food abundance val is: "+inorganicResourceAbundance);
        //The code that is commented out above is used for testing purposes in conjunction with a separate rough testing class as it prints out the value of
        //inorganicResourceAbundance immediately after setting it, outside of testing, the value of inorganicResourceAbundance would be obtained separately through the
        //getInorganicResourceAbundance method so that one can get the value of inorganicResourceAbundance without changing it in the process of getting it every time.
    }//End of setInorganicResourceAbundance.

    //Start of getTerreOuEau.
    //This allows the value indicating whether an environment is terrestrial or aquatic to be called and accessed so that the natural selection class can compare an
    //organism's traits against the needs and conditions of an aquatic or terrestrial environment.
    public int getTerreOuEau(){
        return terreOuEau;
    }//End of getTerreOuEau.

    //Start of getClimate.
    //This allows the climate value to be called and accessed so that an organism's traits can be compared and assessed against the needs and conditions of the climate of
    //its environment. It can also be called upon for the user to see what the climate value was during a given generation and how that may have influenced the evolution of
    //the organisms in the program.
    public int getClimate(){
        return climate;
    }//End of getClimate.

    //Start of getTerrain1
    //This allows the value of terrain1 to be called and accessed so that an organism's traits can be compared and assessed against the needs and conditions of the terrain
    //of its environment. It can also be called upon for the user to see the value indicating how "harsh" the environment was during a given generation and how that may
    //have influenced the evolution of the organisms in the program.
    public int getTerrain1(){
        return terrain1;
    }//End of getTerrain1.

    //Start of getTerrain2.
    //This allows the value of terrain2 to be called and accessed so that an organism's traits can be compared and assessed against the needs and conditions of the
    //structural diversity of its environment. It can also be called upon for the user to see the value indicating how structurally diverse the environment was during a
    //given generation and how that may have influenced the evolution of the organisms in the program.
    public int getTerrain2(){
        return terrain2;
    }//End of getTerrain2.

    //Start of getFoodAbundanceInOrganic.
    //This allows the value of foodAbundanceInOrganic to be called and accessed so that an primary producer organism's traits can be compared and assessed against the needs
    //and conditions of the availability of inorganic substances for food in its environment. It can also be called upon for the user to see the value indicating level of
    //inorganic food available to primary producers in the environment during a given generation and how that may have influenced the evolution of the organisms in the
    //program. It can also be used to influence the population of primary producers, which in turn may affect populations of various types of consumers.
    public int getFoodAbundanceInOrganic(){
        return foodAbundanceInOrganic;
    }//End of getFoodAbundanceInOrganic.

    //Start of getInorganicResourceAbundance.
    //This allows the value of inorganicResourceAbundance to be called and accessed so that an primary producer organism's traits can be compared and assessed against the
    //needs and conditions of the availability of inorganic resources for shelter, tools, grooming etc., in its environment. It can also be called upon for the user to see the
    //value indicating level of inorganic resources available to organisms in the environment during a given generation and how that may have influenced the evolution of the
    //organisms in the program.
    public int getInorganicResourceAbundance(){
        return inorganicResourceAbundance;
    }//End of getInorganicResourceAbundance.
}

