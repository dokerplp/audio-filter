package audio

import scala.annotation.tailrec

class AudioAnalyzer {
  def analyze(list: List[Double]): Double => Double = {
    @tailrec
    def helper(list: List[Double], x: Int, f: Double => Double): Double => Double = {
      list match {
        case List() => f
        case List(_) => f
        case fst :: snd :: tail => {
          val ff = (t: Double) => if (x <= t && t <= x + 1) (t - x) * (snd - fst) + fst else f(t)
          helper(snd :: tail, x + 1, ff)
        }
      }
    }
    helper(list, 0, _ => 0)
  }

  def analyze(array: Array[Double]): Double => Double = analyze(array.toList)

}






