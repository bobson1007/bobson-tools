package priv.bobson.tools.controller;

import priv.bobson.tools.enums.CardEffectEnum;

import java.util.*;

public class AutoPtcgDeckController {

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
    /* 手牌歷史 */
    private static LinkedList<LinkedList<CardEffectEnum>> handCardsHistory = new LinkedList<LinkedList<CardEffectEnum>>();

    /**
     * 每回合提示
     */
    static int round = 1;
    static boolean isFirstEnergy = false;
    static boolean isUsedSupporter = false;
    static String area = "無";

    /**
     * 是否有該PM
     */
    static boolean hasToxtricityV = false;
    static boolean hasToxtricityVMax = false;
    static boolean hasTrubbish = false;
    static boolean hasGarbodor = false;
    static boolean hasSkerlp = false;
    static boolean hasDragalge = false;
    static boolean hasZeraoraGX = false;

    /**
     * 能量數量
     */
    static int numOfLigbtningEnergy = 0;
    static int numOfPsychicEnergy = 0;


    /**
     * 分析用
     */
    static int all = 0;
    static int has = 0;
    static int[] counts = new int[60];


    static {
        //pm - 17  (備用 : 蠑螈一組，破破袋一組)
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

        //物品 - 16 (備用 : 先機球x1，交替x2，印章x1)
        DECK.put("先機球", 3);
        DECK.put("巢穴球", 4);
        DECK.put("通信", 2);
        DECK.put("薰香", 2);
        DECK.put("寶可夢捕捉器", 4);
        DECK.put("吹風機", 1);

        //裝備 - 1 (備用 : 毒針)
        DECK.put("反擊增幅器", 1);

        //人物 - 12 (備用 : 養鳥人x2，瑪俐x2，老大x1 )
        DECK.put("博士", 4);
        DECK.put("竹蘭", 4);
        DECK.put("瑪俐", 2);
        DECK.put("老大", 2);

        //能量 - 11 (備用 : 普電x5，極光x1 )
        DECK.put("高速電能", 4);
        DECK.put("單位能量", 4);
        DECK.put("超能", 3);
    }


    /**
     * 自動化
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            test4Loop();

            prizeCards = new Stack<>();
            deck = new Stack<>();
            discardPile = new Stack<>();
            handCards = new LinkedList<>();
            pokemons = new LinkedList<>();
            hasTrubbish = false;
            hasGarbodor = false;
            round = 1;
            isFirstEnergy = false;
            isUsedSupporter = false;
        }
        System.out.println("\n\n" + counts);
        printResult();


        //==============================================================
        //測試起手率
//        int total = 10000;
//        int[] array = new int[60];
//        for (int i = 0; i < total; i++) {
//            int count = startWithBasePokemon();
//            array[count]++;
//            prizeCards = new Stack<>();
//            deck = new Stack<>();
//            discardPile = new Stack<>();
//            handCards = new LinkedList<>();
//            pokemons = new LinkedList<>();
//        }
//        for (int i = 1; i < 11; i++) {
//            System.out.println("第" + i + "次起手才有基礎PM的機率:" + 1.0 * array[i] / total * 100 + "%");
//        }
    }

    private static void printResult() {
        for (int i = 0; i < counts.length; i++) {
            System.out.println("需要第_" + i + "_回合能做場成功的機率:" + 1.0 * counts[i] / 100000 * 100 + "%");
        }
    }


    public static void test4Loop() {
        startWithBasePokemon();
        handCardsHistory.add(0, new LinkedList<>());
        boolean canUseGarbodor = false;
        boolean canUseDragalge = false;
        boolean hasEnergy = false;
        while (!(hasGarbodor && hasDragalge && hasEnergy) && round < 30) {
            try {
                handCardsHistory.add(round, handCards);

                hasGarbodor = usePM1(canUseGarbodor, CardEffectEnum.TRUBBISH, CardEffectEnum.GARBODOR) || hasGarbodor;
                hasDragalge = usePM1(canUseDragalge, CardEffectEnum.SKRELP, CardEffectEnum.DRAGALGE) || hasDragalge;
                boolean b1 = useTrubbish();
                boolean b2 = useSkrelp();
                hasEnergy = setEnetgy(hasEnergy);
                useSupporter();
                hasGarbodor = usePM1(canUseGarbodor, CardEffectEnum.TRUBBISH, CardEffectEnum.GARBODOR) || hasGarbodor;
                hasDragalge = usePM1(canUseDragalge, CardEffectEnum.SKRELP, CardEffectEnum.DRAGALGE) || hasDragalge;
                canUseGarbodor = useTrubbish() || b1 || canUseGarbodor;
                canUseDragalge = useSkrelp() || b2 || canUseDragalge;
                hasEnergy = setEnetgy(hasEnergy);

                System.out.println("回合:" + round + " 場上:" + pokemons);
                round++;
                drawCards(1);
            } catch (Exception e) {
                System.out.println("沒牌咯");
            }
        }
        counts[round - 1]++;
    }


    private static boolean setEnetgy(boolean hasEnergy) {
        if (hasEnergy) {
            return true;
        } else {
            if (hasSkerlp) {
                if (handCards.contains(CardEffectEnum.PSYCHIC_ENERGY)) {
                    handCards.remove(CardEffectEnum.PSYCHIC_ENERGY);
                    return true;
                } else if (handCards.contains(CardEffectEnum.UNIT_ENERGY_LPM)) {
                    handCards.remove(CardEffectEnum.UNIT_ENERGY_LPM);
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
    }


    private static void useSupporter() {
        if (!isUsedSupporter) {
            List<Object> action = new ArrayList<>();
            if (handCards.contains(CardEffectEnum.PROFESSORS_RESEARCH)) {
                action = CardEffectEnum.PROFESSORS_RESEARCH.action(handCards, deck, pokemons, energys);
                System.out.println("使用博士，新手牌 : " + handCards);
            } else if (handCards.contains(CardEffectEnum.CYNTHIA)) {
                action = CardEffectEnum.CYNTHIA.action(handCards, deck, pokemons, energys);
                System.out.println("使用竹蘭，新手牌 : " + handCards);
            } else if (handCards.contains(CardEffectEnum.BIRDMAN)) {
                action = CardEffectEnum.BIRDMAN.action(handCards, deck, pokemons, energys);
                System.out.println("使用養鳥人，新手牌 : " + handCards);
            }
            if (action.size() > 0) {
                handCards = (LinkedList<CardEffectEnum>) action.get(0);
                deck = (Stack<CardEffectEnum>) action.get(1);
                pokemons = (LinkedList<CardEffectEnum>) action.get(2);
                energys = (LinkedList<List<CardEffectEnum>>) action.get(3);
            }
        }
    }


    private static void useGarbodor(boolean canUsedGarbodor) {
        // 是否可以下灰塵山
        if ((pokemons.contains(CardEffectEnum.TRUBBISH) && (canUsedGarbodor)) && handCards.contains(CardEffectEnum.GARBODOR)) {
            handCards.remove(CardEffectEnum.GARBODOR);
            pokemons.add(CardEffectEnum.GARBODOR);
            hasGarbodor = true;
            System.out.println("使用手牌的灰塵山");
        } else if (canUsedGarbodor && handCards.contains(CardEffectEnum.EVOLUTION_INCENSE)) {
            handCards.remove(CardEffectEnum.EVOLUTION_INCENSE);
            pokemons.add(CardEffectEnum.GARBODOR);
            hasGarbodor = true;
            System.out.println("使用薰香找灰塵山");
        } else if (canUsedGarbodor && handCards.contains(CardEffectEnum.POKEMON_COMMUBICATION)) {
            handCards.remove(CardEffectEnum.POKEMON_COMMUBICATION);
            pokemons.add(CardEffectEnum.GARBODOR);
            hasGarbodor = true;
            System.out.println("使用通信找灰塵山");
        }
    }

    private static boolean usePM1(boolean canUsedPM1, CardEffectEnum pm0, CardEffectEnum pm1) {
        // 是否可以下灰塵山
        if ((pokemons.contains(pm0) && (canUsedPM1)) && handCards.contains(pm1)) {
            handCards.remove(pm1);
            pokemons.add(pm1);
            return true;
//            System.out.println("使用手牌的灰塵山");
        } else if (canUsedPM1 && handCards.contains(CardEffectEnum.EVOLUTION_INCENSE)) {
            handCards.remove(CardEffectEnum.EVOLUTION_INCENSE);
            pokemons.add(pm1);
            return true;
//            System.out.println("使用薰香找灰塵山");
        } else if (canUsedPM1 && handCards.contains(CardEffectEnum.POKEMON_COMMUBICATION)) {
            handCards.remove(CardEffectEnum.POKEMON_COMMUBICATION);
            pokemons.add(pm1);
            return true;
//            System.out.println("使用通信找灰塵山");
        } else {
            return false;
        }
    }

    private static boolean useSkrelp() {
        boolean canUsedDragalge = false;
        // 場上沒有破破袋及灰塵山
        if (!((pokemons.contains(CardEffectEnum.SKRELP) || pokemons.contains(CardEffectEnum.DRAGALGE)))
                && handCards.contains(CardEffectEnum.SKRELP)) {
            hasSkerlp = true;
            handCards.remove(CardEffectEnum.SKRELP);
            pokemons.add(CardEffectEnum.SKRELP);
            canUsedDragalge = true;
            System.out.println("使用手牌的垃垃藻");
        } else if ((!hasSkerlp) && handCards.contains(CardEffectEnum.NEST_BALL)) {
            hasSkerlp = true;
            handCards.remove(CardEffectEnum.NEST_BALL);
            pokemons.add(CardEffectEnum.SKRELP);
            canUsedDragalge = true;
            System.out.println("使用巢穴球找垃垃藻");
        } else if ((!hasSkerlp) && handCards.contains(CardEffectEnum.QUICK_BALL)) {
            hasSkerlp = true;
            handCards.remove(CardEffectEnum.QUICK_BALL);
            pokemons.add(CardEffectEnum.SKRELP);
            canUsedDragalge = true;
            System.out.println("使用先機球找垃垃藻");
        }
        return canUsedDragalge;
    }

    private static boolean useTrubbish() {
        boolean canUsedGarbodor = false;
        // 場上沒有破破袋及灰塵山
        if (!((pokemons.contains(CardEffectEnum.TRUBBISH) || pokemons.contains(CardEffectEnum.GARBODOR)))
                && handCards.contains(CardEffectEnum.TRUBBISH)) {
            hasTrubbish = true;
            handCards.remove(CardEffectEnum.TRUBBISH);
            pokemons.add(CardEffectEnum.TRUBBISH);
            canUsedGarbodor = true;
            System.out.println("使用手牌的破破袋");
        } else if ((!hasTrubbish) && handCards.contains(CardEffectEnum.NEST_BALL)) {
            hasTrubbish = true;
            handCards.remove(CardEffectEnum.NEST_BALL);
            pokemons.add(CardEffectEnum.TRUBBISH);
            canUsedGarbodor = true;
            System.out.println("使用巢穴球找破破袋");
        } else if ((!hasTrubbish) && handCards.contains(CardEffectEnum.QUICK_BALL)) {
            hasTrubbish = true;
            handCards.remove(CardEffectEnum.QUICK_BALL);
            pokemons.add(CardEffectEnum.TRUBBISH);
            canUsedGarbodor = true;
            System.out.println("使用先機球找破破袋");
        }
        return canUsedGarbodor;
    }


    /**
     * 手牌若無基礎PM則重洗
     */
    private static int startWithBasePokemon() {
        int count = 0;
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
                    return 0;
                }
                drawCards(7);
            }
            count++;
        }
        return count-1;
    }

    /**
     * 檢查使用的牌是否符合規則
     *
     * @return 是否可以使用
     */
    private static void ruleCheck() {
        while (deck.size() > 0) {
            sortHandCards();
        }
    }

    private static void sortHandCards() {
        handCards.sort(new Comparator<CardEffectEnum>() {
            @Override
            public int compare(CardEffectEnum o1, CardEffectEnum o2) {
                return o1.getType().charAt(0) - o2.getType().charAt(0);
            }
        });
        System.out.println("排序後 =======> " + handCards);
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
