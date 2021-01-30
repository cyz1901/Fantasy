package per.cyz.Fantasy.Player

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.scenes.scene2d.{Actor, Event}

class Player extends Actor{

  override def draw(batch: Batch, parentAlpha: Float): Unit = super.draw(batch, parentAlpha)

  override def act(delta: Float): Unit = super.act(delta)

  override def fire(event: Event): Boolean = super.fire(event)
}
object Player {

}
