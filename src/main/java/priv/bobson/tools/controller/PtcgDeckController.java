package priv.bobson.tools.controller;

import priv.bobson.tools.enums.CardEffectEnum;

import java.util.*;

public class PtcgDeckController {

    /* 卡組 */
    private final static Map<String, Integer> DECK = new HashMap<String, Integer>();
    /* 卡組指針 */
    private static int point = 0;

    /* 獎勵卡 */
    private static Stack<CardEffectEnum> prizeCards = new Stack<>();
    /* 牌堆 */
    private static Stack<CardEffectEnum> deck = new Stack<>();
    /* 棄牌堆 */
    private static Stack<CardEffectEnum> discardPile = new Stack<>();
    /* 手牌 */
    private static LinkedList<CardEffectEnum> handCards = new LinkedList<>();
    /* 場上所有pm */
    private static LinkedList<CardEffectEnum> pokemons = new LinkedList<>();
    /* 能量 */
    private static LinkedList<List<CardEffectEnum>> energys = new LinkedList<>();


    static int round = 1;
    static boolean isFirstEnergy = false;
    static boolean isUsedSupporter = false;
    static String area = "無";


    static int all = 0;
    static int has = 0;


    static {
        //pm - 19
        DECK.put("顫弦蠑螈v", 2);
        DECK.put("顫弦蠑螈vmax", 2);
        DECK.put("破破袋", 2);
        DECK.put("灰塵山", 2);
        DECK.put("垃垃藻", 4);
        DECK.put("毒藻龍", 4);
        DECK.put("捷拉奧拉GX", 1);

        //場地 - 3
        DECK.put("雷霆山", 1);
        DECK.put("礦山", 2);

        //物品 - 17
        DECK.put("先機球", 3);
        DECK.put("巢穴球", 4);
        DECK.put("通信", 2);
        DECK.put("薰香", 2);
        DECK.put("寶可夢捕捉器", 4);
        DECK.put("印章", 1);
        DECK.put("吹風機", 1);

        //裝備

        //人物 - 12
        DECK.put("博士", 4);
        DECK.put("竹蘭", 4);
        DECK.put("瑪俐", 2);
        DECK.put("老大", 2);

        //能量 - 11
        DECK.put("高速電能", 4);
        DECK.put("單位能量", 4);
        DECK.put("超能", 3);
    }

    /**
     * 手動模擬出牌流程
     * @param args
     */
    public static void main(String[] args) {
        boolean needRestart = true;
        while (needRestart) {
            if (handCards.stream().anyMatch(e -> "1-PM-0".equals(e.getType()))) {
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

        while (deck.size() > 0) {
            System.out.println("\n【第" + round + "回合】 - 首填:" + isFirstEnergy + "  支援者:" + isUsedSupporter
                    + "  場地:" + area);
            Scanner scanner = new Scanner(System.in);
            System.out.print("使用手牌 : ");
            String inputString = scanner.nextLine();
            if ("exit".equals(inputString)) {
                System.out.println("測試結束");
                return;
            } else if ("n".equals(inputString)) {
                round++;
                isFirstEnergy = false;
                isUsedSupporter = false;
                System.out.println("==========================================================");
                System.out.println("\n當前場上 : " + pokemons);
                System.out.println("場上能量 : " + energys);
                drawCards(1);
                continue;
            } else if (inputString.contains("能")) {
                isFirstEnergy = true;
            } else if ("竹蘭".equals(inputString) || "老大".equals(inputString)
                    || "博士".equals(inputString) || "養鳥人".equals(inputString)) {
                isUsedSupporter = true;
            } else if ("雷霆山".equals(inputString) || "礦山".equals(inputString)) {
                area = inputString;
            }


            CardEffectEnum cee = CardEffectEnum.getByName(inputString);
            if (cee == null) {
                System.out.println("手牌沒有此卡，請重新輸入");
                System.out.println("==========================================================");
                System.out.println("\n當前場上 : " + pokemons);
                System.out.println("場上能量 : " + energys);
                System.out.println("當前手牌 : " + handCards);
            } else {
                List<Object> result = cee.action(handCards, deck, pokemons, energys);
                handCards = (LinkedList<CardEffectEnum>) result.get(0);
                deck = (Stack<CardEffectEnum>) result.get(1);
                pokemons = (LinkedList<CardEffectEnum>) result.get(2);
                energys = (LinkedList<List<CardEffectEnum>>) result.get(3);
                System.out.println("==========================================================");
                System.out.println("\n當前場上 : " + pokemons);
                System.out.println("場上能量 : " + energys);
                System.out.println("當前手牌 : " + handCards);
            }

        }
    }

    /**
     * 檢查使用的牌是否符合規則
     *
     * @param inputString 鍵盤輸入使用的牌
     * @return 是否可以使用
     */
    private static boolean ruleCheck(String inputString) {
        LinkedList<CardEffectEnum> handCards = PtcgDeckController.handCards;

        handCards.sort(new Comparator<CardEffectEnum>() {
            @Override
            public int compare(CardEffectEnum o1, CardEffectEnum o2) {
                return o1.getType().charAt(0) - o2.getType().charAt(0);
            }
        });
        System.out.println("=======>" + handCards);
        return true;
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
        System.out.println("獎勵卡 : " + prizeCards);
    }

    /**
     * 抽n張卡
     *
     * @param num 抽牌數
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
                deck.push(CardEffectEnum.getByName(e.getKey()));
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
