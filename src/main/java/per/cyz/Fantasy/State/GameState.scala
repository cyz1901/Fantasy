package per.cyz.Fantasy.State

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import per.cyz.Fantasy.Game
import per.cyz.Fantasy.Manager.GameStageManager


abstract class GameState() {
  val gameManager: GameStageManager
  var sb: SpriteBatch = _
  var camera: OrthographicCamera = _
  var game: Game = _

  {
    game = gameManager.game
    sb = game.sb
    camera = game.camera
  }

  def handleInput(): Unit

  def update(dt: Float): Unit

  def render(): Unit

  def dispose(): Unit


}
