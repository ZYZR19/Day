package day05;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

public class day05_20 {
        public boolean BSTCore (int[]array,int start,int end ) {
            if (start>=end) {
                //区域不断缩小 为空的是时候证明之前的所有范围都满足检测条件
                //是一个bst
                return true;
            }
            //拿到root节点的值 后序遍历
            int root = array[end];
            //先遍历左半部分,也就是整体都要比root小,拿到左子树序列
            int i =0;
            while(i<end&&array[i]<root) {
                i++;
            }
            //在检测右子树是否符合大于root的条件要从i开始,就是右半部分开始
            for (int j= i; j<end;j++) {
                if (array[j]<root) {
                    //在合法位置处 当前值小于root 不满足bst
                    return false;
                }
            }
            //走到这里说明当前序列满足 但是还要递归检测左右子树
            return BSTCore(array,0,i-1)&& BSTCore(array,i,end-1);
        }
        public boolean BTS(int[] array) {
            if (array.length==0) {
                return false;
            }
            return  BSTCore(array,0,array.length-1);
        }
}
