@Test public void should_reinit_batch_context_and_consistency_after_exception() throws Exception {
assertThat(exceptionCaught).isTrue();
Thread.sleep(1000);
}