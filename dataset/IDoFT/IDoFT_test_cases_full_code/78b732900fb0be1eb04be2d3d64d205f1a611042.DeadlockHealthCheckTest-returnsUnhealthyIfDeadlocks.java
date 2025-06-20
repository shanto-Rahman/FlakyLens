@Test public void returnsUnhealthyIfDeadlocks() throws Exception {
  final Set<String> threads=new HashSet<String>();
  threads.add("thread1");
  threads.add("thread2");
  when(vm.getDeadlockedThreads()).thenReturn(threads);
  assertThat(healthCheck.execute(),is(HealthCheck.Result.unhealthy("Deadlocked threads detected:\n" + "thread1\n" + "thread2\n")));
}
