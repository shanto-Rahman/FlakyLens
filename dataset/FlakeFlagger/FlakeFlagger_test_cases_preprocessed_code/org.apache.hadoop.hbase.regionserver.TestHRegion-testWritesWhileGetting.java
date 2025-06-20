/** 
 * Writes very wide records and gets the latest row every time.. Flushes and compacts the region every now and then to keep things realistic.
 * @throws IOException           by flush / scan / compaction
 * @throws InterruptedException  when joining threads
 */
public void testWritesWhileGetting() throws IOException, InterruptedException {
putThread.start();
flushThread.start();
if (i != 0 && i % compactInterval == 0) {
}
if (i != 0 && i % flushInterval == 0) {
flushThread.flush();//IT
}
if (!result.isEmpty() || !previousEmpty || i > compactInterval) {
Assert.assertEquals("i=" + i,expectedCount,result.size());
if (Bytes.equals(kv.getFamily(),families[0]) && Bytes.equals(kv.getQualifier(),qualifiers[0])) {
}
Assert.assertTrue(timestamp >= prevTimestamp);
}
putThread.done();//IT
putThread.join();
putThread.checkNoError();//IT
flushThread.done();//IT
flushThread.join();
flushThread.checkNoError();//IT
}