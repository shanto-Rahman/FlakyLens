@Test public void testEmitSingleLongTimeRt(){
assertNotNull(cn);
assertEquals(1000,cn.avgRt(),20);
}