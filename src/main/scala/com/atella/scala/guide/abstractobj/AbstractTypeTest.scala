package com.atella.scala.guide.abstractobj

/**
  * Created by chenyuan on 2018/4/17.
  */

class Food
abstract class Animal {
  type SuitableFood <: Food
  def eat(food: SuitableFood)
}

class Grass extends Food
class Cow extends Animal {
  type SuitableFood = Grass
  override def eat(food: Grass) {}
}

object AbstractTypeTest {

}
