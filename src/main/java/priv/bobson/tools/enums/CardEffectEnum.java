package priv.bobson.tools.enums;

import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public enum CardEffectEnum {

    /**
     * pm
     */
    TOXTRICITY_V("顫弦蠑螈v", "1-PM-0") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            pokemons.add(this);
            energys.add(new ArrayList<>());
            return pokemonEffect(handCards, deck, pokemons, energys);
        }
    },
    TOXTRICITY_VMAX("顫弦蠑螈vmax", "3-PM-1") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            for (int i = 0; i < pokemons.size(); i++) {
                if ("顫弦蠑螈v".equals(pokemons.get(i).getName())) {
                    pokemons.remove(i);
                    pokemons.add(i, this);
                    break;
                }
            }
            return pokemonEffect(handCards, deck, pokemons, energys);
        }
    },
    TRUBBISH("破破袋", "1-PM-0") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            pokemons.add(this);
            energys.add(new ArrayList<>());
            return pokemonEffect(handCards, deck, pokemons, energys);
        }
    },
    GARBODOR("灰塵山", "3-PM-1") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            for (int i = 0; i < pokemons.size(); i++) {
                if ("破破袋".equals(pokemons.get(i).getName())) {
                    pokemons.remove(i);
                    pokemons.add(i, this);
                    break;
                }
            }
            return pokemonEffect(handCards, deck, pokemons, energys);
        }
    },
    SKRELP("垃垃藻", "1-PM-0") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            pokemons.add(this);
            energys.add(new ArrayList<>());
            return pokemonEffect(handCards, deck, pokemons, energys);
        }
    },
    DRAGALGE("毒藻龍", "3-PM-1") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            for (int i = 0; i < pokemons.size(); i++) {
                if ("垃垃藻".equals(pokemons.get(i).getName())) {
                    pokemons.remove(i);
                    pokemons.add(i, this);
                    break;
                }
            }
            return pokemonEffect(handCards, deck, pokemons, energys);
        }
    },
    ZERAORA_GX("捷拉奧拉GX", "1-PM-0") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            pokemons.add(this);
            energys.add(new ArrayList<>());
            return pokemonEffect(handCards, deck, pokemons, energys);
        }
    },
    TYPE_NULL("屬性空", "1-PM-0") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            pokemons.add(this);
            energys.add(new ArrayList<>());
            return pokemonEffect(handCards, deck, pokemons, energys);
        }
    },
    SILVALLY_GX("銀伴戰獸GX", "3-PM-1") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            for (int i = 0; i < pokemons.size(); i++) {
                if ("屬性空".equals(pokemons.get(i).getName())) {
                    pokemons.remove(i);
                    pokemons.add(i, this);
                    break;
                }
            }
            return pokemonEffect(handCards, deck, pokemons, energys);
        }
    },
    SLOWBRO_V("呆殼獸v", "1-PM-0") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            pokemons.add(this);
            energys.add(new ArrayList<>());
            return pokemonEffect(handCards, deck, pokemons, energys);
        }
    },
    BOLTUND_V("逐電犬v", "1-PM-0") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            pokemons.add(this);
            energys.add(new ArrayList<>());
            return pokemonEffect(handCards, deck, pokemons, energys);
        }
    },
    ORICORIO_GX("花舞鳥GX", "1-PM-0") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            pokemons.add(this);
            energys.add(new ArrayList<>());
            return pokemonEffect(handCards, deck, pokemons, energys);
        }
    },
    RAIKOU_AR("雷公ar", "1-PM-0") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            pokemons.add(this);
            energys.add(new ArrayList<>());
            return pokemonEffect(handCards, deck, pokemons, energys);
        }
    },
    JIRACHI("基拉祈", "1-PM-0") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            pokemons.add(this);
            energys.add(new ArrayList<>());
            return pokemonEffect(handCards, deck, pokemons, energys);
        }
    },
    PORYGON("多邊獸", "1-PM-0") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            pokemons.add(this);
            energys.add(new ArrayList<>());
            return pokemonEffect(handCards, deck, pokemons, energys);
        }
    },
    PORYGON_ZAP("多邊獸z", "3-PM-1") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            for (int i = 0; i < pokemons.size(); i++) {
                if ("多邊獸".equals(pokemons.get(i).getName())) {
                    pokemons.remove(i);
                    pokemons.add(i, this);
                    break;
                }
            }
            return pokemonEffect(handCards, deck, pokemons, energys);
        }
    },



    /**
     * 物品
     */
    QUICK_BALL("先機球", "2-物品") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            boolean isNotExist = true;
            while (isNotExist) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("棄一張手牌 : ");
                String inputString = scanner.nextLine();
                if (handCards.contains(CardEffectEnum.getByName(inputString))) {
                    handCards.remove(CardEffectEnum.getByName(this.getName()));
                    handCards.remove(CardEffectEnum.getByName(inputString));
                    isNotExist = false;
                } else {
                    System.out.println(handCards + "\n手牌沒有此卡，請重新輸入");
                }
            }

            isNotExist = true;
            while (isNotExist) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("選擇一張基礎PM : ");
                String inputString = scanner.nextLine();
                if (deck.contains(CardEffectEnum.getByName(inputString))) {
                    deck.remove(CardEffectEnum.getByName(inputString));
                    handCards.add(CardEffectEnum.getByName(inputString));
                    Collections.shuffle(deck);
                    isNotExist = false;
                } else {
                    System.out.println(deck + "\n牌堆沒有此卡，請重新輸入");
                }
            }
            return returnAll(handCards, deck, pokemons, energys);
        }
    },
    NEST_BALL("巢穴球", "2-物品") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            boolean isNotExist = true;
            while (isNotExist) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("選擇一張牌庫的基礎PM : ");
                String inputString = scanner.nextLine();
                if (deck.contains(CardEffectEnum.getByName(inputString))) {
                    handCards.remove(CardEffectEnum.getByName(this.getName()));
                    deck.remove(CardEffectEnum.getByName(inputString));
                    pokemons.add(CardEffectEnum.getByName(inputString));
                    energys.add(new ArrayList<>());
                    Collections.shuffle(deck);
                    isNotExist = false;
                } else {
                    System.out.println(deck + "\n牌堆沒有此卡，請重新輸入");
                }
            }
            return returnAll(handCards, deck, pokemons, energys);
        }
    },
    POKEMON_COMMUBICATION("通信", "2-物品") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            boolean isNotExist = true;
            while (isNotExist) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("選擇手牌一張PM : ");
                String inputString = scanner.nextLine();
                if (handCards.contains(CardEffectEnum.getByName(inputString))) {
                    handCards.remove(CardEffectEnum.getByName(inputString));
                    deck.push(CardEffectEnum.getByName(inputString));
                    isNotExist = false;
                } else {
                    System.out.println(handCards + "\n手牌沒有此卡，請重新輸入");
                }
            }

            isNotExist = true;
            while (isNotExist) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("選擇牌庫一張PM : ");
                String inputString = scanner.nextLine();
                if (deck.contains(CardEffectEnum.getByName(inputString))) {
                    deck.remove(CardEffectEnum.getByName(inputString));
                    handCards.add(CardEffectEnum.getByName(inputString));
                    Collections.shuffle(deck);
                    isNotExist = false;
                } else {
                    System.out.println(deck + "\n牌堆沒有此卡，請重新輸入");
                }
            }
            return returnAll(handCards, deck, pokemons, energys);
        }
    },
    EVOLUTION_INCENSE("薰香", "2-物品") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            boolean isNotExist = true;
            while (isNotExist) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("選擇牌庫一張進化PM : ");
                String inputString = scanner.nextLine();
                if (deck.contains(CardEffectEnum.getByName(inputString))) {
                    handCards.remove(CardEffectEnum.getByName(this.getName()));
                    deck.remove(CardEffectEnum.getByName(inputString));
                    handCards.add(CardEffectEnum.getByName(inputString));
                    Collections.shuffle(deck);
                    isNotExist = false;
                } else {
                    System.out.println(deck + "\n牌堆沒有此卡，請重新輸入");
                }
            }
            return returnAll(handCards, deck, pokemons, energys);
        }
    },
    RESET_STAMP("印章", "2-物品") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            handCards.remove(CardEffectEnum.getByName(this.getName()));
            return returnAll(handCards, deck, pokemons, energys);
        }
    },
    FIELD_BLOWER("吹風機", "2-物品") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            handCards.remove(CardEffectEnum.getByName(this.getName()));
            return returnAll(handCards, deck, pokemons, energys);
        }
    },
    POKEMON_CATCHER("寶可夢捕捉器", "2-物品") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            handCards.remove(CardEffectEnum.getByName(this.getName()));
            return returnAll(handCards, deck, pokemons, energys);
        }
    },
    ELECTROCHARGER("電氣充電器", "2-物品") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            handCards.remove(CardEffectEnum.getByName(this.getName()));
            return returnAll(handCards, deck, pokemons, energys);
        }
    },
    ELECTROPOWER("電氣力量", "2-物品") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            handCards.remove(CardEffectEnum.getByName(this.getName()));
            return returnAll(handCards, deck, pokemons, energys);
        }
    },
    SWITCH("交替", "2-物品") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            handCards.remove(CardEffectEnum.getByName(this.getName()));
            return returnAll(handCards, deck, pokemons, energys);
        }
    },
    RARE_CANDY("神奇糖果", "2-物品") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            handCards.remove(CardEffectEnum.getByName(this.getName()));
            return returnAll(handCards, deck, pokemons, energys);
        }
    },

    /**
     * 人物
     */
    PROFESSORS_RESEARCH("博士", "7-人物") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            handCards.remove(CardEffectEnum.getByName(this.getName()));
            handCards.clear();
            for (int i = 0; i < 7; i++) {
                handCards.push(deck.pop());
            }
            return returnAll(handCards, deck, pokemons, energys);
        }
    },
    CYNTHIA("竹蘭", "7-人物") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            handCards.remove(CardEffectEnum.getByName(this.getName()));
            handCards.forEach(deck::push);
            handCards.clear();
            Collections.shuffle(deck);
            for (int i = 0; i < 6; i++) {
                handCards.push(deck.pop());
            }
            return returnAll(handCards, deck, pokemons, energys);
        }
    },
    BIRDMAN("養鳥人", "7-人物") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            handCards.remove(CardEffectEnum.getByName(this.getName()));
            for (int i = 0; i < 3; i++) {
                handCards.push(deck.pop());
            }
            return returnAll(handCards, deck, pokemons, energys);
        }
    },
    BOSSS_ORDERS("老大", "7-人物") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            handCards.remove(CardEffectEnum.getByName(this.getName()));
            return returnAll(handCards, deck, pokemons, energys);
        }
    },
    ROSE("洛茲", "7-人物") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            handCards.clear();
            return returnAll(handCards, deck, pokemons, energys);
        }
    },
    MARNIE("瑪俐", "7-人物") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            handCards.remove(CardEffectEnum.getByName(this.getName()));
            Stack<CardEffectEnum> stack = new Stack<>();
            handCards.forEach(stack::push);
            deck.forEach(stack::push);
            deck.clear();
            handCards.clear();
            stack.forEach(deck::push);
            for (int i = 0; i < 5; i++) {
                handCards.push(deck.pop());
            }
            return returnAll(handCards, deck, pokemons, energys);
        }
    },


    /**
     * 能量
     */
    LIGBTNING_ENGERGY("電能", "6-能量") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            return energyEffect(handCards, deck, pokemons, energys);
        }
    },
    SPEED_L_ENERGY("高速電能", "6-能量") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            boolean isNotExist = true;
            while (isNotExist) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("選擇場上一隻PM : ");
                for (int i = 0; i < pokemons.size(); i++) {
                    System.out.print(i + "-" + pokemons.get(i).getName() + " ");
                }
                System.out.print("\n輸入序號 : ");
                int inputInteger = Integer.parseInt(scanner.nextLine());
                if (inputInteger < pokemons.size()) {
                    handCards.remove(CardEffectEnum.getByName(this.getName()));
                    energys.get(inputInteger).add(CardEffectEnum.getByName(this.getName()));
                    isNotExist = false;
                } else {
                    System.out.println(pokemons + "\n場上沒有此卡，請重新輸入");
                }
            }
            for (int i = 0; i < 2; i++) {
                handCards.add(deck.pop());
            }
            return returnAll(handCards, deck, pokemons, energys);
        }
    },
    UNIT_ENERGY_LPM("單位能量", "6-能量") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            return energyEffect(handCards, deck, pokemons, energys);
        }
    },
    PSYCHIC_ENERGY("超能", "6-能量") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            return energyEffect(handCards, deck, pokemons, energys);
        }
    },
    AURORA_ENERGY("極光能量", "6-能量") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            boolean isNotExist = true;
            while (isNotExist) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("棄一張手牌 : ");
                String inputString = scanner.nextLine();
                if (handCards.contains(CardEffectEnum.getByName(inputString))) {
                    handCards.remove(CardEffectEnum.getByName(this.getName()));
                    isNotExist = false;
                } else {
                    System.out.println(handCards + "\n手牌沒有此卡，請重新輸入");
                }
            }
            return energyEffect(handCards, deck, pokemons, energys);
        }
    },
    GRASS_ENGERGY("草能", "6-能量") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            return energyEffect(handCards, deck, pokemons, energys);
        }
    },
    METAL_ENGERGY("鋼能", "6-能量") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            return energyEffect(handCards, deck, pokemons, energys);
        }
    },


    /**
     * 場地
     */
    THUNDER_MOUNTAIN("雷霆山", "0-場地") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            handCards.remove(CardEffectEnum.getByName(this.getName()));
            return returnAll(handCards, deck, pokemons, energys);
        }
    },
    GALAR_MINE("礦山", "0-場地") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            handCards.remove(CardEffectEnum.getByName(this.getName()));
            return returnAll(handCards, deck, pokemons, energys);
        }
    },


    /**
     * 裝備
     */
    COUNTER_GAIN("反擊增幅器","5-裝備"){
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            handCards.remove(CardEffectEnum.getByName(this.getName()));
            return returnAll(handCards, deck, pokemons, energys);
        }
    },
    EAR_RINGING_BELL("耳鳴鈴鐺","5-裝備"){
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            handCards.remove(CardEffectEnum.getByName(this.getName()));
            return returnAll(handCards, deck, pokemons, energys);
        }
    },
    ESCAPE_BOARD("逃脫滑板","5-裝備"){
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
            handCards.remove(CardEffectEnum.getByName(this.getName()));
            return returnAll(handCards, deck, pokemons, energys);
        }
    },


    ;
    private String name;
    private String type;


    CardEffectEnum(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public List<Object> energyEffect(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
        boolean isNotExist = true;
        while (isNotExist) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("選擇場上一隻PM : ");
            for (int i = 0; i < pokemons.size(); i++) {
                System.out.print(i + "-" + pokemons.get(i).getName() + " ");
            }
            System.out.print("\n輸入序號 : ");
            int inputInteger = Integer.parseInt(scanner.nextLine());
            if (inputInteger < pokemons.size()) {
                handCards.remove(CardEffectEnum.getByName(this.getName()));
                energys.get(inputInteger).add(CardEffectEnum.getByName(this.getName()));
                isNotExist = false;
            } else {
                System.out.println(pokemons + "\n場上沒有此卡，請重新輸入");
            }
        }
        return returnAll(handCards, deck, pokemons, energys);
    }

    public List<Object> pokemonEffect(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
        handCards.remove(CardEffectEnum.getByName(this.getName()));
        return returnAll(handCards, deck, pokemons, energys);
    }

    public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
        return null;
    }

    public List<Object> returnAll(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
        return new ArrayList() {
            {
                this.add(handCards);
                this.add(deck);
                this.add(pokemons);
                this.add(energys);
            }
        };
    }

    public static CardEffectEnum getByName(String name) {
        List<CardEffectEnum> list = Arrays.stream(CardEffectEnum.values()).filter(e -> e.getName().equals(name)).collect(Collectors.toList());
        return list.size() == 0 ? null : list.get(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.getName();
    }


}

