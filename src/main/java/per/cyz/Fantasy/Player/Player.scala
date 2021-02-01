package per.cyz.Fantasy.Player

import com.badlogic.gdx.{Gdx, Input}
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.{Actor, Event, InputEvent, InputListener}


class Player(val region: TextureRegion) extends Actor {


  //  private val region: TextureRegion = null

  setSize(this.region.getRegionWidth, this.region.getRegionHeight)

  override def draw(batch: Batch, parentAlpha: Float): Unit = {
    super.draw(batch, parentAlpha)
    batch.draw(
      region,
      getX(), getY(),
      getOriginX, getOriginY,
      getWidth, getHeight,
      getScaleX, getScaleY,
      getRotation)
  }

  override def act(delta: Float): Unit = super.act(delta)

  override def fire(event: Event): Boolean = super.fire(event)
}

object Player {

}
