@Test public void serviceShouldNotBeStartedIfExplicitlyBoundAndNotSingleton(){
assertThat(MockService.started,equalTo(0));//RW
}