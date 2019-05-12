package com.game.texasholdem.ranking;

import com.game.texasholdem.Player;

public interface IRanking {
    RankingResult resolve(Player player);
}
