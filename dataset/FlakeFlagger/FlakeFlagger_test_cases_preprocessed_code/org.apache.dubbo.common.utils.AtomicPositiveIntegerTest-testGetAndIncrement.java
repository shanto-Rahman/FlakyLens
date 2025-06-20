@Test public void testGetAndIncrement() throws Exception {
assertEquals(0,get);
assertEquals(1,i1.get());
assertEquals(127,get);
assertEquals(128,i2.get());
assertEquals(Integer.MAX_VALUE,get);
assertEquals(0,i3.get());
}