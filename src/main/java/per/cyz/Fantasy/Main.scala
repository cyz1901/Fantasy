package per.cyz.Fantasy

import com.badlogic.gdx.backends.lwjgl.{LwjglApplication, LwjglApplicationConfiguration}

object Main {
  def main(argv: Array[String]): Unit = {
    val config: LwjglApplicationConfiguration = new LwjglApplicationConfiguration()
    config.title = Game.TITLE
    config.height = Game.V_HEIGHT * Game.Scale
    config.width = Game.V_WIDTH * Game.Scale
    new LwjglApplication(new Game, config)
  }
}
