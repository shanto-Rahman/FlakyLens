/** 
 * This test should work when running at least on dual-core. It assumes that (P1(r1) + P2(r1) + P3(r1)) + (P1(r2) + P2(r2) + P3(r2)) > Parallel(P1(r1) + P2(r1) + P3(r1) | P1(r2) + P2(r2) + P3(r2))
 */
@Test public void preProcessingInParallelIsFaster() throws Exception {
if (availableProcessors > 1) {
Assert.assertTrue(String.format("%s  > %s + %s",sequentialExecution,parallelExecution,delta),sequentialExecution > parallelExecution + delta);
}
}