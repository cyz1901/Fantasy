package per.cyz.Fantasy

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.{GL20, OrthographicCamera}
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType
import com.badlogic.gdx.physics.box2d._
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.ScalingViewport
import com.badlogic.gdx.{ApplicationListener, Gdx}
import per.cyz.Fantasy.Player.Player
import per.cyz.Fantasy.Terrian.TileGameMap


/**
 * 游戏主程序的启动入口类, 实现 ApplicationListener 接口
 */
class App extends ApplicationListener { // 纹理画布
  var camera: OrthographicCamera = _
  var batch: SpriteBatch = _
  var map: TileGameMap = _
  var viewport: ScalingViewport = _
  var stage: Stage = _
  var player: Player = _
  var world: World = _
  var b2dr: Box2DDebugRenderer = _

  var orthoginalRander: OrthogonalTiledMapRenderer = _

  var bdef: BodyDef = _
  var shape: PolygonShape = _
  var fdef: FixtureDef = _
  var body: Body = _

  override def create(): Unit = {
    //    batch = new SpriteBatch()
    //    map = new TileGameMap().asInstanceOf[TileGameMap]
    //
    //    val w: Float = Gdx.graphics.getWidth()
    //    val h: Float = Gdx.graphics.getHeight()
    //
    //    println("w is " + w + "h is " + h)
    //
    //    camera = new OrthographicCamera()
    //    viewport = new ScalingViewport(Scaling.fill, w, h, camera)
    //    stage = new Stage(viewport)
    //    camera.position.set(0, camera.viewportHeight, 0)
    //    camera.setToOrtho(false, w, h)
    //    camera.update()
    //
    world = new World(new Vector2(0.0f, -9.8f), true)
    b2dr = new Box2DDebugRenderer()
    //    player = new Player(new TextureRegion(new Texture(Gdx.files.internal("player.png"))))
    //    stage.addActor(player)
    bdef = new BodyDef()
    bdef.position.set(160, 150)
    bdef.`type` = BodyType.StaticBody
    body = world.createBody(bdef)

    shape = new PolygonShape()
    shape.setAsBox(5, 5)

    fdef = new FixtureDef()
    fdef.shape = shape
    body.createFixture(fdef)

    val w: Float = Gdx.graphics.getWidth()
    val h: Float = Gdx.graphics.getHeight()

    println("w is " + w + "h is " + h)

    camera = new OrthographicCamera()
    camera.position.set(0, camera.viewportHeight, 0)
    camera.setToOrtho(false, w, h)
    camera.update()


  }

  override def resize(width: Int, height: Int): Unit = {
    println(s"now width is $width height is $height")
    //    viewport.update(width, height)
  }

  override def resume(): Unit = {
  }

  override def pause(): Unit = {
  }

  override def render(): Unit = {
    //    println("堆内存为"+Gdx.app.getJavaHeap+"原生堆内存为"+Gdx.app.getNativeHeap)
    //    Gdx.gl.glClearColor(1, 1, 1, 0)
    // 清屏
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
//    world.step(dt)

    //    map.render(camera)
    //
    //    import com.badlogic.gdx.Gdx
    //    player.act(Gdx.graphics.getDeltaTime)
    //
    //    PlayerController.playerControlle(player)
    //    stage.act()
    //    stage.draw()

//    bdef = new BodyDef()
//    bdef.position.set(160, 150)
//    bdef.`type` = BodyType.StaticBody
//    body = world.createBody(bdef)
//
//    shape = new PolygonShape()
//    shape.setAsBox(5, 5)
//
//    fdef = new FixtureDef()
//    fdef.shape = shape
//    body.createFixture(fdef)



  }

  override def dispose(): Unit = {
    batch.dispose()
  }
}
