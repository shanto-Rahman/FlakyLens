@Test public void testGetAndAnd() throws Exception {
assertEquals(0,get);
assertEquals(3,i1.get());
assertEquals(127,get);
assertEquals(127 + 3,i2.get());
assertEquals(Integer.MAX_VALUE,get);
assertEquals(2,i3.get());
}