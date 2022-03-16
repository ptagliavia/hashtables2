package equals;

public class TestSpecs
{
    public static void main(String[] args)
    {
        ComputerSpec defaultSpec = new ComputerSpec();
        ComputerSpec mySpec = new ComputerSpec("Intel i9 9900K", 64, true, 5.0);
        ComputerSpec multitaskingSpec = new ComputerSpec("AMD Ryzen", 64, true, 5.0);
        ComputerSpec serverSpec = new ComputerSpec("Intel i9 9900K", 128, false, 5.0);

        System.out.println(defaultSpec);
        System.out.println(mySpec);

        ComputerSpec referenceToDefault = defaultSpec;
        System.out.println(referenceToDefault);

        //let's use == to make a comparison
        System.out.println(defaultSpec == mySpec);

        //let's use the default Object.equals()
        System.out.println(defaultSpec.equals(mySpec));
        System.out.println();

        //equivalence relation?
        //reflexive
        System.out.println("Reflexive: " + mySpec.equals(mySpec)); //a.equals(a)
        System.out.println();

        //symmetric
        System.out.println("Symmetric: " + mySpec.equals(defaultSpec)); //a.equals(b)
        System.out.println("Symmetric: " + defaultSpec.equals(mySpec)); //b.equals(a)
        System.out.println("Symmetric: " + multitaskingSpec.equals(defaultSpec)); //a.equals(b)
        System.out.println("Symmetric: " + defaultSpec.equals(multitaskingSpec)); //b.equals(a)
        System.out.println();

        //transitive
        System.out.println("Transitive: " + mySpec.equals(defaultSpec)); //a.equals(b)
        System.out.println("Transitive: " + defaultSpec.equals(serverSpec)); //b.equals(c)
        System.out.println("Transitive: " + mySpec.equals(serverSpec)); //a.equals(c)
    }
}
