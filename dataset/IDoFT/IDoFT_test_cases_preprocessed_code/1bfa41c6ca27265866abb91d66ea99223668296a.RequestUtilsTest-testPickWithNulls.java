/** 
 * Test pick with nulls.
 */
@Test public void testPickWithNulls(){
assertEquals(params.keySet().toArray(),RequestUtils.pick(params).keySet().toArray());
assertEquals(params.values().toArray(),RequestUtils.pick(params).values().toArray());
assertNull(RequestUtils.pick(null));
}