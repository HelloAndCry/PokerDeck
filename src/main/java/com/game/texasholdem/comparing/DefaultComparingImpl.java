package com.game.texasholdem.comparing;

import com.game.texasholdem.Player;

public class DefaultComparingImpl extends AbstractComparing {

    public int compare(Player o1, Player o2) {
        return this.seqComparing(o1, o2);
    }

}
