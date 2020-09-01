package priv.bobson.tools.enums;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

public enum CardEffectEnum {

    /**
     * pm
     */
    TOXTRICITY_V("顫弦蠑螈v", "") {
        @Override
        public List<Object> action(LinkedList<String> handCards, Stack<String> deck, LinkedList<String> pokemons) {
            return pokemonEffect(handCards, deck, pokemons);
        }
    },
    TOXTRICITY_VMAX("顫弦蠑螈vmax", "") {
        @Override
        public List<Object> action(LinkedList<String> handCards, Stack<String> deck, LinkedList<String> pokemons) {
            pokemons.remove("顫弦蠑螈v");
            return pokemonEffect(handCards, deck, pokemons);
        }
    },
    TRUBBISH("破破袋", "") {
        @Override
        public List<Object> action(LinkedList<String> handCards, Stack<String> deck, LinkedList<String> pokemons) {
            return pokemonEffect(handCards, deck, pokemons);
        }
    },
    GARBODOR("灰塵山", "") {
        @Override
        public List<Object> action(LinkedList<String> handCards, Stack<String> deck, LinkedList<String> pokemons) {
            pokemons.remove("破破袋");
            return pokemonEffect(handCards, deck, pokemons);
        }
    },
    SKRELP("垃垃藻", "") {
        @Override
        public List<Object> action(LinkedList<String> handCards, Stack<String> deck, LinkedList<String> pokemons) {
            return pokemonEffect(handCards, deck, pokemons);
        }
    },
    DRAGALGE("毒藻龍", "") {
        @Override
        public List<Object> action(LinkedList<String> handCards, Stack<String> deck, LinkedList<String> pokemons) {
            pokemons.remove("垃垃藻");
            return pokemonEffect(handCards, deck, pokemons);
        }
    },
    ZERAORA_GX("捷拉奧拉GX", "") {
        @Override
        public List<Object> action(LinkedList<String> handCards, Stack<String> deck, LinkedList<String> pokemons) {
            return pokemonEffect(handCards, deck, pokemons);
        }
    },

    /**
     * 物品
     */
    QUICK_BALL("先機球", "") {
        @Override
        public List<Object> action(LinkedList<String> handCards, Stack<String> deck, LinkedList<String> pokemons) {
            boolean isNotExist = true;
            while (isNotExist) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("棄一張手牌 : ");
                String inputString = scanner.nextLine();
                if (handCards.contains(inputString)) {
                    handCards.remove(this.getName());
                    handCards.remove(inputString);
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
                if (deck.contains(inputString)) {
                    deck.remove(inputString);
                    handCards.add(inputString);
                    Collections.shuffle(deck);
                    isNotExist = false;
                } else {
                    System.out.println(deck + "\n牌堆沒有此卡，請重新輸入");
                }
            }
            return returnAll(handCards, deck, pokemons);
        }
    },
    NEST_BALL("巢穴球", "") {
        @Override
        public List<Object> action(LinkedList<String> handCards, Stack<String> deck, LinkedList<String> pokemons) {
            boolean isNotExist = true;
            while (isNotExist) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("選擇一張牌庫的基礎PM : ");
                String inputString = scanner.nextLine();
                if (deck.contains(inputString)) {
                    handCards.remove(this.getName());
                    deck.remove(inputString);
                    pokemons.add(inputString);
                    Collections.shuffle(deck);
                    isNotExist = false;
                } else {
                    System.out.println(deck + "\n牌堆沒有此卡，請重新輸入");
                }
            }
            return returnAll(handCards, deck, pokemons);
        }
    },
    POKEMON_COMMUBICATION("通信", "") {
        @Override
        public List<Object> action(LinkedList<String> handCards, Stack<String> deck, LinkedList<String> pokemons) {
            boolean isNotExist = true;
            while (isNotExist) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("選擇手牌一張PM : ");
                String inputString = scanner.nextLine();
                if (handCards.contains(inputString)) {
                    handCards.remove(this.getName());
                    handCards.remove(inputString);
                    deck.push(inputString);
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
                if (deck.contains(inputString)) {
                    deck.remove(inputString);
                    handCards.add(inputString);
                    Collections.shuffle(deck);
                    isNotExist = false;
                } else {
                    System.out.println(deck + "\n牌堆沒有此卡，請重新輸入");
                }
            }
            return returnAll(handCards, deck, pokemons);
        }
    },
    EVOLUTION_INCENSE("薰香", "") {
        @Override
        public List<Object> action(LinkedList<String> handCards, Stack<String> deck, LinkedList<String> pokemons) {
            boolean isNotExist = true;
            while (isNotExist) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("選擇牌庫一張進化PM : ");
                String inputString = scanner.nextLine();
                if (deck.contains(inputString)) {
                    handCards.remove(this.getName());
                    deck.remove(inputString);
                    handCards.add(inputString);
                    Collections.shuffle(deck);
                    isNotExist = false;
                } else {
                    System.out.println(deck + "\n牌堆沒有此卡，請重新輸入");
                }
            }
            return returnAll(handCards, deck, pokemons);
        }
    },
    RESET_STAMP("印章", "") {
        @Override
        public List<Object> action(LinkedList<String> handCards, Stack<String> deck, LinkedList<String> pokemons) {
            handCards.remove(this.getName());
            return returnAll(handCards, deck, pokemons);
        }
    },
    FIELD_BLOWER("吹風機", "") {
        @Override
        public List<Object> action(LinkedList<String> handCards, Stack<String> deck, LinkedList<String> pokemons) {
            handCards.remove(this.getName());
            return returnAll(handCards, deck, pokemons);
        }
    },


    /**
     * 人物
     */
    PROFESSORS_RESEARCH("博士", "") {
        @Override
        public List<Object> action(LinkedList<String> handCards, Stack<String> deck, LinkedList<String> pokemons) {
            handCards.clear();
            for (int i = 0; i < 7; i++) {
                handCards.push(deck.pop());
            }
            return returnAll(handCards, deck, pokemons);
        }
    },
    CYNTHIA("竹蘭", "") {
        @Override
        public List<Object> action(LinkedList<String> handCards, Stack<String> deck, LinkedList<String> pokemons) {
            handCards.forEach(deck::push);
            handCards.clear();
            Collections.shuffle(deck);
            for (int i = 0; i < 6; i++) {
                handCards.push(deck.pop());
            }
            return returnAll(handCards, deck, pokemons);
        }
    },
    BIRDMAN("養鳥人", "") {
        @Override
        public List<Object> action(LinkedList<String> handCards, Stack<String> deck, LinkedList<String> pokemons) {
            for (int i = 0; i < 3; i++) {
                handCards.push(deck.pop());
            }
            handCards.remove(this.getName());
            return returnAll(handCards, deck, pokemons);
        }
    },
    BOSSS_ORDERS("老大", "") {
        @Override
        public List<Object> action(LinkedList<String> handCards, Stack<String> deck, LinkedList<String> pokemons) {
            handCards.remove(this.getName());
            return returnAll(handCards, deck, pokemons);
        }
    },


    /**
     * 能量
     */
    LIGBTNING_ENGERGY("電能", "") {
        @Override
        public List<Object> action(LinkedList<String> handCards, Stack<String> deck, LinkedList<String> pokemons) {
            return energyEffect(handCards, deck, pokemons);
        }
    },
    SPEED_L_ENERGY("高速電能", "") {
        @Override
        public List<Object> action(LinkedList<String> handCards, Stack<String> deck, LinkedList<String> pokemons) {
            boolean isNotExist = true;
            while (isNotExist) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("選擇場上一隻PM : ");
                String inputString = scanner.nextLine();
                if (pokemons.contains(inputString)) {
                    handCards.remove(this.getName());
                    pokemons.add(this.getName() + "〔" + inputString + "〕");
                    isNotExist = false;
                } else {
                    System.out.println(pokemons + "\n場上沒有此卡，請重新輸入");
                }
            }
            for (int i = 0; i < 2; i++) {
                handCards.add(deck.pop());
            }
            return returnAll(handCards, deck, pokemons);
        }
    },
    UNIT_ENERGY_LPM("單位能量", "") {
        @Override
        public List<Object> action(LinkedList<String> handCards, Stack<String> deck, LinkedList<String> pokemons) {
            return energyEffect(handCards, deck, pokemons);
        }
    },
    PSYCHIC_ENERGY("超能", "") {
        @Override
        public List<Object> action(LinkedList<String> handCards, Stack<String> deck, LinkedList<String> pokemons) {
            return energyEffect(handCards, deck, pokemons);
        }
    },


    /**
     * 場地
     */
    THUNDER_MOUNTAIN("雷霆山", "") {
        @Override
        public List<Object> action(LinkedList<String> handCards, Stack<String> deck, LinkedList<String> pokemons) {
            handCards.remove(this.getName());
            return returnAll(handCards, deck, pokemons);
        }
    },
    GALAR_MINE("礦山", "") {
        @Override
        public List<Object> action(LinkedList<String> handCards, Stack<String> deck, LinkedList<String> pokemons) {
            handCards.remove(this.getName());
            return returnAll(handCards, deck, pokemons);
        }
    },


    /**
     * 裝備
     */


    ;


    private String name;
    private String type;

    CardEffectEnum(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public List<Object> energyEffect(LinkedList<String> handCards, Stack<String> deck, LinkedList<String> pokemons) {
        boolean isNotExist = true;
        while (isNotExist) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("選擇場上一隻PM : ");
            String inputString = scanner.nextLine();
            if (pokemons.contains(inputString)) {
                handCards.remove(this.getName());
                pokemons.add(this.getName() + "〔" + inputString + "〕");
                isNotExist = false;
            } else {
                System.out.println(pokemons + "\n場上沒有此卡，請重新輸入");
            }
        }
        return returnAll(handCards, deck, pokemons);
    }

    public List<Object> pokemonEffect(LinkedList<String> handCards, Stack<String> deck, LinkedList<String> pokemons) {
        handCards.remove(this.getName());
        pokemons.add(this.getName());
        return returnAll(handCards, deck, pokemons);
    }

    public List<Object> action(LinkedList<String> handCards, Stack<String> deck, LinkedList<String> pokemons) {
        return null;
    }

    public List<Object> returnAll(LinkedList<String> handCards, Stack<String> deck, LinkedList<String> pokemons) {
        return new ArrayList() {
            {
                this.add(handCards);
                this.add(deck);
                this.add(pokemons);
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
}
