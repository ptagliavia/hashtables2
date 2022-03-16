package hashtables;

public class TestMyHashTable
{
    public static void main(String[] args)
    {
        HashTable<String> wordsSet = new HashTable<>();

        wordsSet.add("indubitably", "mendacious", "erroneous",
                     "supercalifragilisticexpialidocious",
                     "orthogonal", "tautology", "jovial", "ephemeral");

        System.out.println(wordsSet);

        //try contains()
        System.out.println(wordsSet.contains("mendacious"));
        System.out.println(wordsSet.contains("jovial"));
        System.out.println(wordsSet.contains("tautology"));
        System.out.println(wordsSet.contains("frivolous")); //not present

        wordsSet.remove("jovial");
        System.out.println(wordsSet.contains("jovial")); //false
        wordsSet.add("jovial");
        System.out.println(wordsSet.contains("jovial")); //true
    }
}













