/** 
 * Tests the the    {@link WhileMatchFilter}  works in combination with a {@link Filter}  that uses the {@link Filter#filterKeyValue(org.apache.hadoop.hbase.KeyValue)}  method.See HBASE-2258.
 * @throws Exception
 */
public void testWhileMatchFilterWithFilterKeyValue() throws Exception {
Assert.assertTrue("The WhileMatchFilter should now filter all remaining",filter.filterAllRemaining());
if (!isMoreResults) {
}
}