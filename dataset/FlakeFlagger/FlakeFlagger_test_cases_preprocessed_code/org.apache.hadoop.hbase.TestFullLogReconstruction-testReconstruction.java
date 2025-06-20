/** 
 * Test the whole reconstruction loop. Build a table with regions aaa to zzz and load every one of them multiple times with the same date and do a flush at some point. Kill one of the region servers and scan the table. We should see all the rows.
 * @throws Exception
 */
@Test public void testReconstruction() throws Exception {
assertEquals(initialCount,count);
if (i == 2) {
}
assertEquals(count,newCount);
}