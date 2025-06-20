/** 
 * Writes very wide records and scans for the latest every time.. Flushes and compacts the region every now and then to keep things realistic.
 * @throws IOException           by flush / scan / compaction
 * @throws InterruptedException  when joining threads
 */
public void testWritesWhileScanning() throws IOException, InterruptedException {
putThread.start();
flushThread.start();
if (i != 0 && i % compactInterval == 0) {
}
if (i != 0 && i % flushInterval == 0) {
flushThread.flush();//IT
}
if (!res.isEmpty() || !previousEmpty || i > compactInterval) {
Assert.assertEquals("i=" + i,expectedCount,res.size());
Assert.assertTrue(timestamp >= prevTimestamp);
}
putThread.done();//IT
putThread.join();
putThread.checkNoError();//IT
flushThread.done();//IT
flushThread.join();
flushThread.checkNoError();//IT
}