package per.cyz.Fantasy.Terrian

import enumeratum._

import scala.collection.mutable


sealed abstract class BlockType(val id: Int,
                                val name: String,
                                val collidable: Boolean) extends EnumEntry

object BlockType extends Enum[BlockType] {
  val values = findValues
  val TILE_SIZE: Int = 16

  case object SOIL extends BlockType(1,"Soil",true)
  case object SKY extends BlockType(2,"Sky",false)

  private var tileMap: mutable.HashMap[Int, BlockType] = mutable.HashMap.empty

    {
      for (tileType: BlockType <- BlockType.values) {
        tileMap.put(tileType.id, tileType)
      }
      println(tileMap)
    }

    def getTypeById(id: Int) = tileMap.get(id)

}


