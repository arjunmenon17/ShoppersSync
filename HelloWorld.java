public class HelloWorld {
    public static void main(String[] args)throws Exception {
        int enviroChange = 70;
        FSTEnvironment z = new FSTEnvironment();
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
                    System.out.println("There was no shift in the environmental conditions between this generation and the last. OG climate is: " + z.getClimate() + " OG terrain 1 is: "+ z.getTerrain1() + " OG terrain2 is: " + z.getTerrain2()+" OG inorganic food abundance is: " + z.getFoodAbundanceInOrganic()+ " OG inorganic resources val is: " + z.getInorganicResourceAbundance());
                } else {
                    System.out.println("There were extreme climactic or geologic events that occurred between this generation and the last, causing change to the environmental conditions.");
                    //This is to randomly generate a number indicating how many environmental factors should be allowed to change at a given time. 1 means one factor
                    //can change while 5 means that all 5 factors (indicated below) will be allowed to change
                        z.setClimate();
                        z.setTerrain1();
                        z.setTerrain2();
                        z.setFoodAbundanceInOrganic();
                        z.setInorganicResourceAbundance();
                        System.out.println("The new climate is: " + z.getClimate() + " new terrain 1 is: "+ z.getTerrain1() + " new terrain2 is: " + z.getTerrain2()+" new inorganic food abundance is: " + z.getFoodAbundanceInOrganic()+ " new inorganic resources val is: " + z.getInorganicResourceAbundance());
                }
                //System.exit(0); causes this to only run once, if commented out it runs continuously, deciding whether the environment will change after each gen
            }
        }while (true);
    }
}

