/** 
 * Test "must pass one"
 * @throws Exception
 */
public void testMPONE() throws Exception {
assertFalse(filterMPONE.filterAllRemaining());
assertFalse(filterMPONE.filterRowKey(rowkey,0,rowkey.length));
assertFalse(filterMPONE.filterRow());
assertTrue(Filter.ReturnCode.INCLUDE == filterMPONE.filterKeyValue(kv));
assertFalse(filterMPONE.filterRowKey(rowkey,0,rowkey.length));
assertFalse(filterMPONE.filterRow());
assertTrue(Filter.ReturnCode.INCLUDE == filterMPONE.filterKeyValue(kv));
assertFalse(filterMPONE.filterRowKey(rowkey,0,rowkey.length));
assertFalse(filterMPONE.filterRow());
assertTrue(Filter.ReturnCode.INCLUDE == filterMPONE.filterKeyValue(kv));
assertTrue(filterMPONE.filterRowKey(rowkey,0,rowkey.length));
assertTrue(filterMPONE.filterRow());
assertTrue(filterMPONE.filterAllRemaining());
}