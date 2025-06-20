/** 
 * Test "must pass all"
 * @throws Exception
 */
public void testMPALL() throws Exception {
assertFalse(filterMPALL.filterAllRemaining());
assertFalse(filterMPALL.filterRowKey(rowkey,0,rowkey.length));
assertTrue(Filter.ReturnCode.INCLUDE == filterMPALL.filterKeyValue(kv));
assertTrue(filterMPALL.filterRowKey(rowkey,0,rowkey.length));
assertTrue(Filter.ReturnCode.NEXT_ROW == filterMPALL.filterKeyValue(kv));
assertTrue(filterMPALL.filterRow());
}