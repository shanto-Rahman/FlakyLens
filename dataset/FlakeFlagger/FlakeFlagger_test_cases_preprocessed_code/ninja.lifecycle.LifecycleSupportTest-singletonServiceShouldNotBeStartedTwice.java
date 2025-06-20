@Test public void singletonServiceShouldNotBeStartedTwice(){
assertThat(MockSingletonService.started,equalTo(1));//RW
}