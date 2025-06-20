@Test public void providedSingletonStartableShouldBeStarted(){
assertThat(MockSingletonService.started,equalTo(1));//RW
}