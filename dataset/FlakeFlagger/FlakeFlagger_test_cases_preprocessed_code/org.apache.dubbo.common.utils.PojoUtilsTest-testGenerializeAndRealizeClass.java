@Test public void testGenerializeAndRealizeClass() throws Exception {
assertEquals(Integer.class.getName(),generalize);
assertEquals(Integer.class,real);
assertEquals(int[].class.getName(),generalize);
assertEquals(int[].class,real);
}