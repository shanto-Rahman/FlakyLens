/** 
 * Test list ordering
 * @throws Exception
 */
public void testOrdering() throws Exception {
assertFalse(filterMPONE.filterAllRemaining());
assertFalse(filterMPONE.filterRowKey(rowkey,0,rowkey.length));
assertTrue(Filter.ReturnCode.INCLUDE == filterMPONE.filterKeyValue(kv));
assertFalse(filterMPONE.filterRow());
assertFalse(filterMPONE.filterRowKey(rowkey,0,rowkey.length));
assertTrue(Filter.ReturnCode.INCLUDE == filterMPONE.filterKeyValue(kv));
assertFalse(filterMPONE.filterRow());
assertFalse(filterMPONE.filterRowKey(rowkey,0,rowkey.length));
assertTrue(Filter.ReturnCode.INCLUDE == filterMPONE.filterKeyValue(kv));
assertFalse(filterMPONE.filterRow());
}