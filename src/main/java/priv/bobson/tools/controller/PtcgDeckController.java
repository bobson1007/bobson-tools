package priv.bobson.tools.controller;

import priv.bobson.tools.enums.CardEffectEnum;

import java.util.*;

public class PtcgDeckController {

    /* 卡組 */
    private final static Map<String, Integer> DECK = new HashMap<String, Integer>();
    /* 卡組指針 */
    private static int point = 0;

    /* 獎勵卡 */
    private static Stack<String> prizeCards = new Stack<>();
    /* 牌堆 */
    private static Stack<String> deck = new Stack<>();
    /* 棄牌堆 */
    private static Stack<String> discardPile = new Stack<>();
    /* 手牌 */
    private static LinkedList<String> handCards = new LinkedList<>();
    /* 場上所有pm */
    private static LinkedList<String> pokemons = new LinkedList<>();


    static int round = 1;
    static int all = 0;
    static int has = 0;


    static {
        //pm - 18
        DECK.put("顫弦蠑螈v", 3);
        DECK.put("顫弦蠑螈vamx", 2);
        DECK.put("破破袋", 3);
        DECK.put("灰塵山", 3);
        DECK.put("垃垃藻", 3);
        DECK.put("毒藻龍", 3);
        DECK.put("捷拉奧拉GX", 1);

        //場地 - 3
        DECK.put("雷霆山", 1);
        DECK.put("礦山", 2);

        //物品 - 14
        DECK.put("先機球", 4);
        DECK.put("巢穴球", 4);
        DECK.put("通信", 2);
        DECK.put("薰香", 2);
        DECK.put("印章", 1);
        DECK.put("吹風機", 1);

        //裝備

        //人物 - 11
        DECK.put("博士", 4);
        DECK.put("竹蘭", 4);
        DECK.put("養鳥人", 2);
        DECK.put("老大", 1);

        //能量 - 14
        DECK.put("電能", 6);
        DECK.put("特電", 4);
        DECK.put("單位能量", 2);
        DECK.put("超能", 2);
    }


    public static void main(String[] args) {
        boolean needRestart = true;
        while (needRestart) {
            if (handCards.contains("顫弦蠑螈v") || handCards.contains("破破袋") ||
                    handCards.contains("垃垃藻") || handCards.contains("捷拉奧拉GX")) {
                needRestart = false;
            } else {
                handCards.clear();
                deck.clear();
                prizeCards.clear();
                init(DECK);
                if (deck == null) {
                    return;
                }
                drawCards(7);
            }
        }


        boolean next = true;
        while (next) {
            System.out.println("\n第" + round + "回合，請使用手牌");
            Scanner scanner = new Scanner(System.in);
            String inputString = scanner.nextLine();
            if ("exit".equals(inputString)) {
                System.out.println("測試結束");
                return;
            } else if ("next".equals(inputString)) {
                round++;
                drawCards(1);
                continue;
            }
            CardEffectEnum cee = CardEffectEnum.getByName(inputString);
            if (cee == null) {
                System.out.println("手牌沒有此卡，請重新輸入\n" + handCards);
            } else {
                List<Object> result = cee.action(handCards, deck, pokemons);
                handCards = (LinkedList<String>) result.get(0);
                deck = (Stack<String>) result.get(1);
                pokemons = (LinkedList<String>) result.get(2);
                System.out.println("\n\n\n當前場上 : " + pokemons);
                System.out.println("當前手牌 : " + handCards);
            }

        }


    }


    /**
     * 計算起手率
     */
    private static void startWithBasePockmon() {
        init(DECK);
        if (deck == null) {
            return;
        }
        drawCards(7);
        if (handCards.contains("顫弦蠑螈v") || handCards.contains("破破袋") ||
                handCards.contains("垃垃藻") || handCards.contains("捷拉奧拉GX")) {
            has++;
        }
        System.out.println(1.0 * has / ++all);
    }

    /**
     * 初始化
     *
     * @return 牌組
     */
    private static void init(Map<String, Integer> map) {
        if (!vaild()) {
            return;
        }
        map2Stack(map);
        shuffle();
        for (int i = 0; i < 6; i++) {
            prizeCards.push(deck.pop());
        }
        System.out.println("獎勵卡 : " + prizeCards + "\n");
    }

    /**
     * 抽n張卡
     *
     * @param deck 牌組
     * @param num  抽牌數
     * @return 剩餘牌組
     */
    private static void drawCards(int num) {
        for (int i = 0; i < num; i++) {
            handCards.add(deck.pop());
        }
        System.out.println("當前手牌 : " + handCards);
    }


    /**
     * 洗牌
     *
     * @param deck 牌堆
     * @return 洗牌後的牌堆
     */
    private static void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * 跟據牌組構成生成60張牌
     *
     * @param map 牌組構成
     * @return 牌組
     */
    private static void map2Stack(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            for (int i = 0; i < e.getValue(); i++) {
                deck.push(e.getKey());
            }
        }
    }

    /**
     * 驗證卡組
     *
     * @return 是否合格
     */
    private static boolean vaild() {
        int size = 0;
        for (Map.Entry<String, Integer> e : DECK.entrySet()) {
            size += e.getValue();
        }
        return size == 60;
    }

}
