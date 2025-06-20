@Test public void testCommaAtEnd(){
assertNotNull(result);
assertEquals(2,result.size());
assertEquals("first",result.get(0));
assertEquals("second",result.get(1));
}