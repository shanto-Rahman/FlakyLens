@Test public void testGetKey(){
Assert.assertEquals(StaticContext.getKey(url,method,suffix),StaticContext.getKey(para,method,suffix));
}