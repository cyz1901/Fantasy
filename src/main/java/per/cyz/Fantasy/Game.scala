package per.cyz.Fantasy

import com.badlogic.gdx.{ApplicationListener, Gdx}
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import per.cyz.Fantasy.Game.STEP
import per.cyz.Fantasy.Manager.GameStageManager
import per.cyz.Fantasy.Terrian.TileGameMapLoader

class Game extends ApplicationListener {

  var sb: SpriteBatch = _
  var camera: OrthographicCamera = _
  var gameManager: GameStageManager = _
  var acc: Float = _

  override def create(): Unit = {
    sb = new SpriteBatch()
    camera = new OrthographicCamera()
    camera.setToOrtho(false, Game.V_WIDTH, Game.V_HEIGHT)

    gameManager = new GameStageManager(this)


  }

  override def resize(i: Int, i1: Int): Unit = {

  }

  override def render(): Unit = {
    acc += Gdx.graphics.getDeltaTime
    if (acc>=STEP){
      acc -= STEP
      gameManager.update(STEP)
      gameManager.rander()
    }
  }

  override def pause(): Unit = {

  }

  override def resume(): Unit = {

  }

  override def dispose(): Unit = {

  }
}

object Game {
  val TAG: String = "Fantasy"
  val TITLE: String = "Fantasy"
  val V_WIDTH: Int = 320
  val V_HEIGHT: Int = 240
  val Scale: Int = 2
  val STEP: Float = 1 / 60f
}