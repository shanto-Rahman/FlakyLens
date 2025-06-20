/** 
 * Test the overridden functionality of filterKeyValue(KeyValue)
 * @throws Exception
 */
public void testFilterKeyValue() throws Exception {
assertTrue("otherColumn",filter.filterKeyValue(kv) == Filter.ReturnCode.INCLUDE);
assertTrue("testedMatch",filter.filterKeyValue(kv) == Filter.ReturnCode.SKIP);
assertTrue("otherColumn",filter.filterKeyValue(kv) == Filter.ReturnCode.INCLUDE);
assertFalse("allRemainingWhenMatch",filter.filterAllRemaining());
assertTrue("otherColumn",filter.filterKeyValue(kv) == Filter.ReturnCode.INCLUDE);
assertTrue("testedMismatch",filter.filterKeyValue(kv) == Filter.ReturnCode.NEXT_ROW);
assertTrue("otherColumn",filter.filterKeyValue(kv) == Filter.ReturnCode.NEXT_ROW);
}