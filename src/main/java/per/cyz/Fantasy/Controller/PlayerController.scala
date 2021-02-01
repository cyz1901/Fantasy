package per.cyz.Fantasy.Controller

import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.{Gdx, Input}
import per.cyz.Fantasy.WorldRule.WorldRule

class PlayerController {

}
object PlayerController{
  def playerControlle(player: Actor): Unit = {
    if (Gdx.input.isKeyPressed(Input.Keys.W)) {
      player.setY(player.getY() + 1 * WorldRule.playerSpeed )
    }else if (Gdx.input.isKeyPressed(Input.Keys.D) && Gdx.input.isKeyPressed(Input.Keys.A)){
    }
    else if (Gdx.input.isKeyPressed(Input.Keys.S)){
      player.setY(player.getY() - 1 * WorldRule.playerSpeed )
    }else if (Gdx.input.isKeyPressed(Input.Keys.A)){
      player.setX(player.getX() - 1 * WorldRule.playerSpeed )
    }else if (Gdx.input.isKeyPressed(Input.Keys.D)){
      player.setX(player.getX() + 1 * WorldRule.playerSpeed )
    }
  }
}
