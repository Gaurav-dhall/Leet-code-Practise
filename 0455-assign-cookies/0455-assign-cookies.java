class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int greed=0;
        int size=0;
        


        while(size<s.length){
            if(s[size]>=g[greed]){
                greed++;
            }
            if(greed==g.length){
                break;
            }
            size++;
        }
        return greed;

           
    }
}