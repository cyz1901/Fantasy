import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.{GL20, OrthographicCamera, Texture}
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.maps.tiled.TiledMap
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.Scaling
import com.badlogic.gdx.utils.viewport.{ExtendViewport, FillViewport, FitViewport, ScalingViewport}
import per.cyz.Fantasy.Terrian.TileGameMap


/**
 * 游戏主程序的启动入口类, 实现 ApplicationListener 接口
 */
class App extends ApplicationListener { // 纹理画布
  var camera: OrthographicCamera = null
  var batch: SpriteBatch = null
  var map: TileGameMap = null
  var viewport: ScalingViewport = null
  var stage: Stage = null

  var orthoginalRander: OrthogonalTiledMapRenderer = null

  override def create(): Unit = {
    batch = new SpriteBatch()
    map = new TileGameMap().asInstanceOf[TileGameMap]

    val w: Float = Gdx.graphics.getWidth()
    val h: Float = Gdx.graphics.getHeight()

    println("w is " + w + "h is " + h)

    camera = new OrthographicCamera()
    viewport = new ScalingViewport(Scaling.fill,w, h, camera)
    stage = new Stage(viewport)
    camera.position.set(0, camera.viewportHeight, 0)
    camera.setToOrtho(false, w, h)
    camera.update()
  }

  override def resize(width: Int, height: Int): Unit = {
    println(s"now width is $width height is $height")
    viewport.update(width, height)
  }

  override def resume(): Unit = {
  }

  override def pause(): Unit = {
  }

  override def render(): Unit = {
    // 设置清屏颜色为红色（RGBA）
    Gdx.gl.glClearColor(1, 1, 1, 0)
    // 清屏
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

    map.render(camera)

    /* 使用画笔将纹理绘制在屏幕上 */
    //    batch.begin() // 绘制开始
    //
    //    batch.draw(texture, 10, 50, 16, 16) // 在屏幕左下角绘制纹理
    //
    //    batch.draw(texture, 50, 50, 8, 8)
    //    //    viewport.apply()
    //    batch.`end`() // 绘制结束
  }

  override def dispose(): Unit = {
    batch.dispose()
  }
}
