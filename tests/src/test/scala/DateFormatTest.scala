import java.text.SimpleDateFormat
import java.util.{TimeZone, Date}

import org.scalatest.{FlatSpec, Matchers}

class DateFormatTest extends FlatSpec with Matchers {

  import UtilDateTime._

  it should "format Date to string UTC" in {

    val dateTimeNow: Date = new Date()
    dateTimeNow.setTime(1467817200000L) //"2016-07-06 12:00:00.000" - GMT-03
    val stringDate: String = formatDate2StringUTC(dateTimeNow)

    val expectedDateUTC = "2016-07-06 15:00:00.000" //UTC+00

    println(s"expectedDateUTC: $expectedDateUTC, dateToStringUTC: $stringDate")

    assertResult(expectedDateUTC)(stringDate)
  }

  it should "parse string to Date" in {

    val date: Date = parseString2Date("2016-07-06 12:00:00.000")

    val expectedDate = new Date()
    expectedDate.setTime(1467817200000L) //"2016-07-06 12:00:00.000"

    println(s"expectedDate: $expectedDate, stringTodate: $date")

    assertResult(expectedDate)(date)
  }

}

object UtilDateTime {

  def formatDate2StringUTC(date: Date) = {
    val timeZone: TimeZone = TimeZone.getTimeZone("UTC")
    val sdf: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
    sdf.setTimeZone(timeZone)
    sdf.format(date)
  }

  def parseString2Date(sDate: String) = {
    val sdf: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
    sdf.parse(sDate)
  }

}
