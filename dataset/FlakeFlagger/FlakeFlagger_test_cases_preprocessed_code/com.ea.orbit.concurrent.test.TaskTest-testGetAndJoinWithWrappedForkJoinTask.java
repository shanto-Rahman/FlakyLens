@Test public void testGetAndJoinWithWrappedForkJoinTask() throws ExecutionException, InterruptedException {
final ForkJoinTask<String> task=ForkJoinTask.adapt(() -> "bla");
assertFalse(t1.isDone());
task.invoke();
assertEquals("bla",t1.join());
assertTrue(t1.isDone());
assertEquals("bla",t1.join());
assertEquals("bla",t1.get());
}