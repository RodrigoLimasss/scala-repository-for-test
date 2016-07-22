import org.scalatest.{Matchers, FlatSpec}

/**
  * Created by rlsilva on 21/07/2016.
  */
class DoubleFormatTest extends FlatSpec with Matchers {

  it should "format double to 2 decimal" in {

    val value: Double = 2.1759130434782608

    val result: Double = "%1.2f".formatLocal(java.util.Locale.ENGLISH, value).toDouble

    val expected: Double = 2.18

    assertResult(expected)(result)

  }

}
