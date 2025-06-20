@Test public void returnsUnhealthyIfDeadlocks() throws Exception {
assertThat(healthCheck.execute(),is(HealthCheck.Result.unhealthy("Deadlocked threads detected:\n" + "thread1\n" + "thread2\n")));
}