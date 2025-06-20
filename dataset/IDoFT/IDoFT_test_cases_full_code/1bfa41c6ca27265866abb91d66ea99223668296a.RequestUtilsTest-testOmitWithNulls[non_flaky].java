/** 
 * Test omit with nulls.
 */
@Test public void testOmitWithNulls(){
  final Map<String,Object> params=createMap();
  Map<String,Object> omitted=RequestUtils.omit(params);
  assertTrue(omitted.keySet().containsAll(Lists.newArrayList("A","B","C","D")));
  assertTrue(omitted.values().containsAll(Lists.newArrayList(1,2,3,4)));
  assertNull(RequestUtils.omit(null));
}
