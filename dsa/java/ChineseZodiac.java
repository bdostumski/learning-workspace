import java.util.Scanner;

public class ChineseZodiac {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);

        int year = Integer.parseInt(cin.nextLine());
        int counter = 0;

        if(year <= 2011) {
            while(true) {
                if(year == 2000) {
                    System.out.println("Dragon");
                    break;
                }

                if(year == 2001) {
                    System.out.println("Snake");
                    break;
                }

                if(year == 2002) {
                    System.out.println("Horse");
                    break;
                }

                if(year == 2003) {
                    System.out.println("Sheep");
                    break;
                }

                if(year == 2004) {
                    System.out.println("Monkey");
                    break;
                }

                if(year == 2005) {
                    System.out.println("Rooster");
                    break;
                }

                if(year == 2006) {
                    System.out.println("Dog");
                    break;
                }

                if(year == 2007) {
                    System.out.println("Pig");
                    break;
                }

                if(year == 2008) {
                    System.out.println("Rat");
                    break;
                }

                if(year == 2009) {
                    System.out.println("Ox");
                    break;
                }

                if(year == 2010) {
                    System.out.println("Tiger");
                    break;
                }

                if(year == 2011) {
                    System.out.println("Hare");
                    break;
                }

                year += 12;
            }
        } else {

            while(true) {

                if(year == 2000) {
                    System.out.println("Dragon");
                    break;
                }

                if(year == 2001) {
                    System.out.println("Snake");
                    break;
                }

                if(year == 2002) {
                    System.out.println("Horse");
                    break;
                }

                if(year == 2003) {
                    System.out.println("Sheep");
                    break;
                }

                if(year == 2004) {
                    System.out.println("Monkey");
                    break;
                }

                if(year == 2005) {
                    System.out.println("Rooster");
                    break;
                }

                if(year == 2006) {
                    System.out.println("Dog");
                    break;
                }

                if(year == 2007) {
                    System.out.println("Pig");
                    break;
                }

                if(year == 2008) {
                    System.out.println("Rat");
                    break;
                }

                if(year == 2009) {
                    System.out.println("Ox");
                    break;
                }

                if(year == 2010) {
                    System.out.println("Tiger");
                    break;
                }

                if(year == 2011) {
                    System.out.println("Hare");
                    break;
                }

                year -= 12;
            }

        }

    }

}
