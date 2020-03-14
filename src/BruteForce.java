public class BruteForce
{
    public static void search(String T, String P)
    {
        int n = T.length();
        int m = P.length();
        int k = 0;
        for (int i = 0; i <= n - m; i++)
        {
            int j;
            for (j = 0; j < m; j++)
                if (T.charAt(i + j) != P.charAt(j))
//                    System.out.println("No pattern found in given text");
                    break;
            if (j == m)
            {
                System.out.println("The pattern has been found at index " + i);
                k++;
            }
        }
        if (k == 0)
        {
            System.out.println("No pattern has been found");
        }
        else
            System.out.println(k);
    }
    public static void main(String args[])
    {
        try
        {
            Input inputFile = new Input("Semantics.txt");
//            Input inputFile = new Input("Text.txt");

            String text = inputFile.ipString;

//            Input patternFile = new Input("Pattern12.txt");
//            String pattern = patternFile.ipString;

//            String pattern = "$$$$$@";
//            String pattern = "$$$$$$";

//            String pattern = "bifunctional tRNA (5-methylaminomethyl-2-thiouridine)(34)-methyltransferase MnmD/FAD-dependent 5-carboxymethylaminomethyl-2-thiouridine(34) oxidoreductase MnmC";
            String pattern = "Phenylacetyl-CoA ligase";

            if ((pattern == null) || pattern.trim().equals("") || (pattern.length() == 0))
            {
                System.out.println("Pattern is empty");
                return;
            }
            long beginbf = System.currentTimeMillis();
            BruteForce.search(text, pattern);
            long endbf = System.currentTimeMillis();
            System.out.println("The time taken by Brute Force Algorithm is " +  (endbf - beginbf) + "ms");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}