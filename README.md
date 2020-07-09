To run: `sbt jmh:run`

Performance characteristics (scala docs): https://docs.scala-lang.org/overviews/collections-2.13/performance-characteristics.html

```
[info] Benchmark                              Mode  Cnt          Score          Error  Units
[info] Benchmarks.appendLargeArraySeq        thrpt    5       2445.305 ±      795.928  ops/s
[info] Benchmarks.appendLargeChunk           thrpt    5   16643335.252 ±   526679.037  ops/s
[info] Benchmarks.appendLargeVector          thrpt    5   64491983.425 ±  2612632.141  ops/s
[info] Benchmarks.appendLargeHashMap         thrpt    5    7815661.661 ±   192336.995  ops/s
[info] Benchmarks.appendLargeTreeMap         thrpt    5    7011056.604 ±   225366.239  ops/s
[info] Benchmarks.filterLargeArraySeq        thrpt    5         55.753 ±       11.525  ops/s
[info] Benchmarks.filterLargeChunk           thrpt    5        284.436 ±       46.645  ops/s
[info] Benchmarks.filterLargeVector          thrpt    5        182.648 ±       24.993  ops/s
[info] Benchmarks.filterLargeHashMap         thrpt    5         11.216 ±        0.426  ops/s
[info] Benchmarks.filterLargeTreeMap         thrpt    5         36.007 ±        4.300  ops/s
[info] Benchmarks.foreachLargeArraySeq       thrpt    5       2859.506 ±     4599.430  ops/s
[info] Benchmarks.foreachLargeChunk          thrpt    5       2818.382 ±       49.696  ops/s
[info] Benchmarks.foreachLargeVector         thrpt    5        443.150 ±       29.193  ops/s
[info] Benchmarks.foreachLargeHashMap        thrpt    5        122.204 ±        4.229  ops/s
[info] Benchmarks.foreachLargeTreeMap        thrpt    5        313.424 ±        5.958  ops/s
[info] Benchmarks.randomAccessLargeArraySeq  thrpt    5  270299913.995 ±  4330459.574  ops/s
[info] Benchmarks.randomAccessLargeChunk     thrpt    5  271011880.561 ± 10868878.659  ops/s
[info] Benchmarks.randomAccessLargeVector    thrpt    5  202460038.763 ± 10356755.711  ops/s
[info] Benchmarks.randomLargeHashMap         thrpt    5   60392863.099 ±  9201571.965  ops/s
[info] Benchmarks.randomLargeTreeMap         thrpt    5   10596327.139 ± 10530020.554  ops/s
[info] Benchmarks.updateLargeArraySeq        thrpt    5       2012.611 ±      131.556  ops/s
[info] Benchmarks.updateLargeChunk           thrpt    5        228.480 ±       34.538  ops/s
[info] Benchmarks.updateLargeVector          thrpt    5   23041966.251 ±  1202371.182  ops/s
[info] Benchmarks.updateLargeHashMap         thrpt    5   11097460.705 ±   400748.875  ops/s
[info] Benchmarks.updateLargeTreeMap         thrpt    5    8836166.553 ±  1121080.951  ops/s
```

References: https://gist.github.com/ghostdogpr/bbfc584e683ca7c8723ab34ffec9a059
