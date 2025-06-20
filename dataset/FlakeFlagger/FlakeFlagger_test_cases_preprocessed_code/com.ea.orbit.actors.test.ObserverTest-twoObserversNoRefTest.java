@Test public void twoObserversNoRefTest() throws ExecutionException, InterruptedException {
assertNotNull(m);
assertEquals("bla",m.getRight());
assertNotNull(m2);
assertEquals("bla",m2.getRight());
}