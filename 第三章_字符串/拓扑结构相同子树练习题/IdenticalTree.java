import java.util.*;
 
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class IdenticalTree {
    public boolean chkIdentical(TreeNode A, TreeNode B) {
        // write code here
        StringBuilder builder=new StringBuilder();
        String s = convertTreeToStr(A, builder);
        builder.delete(0,builder.length());
        String s1 = convertTreeToStr(B, builder);
        return kmp(s, s1) != -1;//判断在A串中是否有B串存在
    }
    //kmp算法 具体详解请看http://www.jianshu.com/p/826480d851ee
    private int kmp(String a,String b){
        int a_len=a.length();
        int b_len=b.length();
        int i=0,j=0;
        int [] next=next(b);
        while (i<a_len&&j<b_len){
            if (j==-1||a.charAt(i)==b.charAt(j)){
               i++;
               j++;
            }else {
                j=next[j];
            }
        }
        if (j==b_len){
            return i-j;
        }else {
            return -1;
        }
    }
    //生成next数组
    private int [] next(String b){
        int b_len=b.length();
        int j=0,k=-1;
        int [] next=new int[b_len];
        next[0]=-1;
        while (j<b_len-1){
            if (k==-1||b.charAt(j)==b.charAt(k)){
                k++;
                j++;
                if (b.charAt(j)!=b.charAt(k)){
                    next[j]=k;
                }else {
                    next[j]=next[k];
                }
            }else {
                k=next[k];
            }
        }
        return next;
    }
    //序列化字符串
    public String convertTreeToStr(TreeNode head,StringBuilder builder){
        Stack<TreeNode> stack=new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()){
            TreeNode poll = stack.pop();
            builder.append(poll.val+"!");
 
            if (poll.right!=null){
                stack.push(poll.right);
            }else {
                builder.append("#!");
            }
 
            if (poll.left!=null){
                stack.push(poll.left);
            }else {
                builder.append("#!");
            }
 
        }
        return builder.toString();
    }
}