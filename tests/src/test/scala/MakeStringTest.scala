import org.scalatest.{Matchers, FlatSpec}

/**
  * Created by rlsilva on 21/07/2016.
  */
class MakeStringTest extends FlatSpec with Matchers {

  it should "make string from array with comma separator" in {

    val array = Array("High", "Medium", "Small", "Micro")

    val expected = """High, Medium, Small, Micro"""

    val result = array.mkString(", ")

    assertResult(expected)(result)

  }

  it should "make string from array with comma separator and double quotes" in {

    val array = Array("High", "Medium", "Small", "Micro")

    val expected = """"High", "Medium", "Small", "Micro""""

    val result = array.map(x => s""""${x}"""").mkString(", ")

    assertResult(expected)(result)

  }

}
