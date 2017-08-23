package cl.scrapp.beans;

import cl.scrapp.enums.CardValue;
import cl.scrapp.enums.Suit;
import org.apache.commons.lang.math.NumberUtils;
import org.codehaus.jackson.JsonNode;

import java.util.List;

public class Card implements Comparable {
    private Suit suit;
    private CardValue number;

    public Card(final Suit suit, final CardValue number) {
        this.suit = suit;
        this.number = number;
    }

    public Card(final JsonNode node) {
        String suit = node.get("suit").asText();
        String number = node.get("number").asText();
        this.suit = Suit.fromDisplay(suit);
        this.number = CardValue.fromDisplay(number);
    }

    public Suit getSuit() {
        return suit;
    }

    public CardValue getNumber() {
        return number;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        } else {
            Card card = (Card) obj;
            return suit == card.getSuit() && number == card.getNumber();
        }
    }

    @Override
    public String toString() {
        return String.format("%s-%s", number.getDisplay(), suit.getDisplay());
    }

    @Override
    public int compareTo(Object obj) {
        if (obj == null) {
            return 1;
        } else {
            Card card = (Card) obj;
            if (number == card.getNumber() && suit == card.getSuit()) {
                return 0;
            }
            int compare = NumberUtils.compare(number.getNumber(), card.getNumber().getNumber());
            if (compare != 0) {
                return compare;
            } else {
                if (suit == null) {
                    if (card.getSuit() != null) {
                        return -1;
                    } else {
                        return 0;
                    }
                } else {
                    if (card.getSuit() == null) {
                        return 1;
                    }
                    return NumberUtils.compare(suit.getOrder(), card.getSuit().getOrder());
                }
            }
        }
    }

    public static Card getHighCardValue(List<Card> cards) {
        Card highCard = null;
        for (Card card : cards) {
            if (card == null || card.getNumber() == null) {
                continue;
            } else if (highCard == null) {
                highCard = card;
            } else if (card.getNumber().getValue() > highCard.getNumber().getValue()) {
                highCard = card;
            }
        }
        return highCard;
    }
}
