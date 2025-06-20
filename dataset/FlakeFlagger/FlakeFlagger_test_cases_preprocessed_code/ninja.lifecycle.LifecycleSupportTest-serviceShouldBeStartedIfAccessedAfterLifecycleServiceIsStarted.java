@Test public void serviceShouldBeStartedIfAccessedAfterLifecycleServiceIsStarted(){
assertThat(MockService.started,equalTo(1));//RW
}