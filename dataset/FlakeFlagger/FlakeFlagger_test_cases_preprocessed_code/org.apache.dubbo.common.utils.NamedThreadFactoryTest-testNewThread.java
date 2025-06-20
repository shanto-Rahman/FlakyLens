@Test public void testNewThread() throws Exception {
assertThat(t.getName(),allOf(containsString("pool-"),containsString("-thread-")));
assertFalse(t.isDaemon());
assertSame(t.getThreadGroup(),Thread.currentThread().getThreadGroup());
}