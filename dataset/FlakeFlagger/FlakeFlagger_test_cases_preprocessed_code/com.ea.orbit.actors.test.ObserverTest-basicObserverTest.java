@Test public void basicObserverTest() throws ExecutionException, InterruptedException {
assertNotNull(observerReference);
assertNotNull(m);
assertEquals("bla",m.getRight());
}