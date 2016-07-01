import org.scalatest.{Matchers, FlatSpec}

/**
  * Created by rlsilva on 01/07/2016.
  */

class SignalAsFunctionTest extends FlatSpec with Matchers {

  def ?  (x: Int) = x + x
  def `*`(x: Int) = x * x

  it should "multiply the value" in {

    val expected = 25
    val value = 5

    val actual = `*`(value)

    assertResult(expected)(actual)
  }

  it should "sum the value" in {

    val expected = 10
    val value = 5

    val actual = ?(value)

    assertResult(expected)(actual)
  }

}
