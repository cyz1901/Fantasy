package per.cyz.Fantasy.State

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType
import com.badlogic.gdx.physics.box2d.{Body, BodyDef, Box2DDebugRenderer, FixtureDef, PolygonShape, World}
import org.lwjgl.opengl.GL30
import per.cyz.Fantasy.Manager.GameStageManager

class Play(override val gameManager: GameStageManager) extends GameState {


  var world: World = _
  var b2dr: Box2DDebugRenderer = _
  var bdef: BodyDef = _
  var shape: PolygonShape = _
  var fdef: FixtureDef = _
  var bitfont: BitmapFont = new BitmapFont()

  {
    world = new World(new Vector2(0.0f, -9.8f), true)
    b2dr = new Box2DDebugRenderer()

    bdef = new BodyDef()
    bdef.position.set(160, 150)
    bdef.`type` = BodyType.StaticBody
    val body:Body = world.createBody(bdef)

    shape = new PolygonShape()
    shape.setAsBox(5, 5)

    fdef = new FixtureDef()
    fdef.shape = shape
    body.createFixture(fdef)
  }

  override def handleInput(): Unit = {

  }

  override def update(dt: Float): Unit = {
    Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT)
    world.step(dt, 6, 2)
  }

  override def render(): Unit = {
//    sb.setProjectionMatrix(camera.combined)
//    sb.begin()
//    bitfont.draw(sb, "hello world", 100, 100)
//    sb.`end`()
  }

  override def dispose(): Unit = {

  }
}
