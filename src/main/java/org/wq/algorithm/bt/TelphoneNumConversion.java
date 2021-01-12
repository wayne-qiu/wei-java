package org.wq.algorithm.bt;

import java.util.ArrayList;
import java.util.List;

//    作者：wang_ni_ma
//    链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/tong-su-yi-dong-dong-hua-yan-shi-17-dian-hua-hao-m/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

public class TelphoneNumConversion {
    //一个映射表，第二个位置是"abc“,第三个位置是"def"。。。
    //这里也可以用map，用数组可以更节省点内存
    String[] letter_map = {" " , "*" , "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tuv" , "wxyz"};
    //最终输出结果的list
    List<String> res = new ArrayList<>();

    public static void main(String[] args) {

//        System.out.println(new TelphoneNumConversion().letterCombinations("23"));

        new TelphoneNumConversion().letterCombinations2("23", "", 0);
    }

    public void letterCombinations2(String digits, String path, int cur) {

        if(cur == digits.length()){
            System.out.println(path);
            return;
        }

        char c = digits.charAt(cur);
        int index = c - '0';
        String ls = letter_map[index];

        for (int j = 0; j < ls.length(); j++) {
            letterCombinations2(digits, path+ls.substring(j,j+1), cur+1);
        }

    }


    public List<String> letterCombinations(String digits) {
        //注意边界条件
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        iterStr(digits , "" , 0);
        return res;
    }

    //递归函数
    void iterStr(String str , String letter , int index) {
        //递归的终止条件，注意这里的终止条件看上去跟动态演示图有些不同，主要是做了点优化
        //动态图中是每次截取字符串的一部分，"234"，变成"23"，再变成"3"，最后变成""，这样性能不佳
        //而用index记录每次遍历到字符串的位置，这样性能更好
        if (index == str.length()) {
            res.add(letter);
            return;
        }
        //获取index位置的字符，假设输入的字符是"234"
        //第一次递归时index为0所以c=2，第二次index为1所以c=3，第三次c=4
        //subString每次都会生成新的字符串，而index则是取当前的一个字符，所以效率更高一点
        char c = str.charAt(index);
        //map_string的下表是从0开始一直到9， c-'0'就可以取到相对的数组下标位置
        //比如c=2时候，2-'0'，获取下标为2,letter_map[2]就是"abc"
        int pos = c - '0';
        String map_string = letter_map[pos];
        //遍历字符串，比如第一次得到的是2，页就是遍历"abc"
        for (int i = 0; i < map_string.length(); i++) {
            //调用下一层递归，用文字很难描述，请配合动态图理解
            iterStr(str , letter + map_string.charAt(i) , index + 1);
        }
    }
}
