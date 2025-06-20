@Test public void updateConcurrent() throws Exception {
if (current == null) {
}
if (current == null) {
}
List<Future<Boolean>> all=Executors.newFixedThreadPool(10).invokeAll(tasks);
assertTrue(future.get(1,TimeUnit.SECONDS));
assertEquals(new Integer(0),repository.findOne("foo"));
}