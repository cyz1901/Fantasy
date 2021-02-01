package per.cyz.Fantasy.Manager

import per.cyz.Fantasy.Game
import per.cyz.Fantasy.Manager.GameStageManager.PLAY
import per.cyz.Fantasy.State.{GameState, Play}

import java.util

class GameStageManager(var game: Game) {
  private var gameStates: util.Stack[GameState] = _


  gameStates = new util.Stack[GameState]
  println("hello")
  pushStage(PLAY)


  def update(dt: Float): Unit = {
    gameStates.peek().update(dt)
  }

  def rander() = {
    gameStates.peek().render()
  }

  def getState(state: Int) = {
    if (state == PLAY) {
      new Play(this)
    }
    else {
     null
    }
  }

  def setStage(state: Int): Unit = {
    popStage()
    pushStage(state)
  }

  def popStage(): Unit = {
    val gameState: GameState = gameStates.pop()
    gameState.dispose()
  }

  def pushStage(state: Int): Unit = {
    gameStates.push(getState(state))
  }

}

object GameStageManager {
  val PLAY: Int = 1
}
