/** 
 * Tests the the    {@link WhileMatchFilter}  works in combination with a {@link Filter}  that uses the {@link Filter#filterRowKey(byte[],int,int)}  method.See HBASE-2258.
 * @throws Exception
 */
public void testWhileMatchFilterWithFilterRowKey() throws Exception {
if (!isMoreResults || !Bytes.toString(values.get(0).getRow()).startsWith(prefix)) {
Assert.assertTrue("The WhileMatchFilter should now filter all remaining",filter.filterAllRemaining());
}
if (!isMoreResults) {
}
}