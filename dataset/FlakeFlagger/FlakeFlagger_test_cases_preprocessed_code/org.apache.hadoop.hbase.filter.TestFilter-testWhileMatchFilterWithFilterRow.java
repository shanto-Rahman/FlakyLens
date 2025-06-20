/** 
 * Tests the the    {@link WhileMatchFilter}  works in combination with a {@link Filter}  that uses the {@link Filter#filterRow()}  method.See HBASE-2258.
 * @throws Exception
 */
public void testWhileMatchFilterWithFilterRow() throws Exception {
if (scannerCounter >= pageSize) {
Assert.assertTrue("The WhileMatchFilter should now filter all remaining",filter.filterAllRemaining());
}
if (!isMoreResults) {
}
Assert.assertEquals("The page filter returned more rows than expected",pageSize,scannerCounter);
}