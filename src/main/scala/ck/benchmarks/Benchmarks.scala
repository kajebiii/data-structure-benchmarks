package ck.benchmarks

import java.util.concurrent.TimeUnit

import scala.collection.immutable.{ArraySeq, HashMap, TreeMap}
import scala.language.postfixOps
import org.openjdk.jmh.annotations.{State => S, _}
import zio.Chunk

@S(Scope.Thread)
@BenchmarkMode(Array(Mode.Throughput))
@OutputTimeUnit(TimeUnit.SECONDS)
@Warmup(iterations = 5, time = 3, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 3, timeUnit = TimeUnit.SECONDS)
@Fork(1)
class Benchmarks {

  private val largeVector   = (0 to 1000000).toVector
  private val largeList     = (0 to 1000000).toList
  private val largeChunk    = Chunk.fromIterable(largeList)
  private val largeArraySeq = ArraySeq.from(largeList)
  private val largeHashMap  = HashMap.from(largeList.map(e => e -> e))
  private val largeTreeMap  = TreeMap.from(largeList.map(e => e -> e))

  @Benchmark def foreachLargeVector(): Unit   = largeVector.foreach(_ => ())
  @Benchmark def foreachLargeChunk(): Unit    = largeChunk.foreach(_ => ())
  @Benchmark def foreachLargeArraySeq(): Unit = largeArraySeq.foreach(_ => ())
  @Benchmark def foreachLargeHashMap(): Unit  = largeHashMap.foreach(_ => ())
  @Benchmark def foreachLargeTreeMap(): Unit  = largeTreeMap.foreach(_ => ())

  @Benchmark def updateLargeVector(): Vector[Int]     = largeVector.updated(1250, 0)
  @Benchmark def updateLargeChunk(): Chunk[Int]       = largeChunk.updated(1250, 0)
  @Benchmark def updateLargeArraySeq(): ArraySeq[Int] = largeArraySeq.updated(1250, 0)
  @Benchmark def updateLargeHashMap(): HashMap[Int, Int]           = largeHashMap.updated(1250, 0)
  @Benchmark def updateLargeTreeMap(): TreeMap[Int, Int]           = largeTreeMap.updated(1250, 0)

  @Benchmark def appendLargeVector(): Vector[Int]     = largeVector :+ 0
  @Benchmark def appendLargeChunk(): Chunk[Int]       = largeChunk :+ 0
  @Benchmark def appendLargeArraySeq(): ArraySeq[Int] = largeArraySeq :+ 0
  @Benchmark def appendLargeHashMap(): HashMap[Int, Int]           = largeHashMap.updated(largeHashMap.size, 0)
  @Benchmark def appendLargeTreeMap(): TreeMap[Int, Int]           = largeTreeMap.updated(largeTreeMap.size, 0)

  @Benchmark def randomAccessLargeVector(): Int   = largeVector(123456)
  @Benchmark def randomAccessLargeChunk(): Int    = largeChunk(123456)
  @Benchmark def randomAccessLargeArraySeq(): Int = largeArraySeq(123456)
  @Benchmark def randomLargeHashMap(): Int           = largeHashMap(123456)
  @Benchmark def randomLargeTreeMap(): Int           = largeTreeMap(123456)

  @Benchmark def filterLargeVector(): Vector[Int]     = largeVector.filter(_ % 2 == 0)
  @Benchmark def filterLargeChunk(): Chunk[Int]       = largeChunk.filter(_ % 2 == 0)
  @Benchmark def filterLargeArraySeq(): ArraySeq[Int] = largeArraySeq.filter(_ % 2 == 0)
  @Benchmark def filterLargeHashMap(): HashMap[Int, Int]           = largeHashMap.filter(_._2 % 2 == 0)
  @Benchmark def filterLargeTreeMap(): TreeMap[Int, Int]           = largeTreeMap.filter(_._2 % 2 == 0)
}
