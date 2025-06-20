/** 
 * Test getNextRow from memstore
 * @throws InterruptedException
 */
public void testGetNextRow() throws Exception {
Thread.sleep(1);
assertTrue(KeyValue.COMPARATOR.compareRows(closestToEmpty,new KeyValue(Bytes.toBytes(0),System.currentTimeMillis())) == 0);
if (i + 1 == ROW_COUNT) {
assertEquals(nr,null);
assertTrue(KeyValue.COMPARATOR.compareRows(nr,new KeyValue(Bytes.toBytes(i + 1),System.currentTimeMillis())) == 0);
}
assertTrue("Row name",KeyValue.COMPARATOR.compareRows(results.get(0),Bytes.toBytes(rowId)) == 0);
assertEquals("Count of columns",QUALIFIER_COUNT,results.size());
}