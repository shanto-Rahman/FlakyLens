@Test public void testGetAndDecrement() throws Exception {
assertEquals(0,get);
assertEquals(Integer.MAX_VALUE,i1.get());
assertEquals(127,get);
assertEquals(126,i2.get());
assertEquals(Integer.MAX_VALUE,get);
assertEquals(Integer.MAX_VALUE - 1,i3.get());
}