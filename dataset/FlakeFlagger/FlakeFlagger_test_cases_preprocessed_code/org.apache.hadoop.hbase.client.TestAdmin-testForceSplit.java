/** 
 * Tests forcing split from client and having scanners successfully ride over split.
 * @throws Exception
 * @throws IOException
 */
@Test public void testForceSplit() throws Exception {
assertTrue(m.size() == 1);
assertEquals(rowCount,rows);
sleep(1000);
if (regions == null) continue;
count.set(regions.size());
if (count.get() >= 2) break;
t.start();
t.join();
if (rows > rowCount) {
assertTrue("Scanned more than expected (" + rowCount + ")",false);
}
assertEquals(rowCount,rows);
}