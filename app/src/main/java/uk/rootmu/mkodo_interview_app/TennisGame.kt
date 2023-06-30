package uk.rootmu.mkodo_interview_app

class TennisGame {

    private var playerOne: Player = Player()
    private var playerTwo: Player = Player()

    data class Player(var score: Int = 0, var advantage: Boolean = false, var set: Int = 0) {
        fun getScore(): String = TennisScore.of(score)
        fun hasAdvantage(): Boolean = advantage
    }

    enum class TennisScore(val n: String) {
        Love("Love"),
        FIFTEEN("15"),
        THIRTY("30"),
        FORTY("40");

        companion object {
            fun of(score: Int): String {
                return TennisScore.values()[score].n
            }
        }
    }

    private fun score(player: Player, opponent: Player) {
        when {
            player.hasAdvantage() -> {
                player.set++
                player.score = 0
                player.advantage = false
                opponent.score = 0
            }

            opponent.hasAdvantage() -> {
                opponent.advantage = false
            }

            player.score == 3 -> player.advantage = true
            else -> player.score++
        }
    }

    fun playerOneScore() {
        score(playerOne, playerTwo)
    }

    fun playerTwoScore() {
        score(playerTwo, playerOne)
    }

    fun getScore(): String {
        val p1Score = playerOne.getScore()
        val p2Score = playerTwo.getScore()

        return when {
            playerOne.hasAdvantage() -> "Advantage PlayerOne"
            playerTwo.hasAdvantage() -> "Advantage PlayerTwo"
            p1Score == "40" && p2Score == "40" -> "Deuce"
            p1Score == p2Score -> "$p1Score - All"
            else -> "$p1Score - $p2Score"
        }.let {
            if (playerOne.set > 0 || playerTwo.set > 0) it.plus(" - ${playerOne.set}:${playerTwo.set}") else it
        }
    }


}