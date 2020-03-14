public class RabinKarp
{
    public final static int d = 256;
    static void search(char[] P, char[] T, int q)
    {
        int i, j;
        int m = P.length;
        int n = T.length;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;
        for (i = 0; i < m-1; i++)
            h = (h*d)%q;
        for (i = 0; i < m; i++)
        {
            p = (d*p + P[i])%q;
            t = (d*t + T[i])%q;
        }
        for (i = 0; i <= n - m; i++)
        {
            if ( p == t )
            {
                for (j = 0; j < m; j++)
                {
                    if (T[i+j] != P[j])
                        break;
                }
                if (j == m)
                {
                    System.out.println("The pattern has been found at index " + i);
                }
            }
            if ( i < n-m )
            {
                t = (d*(t - T[i]*h) + T[i+m])%q;
                if (t < 0)
                    t = (t + q);
            }
        }
    }
    public static void main(String args[])
    {
        try
        {
            Input inputFile = new Input("Semantics.txt");
//            Input inputFile = new Input("Text.txt");

            String text = inputFile.ipString;

//            Input patternFile = new Input("Pattern11.txt");
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
            int q = 199; // A prime number
            long beginrk = System.currentTimeMillis();
            RabinKarp.search(pattern.toCharArray(), text.toCharArray(), q);
            long endrk = System.currentTimeMillis();
            System.out.println("The time taken by Rabin Karp Algorithm is " + (endrk - beginrk) + "ms");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}