@Test public void serviceShouldBeStartedIfExplicitlyBoundAndSingleton(){
assertThat(MockSingletonService.started,equalTo(1));//RW
}