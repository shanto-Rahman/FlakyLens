@Test public void testIsTerminated() throws Exception {
when(executor.isTerminated()).thenReturn(true);
assertThat(ExecutorUtil.isTerminated(executor),is(true));
assertThat(ExecutorUtil.isTerminated(executor2),is(false));
}