package day.day9;

/**
 * @ClassName Solution
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/8 8:15
 * @Version 1.0
 */
public class Solution {


    /**
     * 找中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length+nums2.length;
        int[] arr=new int[n];
        double result=0.0;
        int i=0;
        int j=0;
        while(i+j<=n/2){
            if(i<nums1.length && j<nums2.length){
                if(nums1[i]<nums2[j]){
                    arr[i+j]=nums1[i];
                    i++;
                }else {
                    arr[i+j]=nums2[j];
                    j++;
                }
            }else if(i==nums1.length){
                arr[i+j]=nums2[j];
                j++;
            }else if(j== nums2.length){
                arr[i+j]=nums1[i];
                i++;
            }

        }
        double temp=arr[(n-1)/2]+arr[n/2];
        result=temp/2;
        return result;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        //int[] num1={1,2};
        //int[] num2={3,4};
        //System.out.println(solution.findMedianSortedArrays(num1,num2));

        String s="civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println(solution.longestPalindrome(s));

    }

    /**
     *
     * 找最长回文数
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        String [] arr=s.split("");
        String result="";
        for(int i=0;i<s.length();i++){
            for(int j=arr.length-1;j>=i;j--){
                if(arr[i].equals(arr[j]) && check(i,j,arr)){
                    String temp=s.substring(i,j+1);
                    if(temp.length()>result.length()){
                        result=temp;
                    }
                }
            }
        }
        return result;
    }

    public boolean check(int i,int j,String [] arr){
        String shun="";
        String fan="";
        for(int k=i;k<=j;k++){
            shun+=arr[k];
        }
        for(int k=j;k>=i;k--){
            fan+=arr[k];
        }
        return shun.equals(fan);
    }

    public String longestPalindrome(String s) {
        if(s==null ||s.isEmpty()){
            return s;
        }
        int n=s.length();
        char[] arr=s.toCharArray();
        boolean [][] dp=new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        for( int i=0;i<n-1;i++){
            dp[i][i+1]=arr[i]==arr[i+1];
        }


        return "";
    }


}
