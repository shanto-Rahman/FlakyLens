/** 
 * Test filters when multiple regions.  It does counts.  Needs eye-balling of logs to ensure that we're not scanning more regions that we're supposed to. Related to the TestFilterAcrossRegions over in the o.a.h.h.filter package.
 * @throws IOException
 */
@Test public void testFilterAcrossMutlipleRegions() throws IOException {
HTable t=TEST_UTIL.createTable(name,FAMILY);//RW
int rowCount=TEST_UTIL.loadTable(t,FAMILY);//RW
assertTrue(endKeyCount < rowCount);
assertEquals(endKeyCount + 1,plusOneCount);
assertEquals(endKeyCount + 2,plusTwoCount);
assertEquals(endKeyCount - 1,minusOneCount);
assertEquals(1,countBBB);
assertEquals(0,countGreater);
assertEquals(rowCount - endKeyCount,countGreater);
}