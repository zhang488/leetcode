package 数组;

import java.util.*;

/**
 * 380. O(1) 时间插入、删除和获取随机元素
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 实现RandomizedSet 类：
 *
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 *
 *
 *
 * 示例：
 *
 * 输入
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * 输出
 * [null, true, false, true, 2, true, false, 2]
 *
 * 解释
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
 * randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
 * randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
 * randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
 * randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
 * randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
 * randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
 *
 *
 * 提示：
 *
 * -231 <= val <= 231 - 1
 * 最多调用 insert、remove 和 getRandom 函数 2 * 105 次
 * 在调用 getRandom 方法时，数据结构中 至少存在一个 元素。
 */
public class Demo45实现一个Map {

    public static void main(String[] args) {

    }

}

/**
 * 使用一个List存储一遍元素，用来进行随机查找使用，用map来存储元素以及元素对应的List中的下标
 * 用来维护长度，增删操作，为什么要引入map，因为要判断是否存在的时候需要调用hashCode方法来保证
 * 插入删除方法时间复杂度在 O(1)
 */
class RandomizedSet{

    List<Integer> nums;
    Map<Integer,Integer> hashMap;
    Random random;

    public RandomizedSet() {
        nums=new ArrayList<>();
        hashMap=new HashMap<>();
        random=new Random();
    }

    /**
     * 插入元素
     * @param val
     * @return
     */
    public boolean insert(int val){
        if (hashMap.containsKey(val)) {
            return false;
        }
        int index = nums.size();
        nums.add(val);
        hashMap.put(val,index);
        return true;
    }

    /**
     * 删除元素
     * @param val
     * @return
     */
    public boolean remove(int val){
        if (!hashMap.containsKey(val)) {
            return false;
        }
        //获取要删除元素下标
        Integer idx = hashMap.get(val);
        //获取最后一个元素
        Integer last = nums.get(nums.size() - 1);
        //将最后一个元素替换到要删除的下标位置
        nums.set(idx,last);
        hashMap.put(last,idx);
        //删除元素
        nums.remove(nums.size() - 1);
        hashMap.remove(val);
        return true;
    }

    /**
     * 随机获取元素
     * @return
     */
    public int getRandom(){
        return this.nums.get(random.nextInt(this.nums.size()));
    }



}
