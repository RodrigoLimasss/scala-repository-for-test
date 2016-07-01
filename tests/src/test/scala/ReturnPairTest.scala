import org.scalatest.{Matchers, FlatSpec}

/**
  * Created by rodrigolimasss on 01/07/2016.
  */
class ReturnPairTest extends FlatSpec with Matchers {


  def twoValues(name: String, age: Int): (String, Int) = {
    (name, age)
  }

  it should "return two values" in {

    val name = "Rodrigo"
    val age = 27

    val expected = (name, age)
    val actual = twoValues(name, age)

    assertResult(expected)(actual)

  }

}
