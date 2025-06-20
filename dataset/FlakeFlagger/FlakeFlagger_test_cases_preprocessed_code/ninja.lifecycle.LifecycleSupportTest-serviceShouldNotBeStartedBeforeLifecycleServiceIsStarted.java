@Test public void serviceShouldNotBeStartedBeforeLifecycleServiceIsStarted(){
assertThat(MockService.started,equalTo(0));//RW
}