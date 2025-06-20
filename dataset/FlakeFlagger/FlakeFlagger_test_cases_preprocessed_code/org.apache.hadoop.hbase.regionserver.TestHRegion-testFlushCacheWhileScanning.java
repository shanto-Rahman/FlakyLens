/** 
 * Flushes the cache in a thread while scanning. The tests verify that the scan is coherent - e.g. the returned results are always of the same or later update as the previous results.
 * @throws IOException  scan / compact
 * @throws InterruptedException  thread join
 */
public void testFlushCacheWhileScanning() throws IOException, InterruptedException {
flushThread.start();
if (i != 0 && i % compactInterval == 0) {
}
if (i % 10 == 5L) {
}
if (i != 0 && i % flushAndScanInterval == 0) {
if (toggle) {
flushThread.flush();//IT
}
if (!toggle) {
flushThread.flush();//IT
}
Assert.assertEquals("i=" + i,expectedCount,res.size());
}
flushThread.done();//IT
flushThread.join();
flushThread.checkNoError();//IT
}