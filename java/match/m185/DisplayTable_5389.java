package match.m185;

import java.util.*;

/**
 * 5389. 点菜展示表
 * 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodItemi] ，其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
 * 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
 * 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
 * */
public class DisplayTable_5389 {

    public List<List<String>> displayTable(List<List<String>> orders) {
        Scanner in =new Scanner(System.in);
        TreeMap<String , Map<String , Integer>> tableFoodMap = new TreeMap<>(
                (a1 , a2) -> (Integer.parseInt(a1)-Integer.parseInt(a2)));
        Set<String> foodNameSet = new HashSet<>();
        for (List<String> order:orders) {
            String tableNum = order.get(1);
            String foodName = order.get(2);
            foodNameSet.add(foodName);
            if (tableFoodMap.containsKey(tableNum)) {
                Map<String , Integer> foodCountMap = tableFoodMap.get(tableNum);
                foodCountMap.put(foodName , foodCountMap.getOrDefault(foodName , 0) + 1);
            }else {
                Map<String , Integer> foodCountMap = new HashMap<>();
                foodCountMap.put(foodName , 1);
                tableFoodMap.put(tableNum , foodCountMap);
            }
        }

        List<String> orderedFoodNames = new ArrayList<>(foodNameSet);
        orderedFoodNames.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        List<List<String>> showMenus = new ArrayList<>();
        for (Map.Entry<String , Map<String , Integer>> entry:tableFoodMap.entrySet()) {
            String tableId = entry.getKey();
            List<String> showMenu = new ArrayList<>();
            showMenu.add(tableId);
            for (String foodName:orderedFoodNames) {
                showMenu.add(entry.getValue().getOrDefault(foodName , 0) + "");

            }
            showMenus.add(showMenu);
        }
        orderedFoodNames.add(0 , "tables");
        List<List<String>> res = new ArrayList<>();
        res.add(orderedFoodNames);
        res.addAll(showMenus);
        return res;

    }

}
