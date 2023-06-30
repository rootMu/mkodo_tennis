package uk.rootmu.mkodo_interview_app

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TennisGameTest {

    private lateinit var tennisGame: TennisGame

    @Before
    fun init() {
        tennisGame = TennisGame()
    }

    @Test
    fun `get score`() {
        assertEquals("Love - All", tennisGame.getScore())
    }

    @Test
    fun `on player one scoring verify correct score returned`() {
        tennisGame.playerOneScore()
        assertEquals("15 - Love", tennisGame.getScore())
    }

    @Test
    fun `on player two scoring verify correct score returned`() {
        tennisGame.playerTwoScore()
        assertEquals("Love - 15", tennisGame.getScore())
    }

    @Test
    fun `on player one scoring twice verify correct score returned`() {
        tennisGame.playerOneScore()
        tennisGame.playerOneScore()
        assertEquals("30 - Love", tennisGame.getScore())
    }

    @Test
    fun `on player one scoring thrice verify correct score returned`() {
        tennisGame.playerOneScore()
        tennisGame.playerOneScore()
        tennisGame.playerOneScore()
        assertEquals("40 - Love", tennisGame.getScore())
    }

    @Test
    fun `on player one scoring thrice and player two scoring verify correct score returned`() {
        tennisGame.playerOneScore()
        tennisGame.playerOneScore()
        tennisGame.playerOneScore()
        tennisGame.playerTwoScore()
        assertEquals("40 - 15", tennisGame.getScore())
    }

    @Test
    fun `on player one and player two both scoring 40 verify correct score returned`() {
        tennisGame.playerOneScore()
        tennisGame.playerOneScore()
        tennisGame.playerOneScore()
        tennisGame.playerTwoScore()
        tennisGame.playerTwoScore()
        tennisGame.playerTwoScore()
        assertEquals("Deuce", tennisGame.getScore())
    }

    @Test
    fun `on a score of Deuce ensure advantage is recorded on scoring`() {
        tennisGame.playerOneScore()
        tennisGame.playerOneScore()
        tennisGame.playerOneScore()
        tennisGame.playerTwoScore()
        tennisGame.playerTwoScore()
        tennisGame.playerTwoScore()
        tennisGame.playerTwoScore()
        assertEquals("Advantage PlayerTwo", tennisGame.getScore())
    }


    @Test
    fun `on advantage should opponent score verify score returns to Deuce`() {
        tennisGame.playerOneScore()
        tennisGame.playerOneScore()
        tennisGame.playerOneScore()
        tennisGame.playerTwoScore()
        tennisGame.playerTwoScore()
        tennisGame.playerTwoScore()
        tennisGame.playerTwoScore()
        tennisGame.playerOneScore()
        assertEquals("Deuce", tennisGame.getScore())
    }

    @Test
    fun `on scoring with advantage verify game is reset and set is increased`() {
        tennisGame.playerOneScore()
        tennisGame.playerOneScore()
        tennisGame.playerOneScore()
        tennisGame.playerTwoScore()
        tennisGame.playerTwoScore()
        tennisGame.playerTwoScore()
        tennisGame.playerTwoScore()
        tennisGame.playerTwoScore()
        assertEquals("Love - All - 0:1", tennisGame.getScore())
    }

}