package top.wsure.leetcode.question;//给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodIt
//emi] ，其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
//
// 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。接下来每一行中
//的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
//
// 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
//
//
//
// 示例 1：
//
// 输入：orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David",
//"3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","
//Ceviche"]]
//输出：[["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1
//","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
//解释：
//点菜展示表如下所示：
//Table,Beef Burrito,Ceviche,Fried Chicken,Water
//3    ,0           ,2      ,1            ,0
//5    ,0           ,1      ,0             ,1
//10   ,1           ,0      ,0            ,0
//对于餐桌 3：David 点了 "Ceviche" 和 "Fried Chicken"，而 Rous 点了 "Ceviche"
//而餐桌 5：Carla 点了 "Water" 和 "Ceviche"
//餐桌 10：Corina 点了 "Beef Burrito"
//
//
// 示例 2：
//
// 输入：orders = [["James","12","Fried Chicken"],["Ratesh","12","Fried Chicken"],[
//"Amadeus","12","Fried Chicken"],["Adam","1","Canadian Waffles"],["Brianna","1","
//Canadian Waffles"]]
//输出：[["Table","Canadian Waffles","Fried Chicken"],["1","2","0"],["12","0","3"]]
//
//解释：
//对于餐桌 1：Adam 和 Brianna 都点了 "Canadian Waffles"
//而餐桌 12：James, Ratesh 和 Amadeus 都点了 "Fried Chicken"
//
//
// 示例 3：
//
// 输入：orders = [["Laura","2","Bean Burrito"],["Jhon","2","Beef Burrito"],["Melis
//sa","2","Soda"]]
//输出：[["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]
//
//
//
//
// 提示：
//
//
// 1 <= orders.length <= 5 * 10^4
// orders[i].length == 3
// 1 <= customerNamei.length, foodItemi.length <= 20
// customerNamei 和 foodItemi 由大小写英文字母及空格字符 ' ' 组成。
// tableNumberi 是 1 到 500 范围内的整数。
//
// Related Topics 数组 哈希表 字符串 有序集合 排序
// 👍 48 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution1418 {
    /**
     * 一个笨比解法，压线过
     * 主要使用TreeSet有序性，无了
     * @param orders
     * @return
     */
    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<Integer> tables = new TreeSet<>();
        Set<String> foods = new TreeSet<>();
        Map<String,Integer> map = new HashMap<>();
        String key = null;
        for (List<String> order:orders){
            tables.add(Integer.parseInt(order.get(1)));
            foods.add(order.get(2));
            key = order.get(2)+"_"+order.get(1);
            map.put(key,map.getOrDefault(key,0)+1);
        }
        List<List<String>> res = new ArrayList<>(tables.size()+1);
        res.add(new ArrayList<String>(){{add("Table");addAll(foods);}});
        for (Integer table:tables){
            List<String> row = new ArrayList<String>(){{add(table.toString());}};
            for(String food: res.get(0)){
                if(!food.equals("Table")){
                    row.add(map.getOrDefault(food+"_"+table,0).toString());
                }
            }
            res.add(row);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/**
 4:11 下午	info: 已提交,请稍等

 4:11 下午	info
 解答成功:
 执行耗时:93 ms,击败了12.05% 的Java用户
 内存消耗:64.7 MB,击败了14.46% 的Java用户
 */