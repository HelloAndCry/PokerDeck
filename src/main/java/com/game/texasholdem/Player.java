package com.game.texasholdem;

import com.game.texasholdem.comparing.ComparingFacade;
import com.game.texasholdem.comparing.IComparing;
import com.game.texasholdem.ranking.RankingResult;

import java.util.*;


public class Player implements Comparable<Player> {

    private List<Card> cards;
    private RankingResult rankingResult;

    public Player() {
        this.cards = new ArrayList<Card>();
    }


    public int getCardSize() {
        return this.cards.size();
    }


    public void addCard(Card card) {
        this.cards.add(card);
        Collections.sort(this.cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    public RankingResult getRankingResult() {
        if (rankingResult == null) {
            rankingResult =  new RankingResult();
            rankingResult.setRankingEnum(RankingEnum.HIGH_CARD);
            rankingResult.setHighCard(this.cards.get(0));
        }
        return rankingResult;
    }

    public Map<Integer, Integer> getCardsRankCountMap() {
        List<Card> cards = this.getCards();
        Map<Integer, Integer> rankCount = new HashMap<Integer, Integer>();
        for (Card card : cards) {
            Integer number = new Integer(card.getRank().getNumber());
            if (!rankCount.containsKey(number)) {
                rankCount.put(number, 1);
            } else {
                rankCount.put(number, rankCount.get(number) + 1);
            }
        }
        return rankCount;
    }

    public void setRankingResult(RankingResult rankingResult) {
        this.rankingResult = rankingResult;
    }

    public int compareTo(Player o) {
        int selfPriority = this.getRankingResult().getRankingEnum().getPriority();
        int otherPriority = o.getRankingResult().getRankingEnum().getPriority();

        if (selfPriority < otherPriority) {
            return 1;
        }
        if (selfPriority > otherPriority) {
            return -1;
        }

        if (selfPriority == otherPriority) {
            IComparing cmp = ComparingFacade.getComparing(this.getRankingResult().getRankingEnum());
            return cmp.compare(this, o);
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Player{" +
                "cards=" + cards +
                ", rankingResult=" + rankingResult +
                '}';
    }
}
