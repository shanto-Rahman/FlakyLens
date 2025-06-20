@Test public void testAddAndGet() throws Exception {
assertEquals(3,get);
assertEquals(3,i1.get());
assertEquals(127 + 3,get);
assertEquals(127 + 3,i2.get());
assertEquals(2,get);
assertEquals(2,i3.get());
}