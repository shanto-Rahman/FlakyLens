@Test public void testIncrementAndGet() throws Exception {
assertEquals(1,get);
assertEquals(1,i1.get());
assertEquals(128,get);
assertEquals(128,i2.get());
assertEquals(0,get);
assertEquals(0,i3.get());
}