@Test public void findNonBooleanGetter() throws Exception {
assertNotNull(getter);
assertEquals("getA",getter.getName());
}