package javaTester;

public class javaTester {
    public static void main(String[] args) {
        //member 1
        boolean member01;

        //member 2
        boolean member02;

        //result
        boolean result;

        // AND
        member01 = true;
        member02 = true;
        System.out.println("Result :" + (member01 && member02));

        member01 = true;
        member02 = false;
        System.out.println("Result :" + (member01 && member02));

        member01 = false;
        member02 = true;
        System.out.println("Result :" + (member01 && member02));

        member01 = false;
        member02 = false;
        System.out.println("Result :" + (member01 && member02));

        member01 = true;
        member02 = true;
        System.out.println("\nResult :" + (member01 || member02));

        member01 = true;
        member02 = false;
        System.out.println("Result :" + (member01 || member02));

        member01 = false;
        member02 = true;
        System.out.println("Result :" + (member01 || member02));

        member01 = false;
        member02 = false;
        System.out.println("Result :" + (member01 || member02));

    }
}
