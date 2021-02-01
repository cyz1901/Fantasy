package per.cyz.Fantasy.Terrian

import com.badlogic.gdx.utils.Json
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.files.FileHandle

import scala.util.Random

class TileGameMapLoader {

}

object TileGameMapLoader {

  private var json: Json = new Json()
  private val SIZE: Int = 100

  def loadMap(id: String, name: String): BlockData = {
    Gdx.files.local("maps/").file.mkdirs
    val file: FileHandle = Gdx.files.local("maps/" + id + ".map")
    if (file.exists) {
      val data = json.fromJson(classOf[BlockData], file.readString)
      data
    }
    else {
      val data = generateGameMap(id, name)
      data
    }
  }

  /*  for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {
        mapData.map[0][row][col] = TileType.SKY.getId();

        if (row > SIZE - 3 - 1) {
          mapData.map[1][row][col] = TileType.LAVA.getId();
        } else if (row > SIZE - 20) {
          mapData.map[1][row][col] = TileType.STONE.getId();
        } else if (row > SIZE - 25) {
          mapData.map[1][row][col] = TileType.DIRT.getId();
        } else if (row > SIZE - 26) {
          mapData.map[1][row][col] = TileType.GRASS.getId();
        } else {
          if (random.nextInt(50) == 0)//1 chance out of 50 of being a cloud
            mapData.map[1][row][col] = TileType.CLOUD.getId();
        }
      }
    }*/
  def generateGameMap(id: String, name: String) = {
    val mapData = new BlockData()
    mapData.id = id
    mapData.name = id
    mapData.map = Array.ofDim(2, SIZE, SIZE)
    val random = new Random()
    val start = System.currentTimeMillis
    //while 能比for 有更多的性能
    var row = 0
    var col = 0
    while (row < SIZE) {
      while (col < SIZE) {
        mapData.map(0)(row)(col) = BlockType.SKY.id
        if (row > SIZE - 3 - 1) {
          mapData.map(1)(row)(col) = BlockType.SOIL.id
        } else {
          if (random.nextInt(50) == 0) //1 chance out of 50 of being a cloud
            mapData.map(1)(row)(col) = BlockType.SOIL.id
        }
        col += 1
      }
      col = 0
      row += 1
    }
    mapData
  }

}
