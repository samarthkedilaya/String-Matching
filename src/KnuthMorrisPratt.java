import java.util.Arrays;

public class KnuthMorrisPratt
{
    private int[] ComputePrefixFunc(char P[])
    {
        int m = P.length;
        int[] lps = new int[m];
        lps[0] = 0;
        int k = 0;
        for(int i=1;i<m;i++)
        {
            while (k>0 && P[k]!=P[i])
            {
                k = lps[k-1];
            }
            if(P[k]==P[i])
            {
                k = k + 1;
            }
            lps[i]=k;
        }
        return lps;
    }

    public void KMP(char[] T, char[] P)
    {
        int m = P.length;
        int n = T.length;
        int[] lps = ComputePrefixFunc(P);
//        System.out.println(Arrays.toString(lps));
        int q=0;
        for(int i=0;i<n;i++)
        {
//            System.out.println("i="+i+",q="+q);
            while (q>0 && P[q]!=T[i])
            {
                q=lps[q-1];
            }
            if(P[q]==T[i])
            {
                q=q+1;
            }
            if(q==m)
            {
                System.out.println("Pattern found at index "+((i+1)-q));
                q=lps[q-1];
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
            long beginkmp = System.currentTimeMillis();
            KnuthMorrisPratt kmp = new KnuthMorrisPratt();
            kmp.KMP(text.toCharArray(), pattern.toCharArray());
            long endkmp = System.currentTimeMillis();
            System.out.println("The time taken by Knuth Morris Pratt Algorithm is " +  (endkmp - beginkmp) + "ms");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}