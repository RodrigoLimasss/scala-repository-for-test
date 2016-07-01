package test.scala

import java.util.Date
import org.scalatest.{FlatSpec, Matchers}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}

/**
  * Created by rodrigolimasss on 01/07/2016.
  */

class FutureTest extends FlatSpec with Matchers {

  it should "wait the result future" in {
    val f = Future {
      Thread.sleep(3000)
      "wait"
    }
    Await.result(f, 4.seconds)

    assert("wait" == f.value.get.get)
  }

  it should "wait the result future with onComplete" in {
    val f: Future[String] = Future {
      Thread.sleep(3000)
      "wait"
    }

    Await.result(f, 4.seconds)

    f onComplete {
      case Success(s) => println("Success: " + s)
      case Failure(s) => println("Failure: " + s)
      case _ => println("none")
    }

    assert("wait" == f.value.get.get)
  }

  it should "no wait the result future" in {
    val f: Future[String] = Future {
      println("Ini fut: " + new Date())
      Thread.sleep(3000)
      println("End fut: " + new Date())
      "no wait"
    }

    f.map(x => {
      println("Ini map: " + new Date());
      println(x);
      println("End map: " + new Date())
    })

    Thread.sleep(6000)

    assert(true)
  }

  it should "no wait the result future in loop" in {

    Range(1, 10).par.foreach { x =>
      val f: Future[String] = Future {
        Thread.sleep(100*x)
        val res = x.toString
        println("fut: " + res)
        res
      }

      f.map(x => {
        println("res: " + x);
      })
    }

    Thread.sleep(5000)
    assert(true)

  }

}
