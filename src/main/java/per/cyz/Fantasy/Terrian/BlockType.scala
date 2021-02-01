package per.cyz.Fantasy.Terrian

import com.badlogic.gdx.physics.box2d.BodyDef.BodyType
import enumeratum._

import scala.collection.mutable


sealed abstract class BlockType(val id: Int,
                                val name: String,
                                val collidable: Boolean,
                                val bodyDef: BodyType) extends EnumEntry

object BlockType extends Enum[BlockType] {
  val values: IndexedSeq[BlockType] = findValues
  val TILE_SIZE: Int = 16

  case object SOIL extends BlockType(1, "Soil", true, BodyType.StaticBody)

  case object SKY extends BlockType(2, "Sky", false, BodyType.StaticBody)

  private var tileMap: mutable.HashMap[Int, BlockType] = mutable.HashMap.empty

  {
    for (tileType: BlockType <- BlockType.values) {
      tileMap.put(tileType.id, tileType)
    }
    println(tileMap)
  }

  def getTypeById(id: Int): Option[BlockType] = tileMap.get(id)

}


