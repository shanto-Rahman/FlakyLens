@Test public void serviceShouldBeStartedIfExplicitlyBoundAsSingleton(){
assertThat(MockService.started,equalTo(1));//RW
}