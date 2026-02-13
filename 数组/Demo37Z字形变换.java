package 数组;


import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 *
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 */
public class Demo37Z字形变换 {

    public static void main(String[] args) {

    }

    /**
     * 根据numRows定义一个List集合存储每行的元素，遍历字符串，根据numRows的长度到达末尾进行转向，依次排列到对应的列表行中，最后将集合中的所有行拼接起来
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        //如果numRows小于等于1，则直接返回原字符串
        if (numRows<=1) return s;
        //最终返回结果
        StringBuilder res=new StringBuilder();
        //定义行数存储转换后的Z字符序列
        List<StringBuilder> rows=new ArrayList<>(numRows);
        //初始化行数
        for(int i=0;i<numRows;i++) rows.add(new StringBuilder());
        //定义需要存储的行的位置，和是否需要翻转的标志
        int row=0,flag=-1;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            rows.get(row).append(charArray[i]);
            //如果row==0代表遍历到第一行，或者row的大小和numRows-1相等代表到了最后一行，则需要翻转
            if (row==0||row==numRows-1) flag=-flag;
            row+=flag;
        }
        for (int i = 0; i < rows.size(); i++) {
            res.append(rows.get(i));
        }
        return res.toString();
    }
}
