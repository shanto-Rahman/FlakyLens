/** 
 * Test pick with nulls.
 */
@Test public void testPickWithNulls(){
assertTrue(omitted.keySet().containsAll(Lists.newArrayList("A","B","C","D")));
assertTrue(omitted.values().containsAll(Lists.newArrayList(1,2,3,4)));
assertNull(RequestUtils.pick(null));
}