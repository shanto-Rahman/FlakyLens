@Test public void statelessWorkerDeactivationTest() throws ExecutionException, InterruptedException, TimeoutException {
set1.add(f.get(10,TimeUnit.SECONDS));
assertTrue(set1.size() > 1);
assertTrue(set1.size() <= 100);
clock.incrementTimeMillis(TimeUnit.MINUTES.toMillis(8));
clock.incrementTimeMillis(TimeUnit.MINUTES.toMillis(8));
set2.add(f.get(10,TimeUnit.SECONDS));
assertTrue(set2.size() > 1);
assertTrue(set2.size() <= 100);
assertTrue(set2.contains(theSurviving));
assertEquals(1,set2.size());
}