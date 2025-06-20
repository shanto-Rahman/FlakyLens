@Test public void testDecrementAndGet() throws Exception {
assertEquals(Integer.MAX_VALUE,get);
assertEquals(Integer.MAX_VALUE,i1.get());
assertEquals(126,get);
assertEquals(126,i2.get());
assertEquals(Integer.MAX_VALUE - 1,get);
assertEquals(Integer.MAX_VALUE - 1,i3.get());
}