package day05;

import com.sun.corba.se.spi.ior.IdentifiableFactory;

import java.util.Stack;

public class day05_18 {
    public boolean IsPopOrder (int []pushA,int[]popA) {
        if (pushA==null||popA==null||pushA.length!=popA.length) {
            return false;
        }
        int i =0;
        int j =0;
        Stack<Integer> st = new Stack<>();
        for (;i<pushA.length;i++) {
            st.push(pushA[i]);
            while (!st.empty()&&st.peek()==popA[j]){
                st.pop();
                j++;
            }

        }
        return st.empty();
    }

}
