import com.badlogic.gdx.backends.lwjgl.{LwjglApplication, LwjglApplicationConfiguration}

object Main {
  def main(argv: Array[String]): Unit = {
    val config: LwjglApplicationConfiguration  = new LwjglApplicationConfiguration()
    new LwjglApplication(new App, config)
  }
}