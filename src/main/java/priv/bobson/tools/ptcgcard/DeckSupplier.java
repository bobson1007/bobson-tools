package priv.bobson.tools.ptcgcard;

import priv.bobson.tools.enums.CardEffectEnum;

import javax.jws.Oneway;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.Supplier;

public class DeckSupplier implements Supplier<Map> {

    private static Map<String, Integer> deck = new HashMap();

    @Override
    public Map get() {
        return null;
    }

    public static Map get(int num) {
        switch (num) {
            case 1:
                init1();
            case 2:
                init2();
            default:
        }
        return deck;
    }

    /**
     * 顫弦蠑螈vmax + 毒藻龍
     */
    private static void init1() {
        //pm - 17  (備用 : 蠑螈一組，破破袋一組)
        deck.put("顫弦蠑螈v", 2);
        deck.put("顫弦蠑螈vmax", 2);
        deck.put("破破袋", 2);
        deck.put("灰塵山", 2);
        deck.put("垃垃藻", 4);
        deck.put("毒藻龍", 4);
        deck.put("捷拉奧拉GX", 1);

        //場地 - 3
        deck.put("雷霆山", 1);
        deck.put("礦山", 2);

        //物品 - 16 (備用 : 先機球x1，交替x4，印章x1)
        deck.put("先機球", 3);
        deck.put("巢穴球", 4);
        deck.put("通信", 2);
        deck.put("薰香", 2);
        deck.put("粉碎之錘", 4);
        deck.put("吹風機", 1);

        //裝備 - 1 (備用 : 毒針)
        deck.put("反擊增幅器", 1);

        //人物 - 12 (備用 : 養鳥人x2，瑪俐x2，老大x1 )
        deck.put("博士", 3);
        deck.put("竹蘭", 4);
        deck.put("瑪俐", 3);
        deck.put("老大", 2);

        //能量 - 11 (備用 : 普電x5，極光x1 )
        deck.put("高速電能", 4);
        deck.put("單位能量", 4);
        deck.put("超能", 3);
    }

    /**
     * 顫弦蠑螈vmax + 銀伴戰獸
     */
    private static void init2() {
        //pm - 16
        deck.put("顫弦蠑螈v", 3);
        deck.put("顫弦蠑螈vmax", 3);
        deck.put("呆殼獸v", 2);
        deck.put("屬性空", 2);
        deck.put("銀伴戰獸GX", 2);
        deck.put("逐電犬v", 3);
        deck.put("捷拉奧拉GX", 1);

        //場地 - 3
        deck.put("雷霆山", 1);
        deck.put("礦山", 2);

        //物品 - 20
        deck.put("先機球", 4);
        deck.put("巢穴球", 1);
        deck.put("薰香", 3);
        deck.put("電氣充電器", 3);
        deck.put("電氣力量", 4);
        deck.put("交替", 4);
        deck.put("吹風機", 1);

        //裝備 - 1 (備用 : 毒針)
//        deck.put("反擊增幅器", 1);

        //人物 - 12 (備用 : 養鳥人x2，瑪俐x2，老大x1 )
        deck.put("博士", 4);
        deck.put("養鳥人", 2);
        deck.put("洛茲",3);
        deck.put("老大", 2);

        //能量 - 11 (備用 : 普電x5，極光x1 )
        deck.put("高速電能", 4);
        deck.put("電能", 6);
    }
}