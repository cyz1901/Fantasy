package per.cyz.Fantasy.Terrian

import com.badlogic.gdx.maps.{MapLayers, MapProperties}
import com.badlogic.gdx.maps.tiled.{TiledMap, TiledMapTileSets}
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.utils
import com.badlogic.gdx.utils.Disposable
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion

class TileGameMap  {
  val data: BlockData = TileGameMapLoader.loadMap("basic", "My Grass Lands!")
  val id: String = data.id
  val name: String = data.name
  var map: Array[Array[Array[Int]]] = data.map

  private val batch: SpriteBatch = new SpriteBatch()
  private val tiles: Array[Array[TextureRegion]] = TextureRegion.split(new Texture("tiles.png"), 16, 16)

  def getLayers: Int = map.length

  def getWidth: Int = map(0)(0).length

  def getHeight: Int = map(0).length

  def getTileTypeByCoordinate(layer: Int, x: Int, y: Int) = {
    BlockType.getTypeById(map(layer)(getHeight - y - 1)(x)) match {
      case Some(x) => x
      case None => None
    }
//    if (x < 0 || x >= getWidth || y < 0 || y >= getHeight) {
//      println("null")
//      null
//    }
//    println(map(layer)(getHeight - y - 1)(x))
//    BlockType.getTypeById(map(layer)(getHeight - y - 1)(x))
  }

  def render(camera: OrthographicCamera): Unit = {

    batch.setProjectionMatrix(camera.combined)
    batch.begin
    val start = System.currentTimeMillis
    for (layer <- 0 until getLayers) {
      for (row <- 0 until getHeight) {
        for (col <- 0 until getWidth) {
          BlockType.getTypeById(map(layer)(getHeight - row - 1)(col)) match {
            case None =>
            case Some(x) => {
              batch.draw(tiles(0)(x.id - 1), col * BlockType.TILE_SIZE, row * BlockType.TILE_SIZE)
            }
          }
        }
      }
    }
    val end = System.currentTimeMillis
    println("take time = " + (end - start))
    batch.`end`()
  }

}
