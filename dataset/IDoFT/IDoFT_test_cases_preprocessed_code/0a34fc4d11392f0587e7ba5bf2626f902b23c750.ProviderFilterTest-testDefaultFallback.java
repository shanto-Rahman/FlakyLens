@Test public void testDefaultFallback(){
assertNotNull(cn);
assertEquals(0,cn.passQps(),0.01);
}