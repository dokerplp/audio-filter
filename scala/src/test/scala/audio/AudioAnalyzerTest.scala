package audio

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test;

class AudioAnalyzerTest {

  @Test
  def analyze(): Unit = {
    val list = List(0.0, -1.0, 0.0, 2.0, 0.0, -1.0, 0.0, 1.0, 0.0, -2.0, 0.0, 1.0)
    val analyzer = new AudioAnalyzer
    val func = analyzer.analyze(list)

    assertEquals(func(-10.0), 0.0)
    assertEquals(func(20.0), 0.0)
    assertEquals(func(0.0), 0.0)
    assertEquals(func(11.0), 1.0)
    assertEquals(func(3.0), 2.0)
    assertEquals(func(2.5), 1.0)
    assertEquals(func(9.0), -2.0)
    assertEquals(func(9.5), -1.0)

  }


}
