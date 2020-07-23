package day01;

public class day0101 {
    //在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
    // 每一列都按 照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
    // 判断数组中是否 含有该整数。
    //查找的过程本质是排除 如果一次查找效率低下 我们采用从右上角开始查找的方法
    //因为是递增的 所以右上角的数如果比n大就 这一列都可排除没有n
    //右上角数字如果比n小就可排除这一行没有n
    public boolean Find(int n , int[] []array) {
        if (array==null) {
            return false;
        }
        int i =0;
        int j =array[0].length-1;//arrayij就是右上角的那一个数字
        while(i<array.length&&j>=0) {//j是倒着走的 i是正着走的
            if (n<array[i][j]) {
                //排除当前列
                j--;
            }else if (n>array[i][j]) {
                //排除当前行
                i++;
            }else{
                //找到
                return true;
            }
        }
        return false;
    }

}
