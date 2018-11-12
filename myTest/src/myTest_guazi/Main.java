package myTest_guazi;

import java.util.*;

/**
 * Created by Administrator on 2018/3/24.
 */
public class Main {
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int w=in.nextInt();


        //将组合保存在
        /*int[] nstyle=new int[n];
        int[] window=new int[w];
        for(int i=0;i<nstyle.length;++i){
            nstyle[i]=0;
        }
        for(int i=0;i<window.length;++i){
            window[i]=i;
        }

        for(int i=0;i<n;++i){
            for(int j=0;j<w;++j){
                if(window[j]+1==window[j+1]){
                    if(nstyle[])
                }
            }
        }
*/


       /* int k=in.nextInt();

        in.nextLine();

        String str=in.nextLine();
        String[] mliceWord=str.split(" ");
        String[] netStation=new String[m];
        String[] netSentence=new String[m];
        for(int i=0;i<2*m;i++){
            if(i%2==0){
                netStation[i/2]=in.nextLine();
            }
            else{
                netSentence[i/2]=in.nextLine();
            }
        }
        int[] count=new int[10];
        for(int i=0;i<10;++i){
            count[i]=0;
        }

        for(int i=0;i<m;++i){
            for(int j=0;j<mliceWord.length;++j){
                if(netSentence[i].contains(mliceWord[j])){
                    count[i]++;
                    if(count[i]>=k){
                        System.out.println(netStation[i]);                    }
                }
            }

        }

*/

        //List arr=new ArrayList() ;
        /*for(int i=0;i<n;++i){
            str=str.
            arr.add()
        }*/

        String tmp=null;
        /*while( tmp=str.split(" ")!= null){
            arr=
        }*/





        /*LinkedList<Integer> myLinkList =new LinkedList<>();
        Scanner in=new Scanner(System.in);
        for(int i=0;i<5;++i){
            myLinkList.add(in.nextInt());
        }
        System.out.println(myLinkList);

        int arr[]=new int[5];
        int i=0;
        for (int it:myLinkList
             ) {

            arr[i++]=it;
        }
        Arrays.sort(arr);
        int brr[]=new int[arr[i-1]+1];
        for (i=0;i<brr.length;++i){
            brr[i]=0;
        }
        for (int it:arr
             ) {
            brr[it]+=1;
        }
        for(i=0;i<brr.length-1;++i){
            brr[i+1]+=brr[i];
        }
        //System.out.println(brr[i]);
        for(i=0;i<brr.length;++i){
            if(brr[i]==i&&myLinkList.contains(i)){
                System.out.println(brr[i]);
            }
        }*/
        //--------------------------------------------
        //携程笔试
        /*Scanner in=new Scanner(System.in);
        int arrLen=in.nextInt();
        int arr[]=new int[arrLen];
        for(int i=0;i<arrLen;i++){
            arr[i]=in.nextInt();
        }
        int count=0;
        for(int i=0;i<arrLen;++i){
            if(arr[i]==0){
                count++;
            }else{
                System.out.println(arr[i]);
            }
        }
        for(int i=0;i<count;++i){
            System.out.println("0");
        }*/



        /*
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        String[]  mystr=str.split(" ");
        int arrlen=mystr.length;
        int [][] arr=new int[arrlen][arrlen];
        int [][] brr=new int[arrlen][arrlen];
        for(int i=0;i<arrlen;++i){
            String s=mystr[i];
            arr[0][i]=Integer.parseInt(s);
        }
        for(int i=1;i<arrlen;i++){
            for(int j=0;j<arrlen;j++){
                arr[i][j]=in.nextInt();
            }
        }
        for(int i=0;i<arrlen;i++){
            for(int j=0;j<arrlen;j++){
                brr[j][arrlen-1-i]=arr[i][j];
            }
        }
        for(int i=0;i<arrlen;i++){
            for(int j=0;j<arrlen;j++){
                arr[i][j]=brr[i][j];
            }
        }
        int i=0;
        int j=0;
        for(i=0;i<arrlen;i++){
            for(j=0;j<arrlen-1;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println(arr[i][j]);
        }*/



    }
}
