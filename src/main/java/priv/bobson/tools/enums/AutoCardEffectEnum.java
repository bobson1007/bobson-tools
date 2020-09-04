package priv.bobson.tools.enums;

import java.util.*;

public enum AutoCardEffectEnum {

    /**
     * 效果
     */
    PROFESSORS_RESEARCH("博士", "7-人物") {
        @Override
        public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
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
            for (int i = 0; i < 3; i++) {
                handCards.push(deck.pop());
            }
            handCards.remove(CardEffectEnum.getByName(this.getName()));
            return returnAll(handCards, deck, pokemons, energys);
        }
    },
    ;


    private String name;
    private String type;

    AutoCardEffectEnum(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public List<Object> action(LinkedList<CardEffectEnum> handCards, Stack<CardEffectEnum> deck, LinkedList<CardEffectEnum> pokemons, LinkedList<List<CardEffectEnum>> energys) {
        return null;
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
}
