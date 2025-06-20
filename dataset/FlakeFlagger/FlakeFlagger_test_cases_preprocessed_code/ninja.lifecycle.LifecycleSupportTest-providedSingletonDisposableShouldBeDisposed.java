@Test public void providedSingletonDisposableShouldBeDisposed(){
assertThat(MockSingletonService.disposed,equalTo(1));//RW
}