/** 
 * Test omit with nulls.
 */
@Test public void testOmitWithNulls(){
  final Map<String,Object> params=createMap();
  assertEquals(params.keySet().toArray(),RequestUtils.omit(params).keySet().toArray());
  assertEquals(params.values().toArray(),RequestUtils.omit(params).values().toArray());
  assertNull(RequestUtils.omit(null));
}
