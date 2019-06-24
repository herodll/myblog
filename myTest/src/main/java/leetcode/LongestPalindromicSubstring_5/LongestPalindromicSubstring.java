package leetcode.LongestPalindromicSubstring_5;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        /**
         * 思想：1.首先当字符串长度小于2的时候，也就意味着长度为1或者0，那么直接返回
         *      2.以当前字符为中心，向两边扩展来判断左右是否相同，但是需要注意，奇数和偶数的情况，如果是奇数，就比较两边，但如果是
         *        偶数，那么需要将当前字符作为其中的左数，与其右边比较，之后向两边各自展开比较
         *  #####注意：这里只是思想，暂时无法运行，由于参数值传递问题，而非引用传递，可以将参数设置为类的static变量
         */
/*        if(s.length()<2){
            return s;
        }
        int maxLen = 0;
        int start = 0;
        for(int i = 0;i<s.length();i++){
            LongestPalindromicSubstring.getLogestStr(s,i,i,start,maxLen);
            LongestPalindromicSubstring.getLogestStr(s,1,i+1,start,maxLen);

        }
        System.out.println(s.substring(start,start+maxLen));
        return s.substring(start,start+maxLen);
    }

    public static void getLogestStr(String s,int left,int right,int start,int maxLen){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        if(maxLen<right-left-1){
            start = left+1;
            maxLen = right - left -1;
        }*/

        /**
         * 方法2：也可以在同一个方法中来写而不是调用子函数，可有效解决上面方法1的问题。
         *       但是，在遍历字符串时，我们需要判断剩余的字符数是不是小于maxLen的一半，如果小于，说明长度不可能再长了，直接跳出循环；
         *       否则就要继续判断，我们用两个变量left和right分别指向当前位置，然后我们先要做的是向右遍历跳过重复项，这个操作很必要，
         *       比如对于 noon，i在第一个o的位置，如果我们以o为最中心往两边扩散，是无法得到长度为4的回文串的，只有先跳过重复，此时
         *       left指向第一个o，right指向第二个o，然后再向两边扩散。而对于 bob，i在第一个o的位置时，无法向右跳过重复，此时left
         *       和right同时指向o，再向两边扩散也是正确的，所以可以同时处理奇数和偶数的回文串，之后的操作就是更新maxLen和start了
         *
         */
        /*if(s.length()<2){
            return s;
        }
        int maxLen = 0;
        int start = 0;
        for(int i = 0;i<s.length();){
            int left = i;
            int right = i;
            if(s.length()-i<=maxLen/2){
                break;
            }
            while(right<s.length()-1 && s.charAt(right+1)==s.charAt(right)){
                ++right;
            }
            i = right+1;
            while(right<s.length()-1 && left>0 && s.charAt(left-1)==s.charAt(right+1)){
                ++right;
                --left;
            }
            if(maxLen<right-left+1){
                maxLen = right-left+1;
                start = left;
            }
        }
        return s.substring(start,start+maxLen);*/


    /**
     * 方法3：可以采用动态规划的思想，维持一个二维数组，dp[i][j]表示从下标i和到j对应的字符串是不是为回文字符串。
     * dp[i][j]=0   if i>j
     * dp[i][j]=1   if i=j
     * dp[i][j]=(s[i]==s[j])      if j=i+1
     * dp[i][j]= (s[i]==s[j] && dp[i+1][j-1]==1)        if j>i+1
     * 当j>i+1，dp[i][j]=1时，更新记录i和j，并计算maxLen
     */
    int dp[][] = new int[s.length()][s.length()];
    int left = 0;
    int right = 0;
    int maxLen = 0;
    for(int j= 0;j<s.length();j++){
        for(int i = 0;i<j;i++){
            if(i==j){
                dp[i][j] = 1;
            }
            if(i+1==j){
                dp[i][j] = (s.charAt(i)==s.charAt(j))?1:0;
            }
            else{
                dp[i][j] = (s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==1)?1:0;

            }
            if(dp[i][j]==1 && maxLen<j-i+1){
                left = i;
                right = j;
                maxLen = right-left+1;
            }
        }
    }
    for(int i = 0;i<s.length();i++){
        for(int j = 0;j<s.length();j++){
            System.out.print(dp[i][j]);
        }
        System.out.println();
    }
    System.out.println(maxLen);
    return s.substring(left,left+maxLen);
    }
}
