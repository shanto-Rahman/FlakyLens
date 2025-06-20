@Test public void cancelOkHttpRequest() throws InterruptedException {
failureRef.set(t);
latch.countDown();
assertThat(call.isCanceled()).isTrue();
assertTrue(latch.await(10,SECONDS));
assertThat(failureRef.get()).isInstanceOf(IOException.class).hasMessage("Canceled");
}