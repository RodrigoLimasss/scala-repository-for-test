import org.scalatest.{Matchers, FlatSpec}

/**
  * Created by rlsilva on 01/07/2016.
  */
class ExtensionMethodsTest extends FlatSpec with Matchers {

  object Extensions {
    implicit def handlers(i: Any) = new {
      def toUpper = i.toString.toUpperCase
      def toLower = i.toString.toLowerCase
    }

    implicit def handlersInt(i: Int) = new {
      def multiply(x: Int) = i * x
      def sum(x: Int) = i + x
    }
  }

  it should "upper and lower case the string name" in {
    import Extensions._

    val expected = "RODRIGO"
    val value = "rodrigo"

    val actual = value.toUpper

    assertResult(expected)(actual)
    assertResult(value)(expected.toLower)
  }

  it should "multiply de value" in {
    import Extensions._

    val expected = 25
    val value = 5

    val actual = value.multiply(value)

    assertResult(expected)(actual)
  }

}
