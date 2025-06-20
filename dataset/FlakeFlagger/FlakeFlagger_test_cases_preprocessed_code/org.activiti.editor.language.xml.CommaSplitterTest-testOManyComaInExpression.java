@Test public void testOManyComaInExpression(){
assertNotNull(result);
assertEquals(4,result.size());
assertEquals("${Everything,should,be,made,as,simple,as,possible}",result.get(0));
assertEquals("but",result.get(1));
assertEquals("no",result.get(2));
assertEquals("simpler",result.get(3));
}