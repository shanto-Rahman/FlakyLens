@Test public void testCommaAtStartAndEnd(){
assertNotNull(result);
assertEquals(2,result.size());
assertEquals("first",result.get(0));
assertEquals("second",result.get(1));
}