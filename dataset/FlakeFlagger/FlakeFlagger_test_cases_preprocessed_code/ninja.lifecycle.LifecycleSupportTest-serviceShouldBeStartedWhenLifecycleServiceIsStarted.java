@Test public void serviceShouldBeStartedWhenLifecycleServiceIsStarted(){
assertThat(MockService.started,equalTo(1));//RW
}