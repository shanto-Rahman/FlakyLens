@Test public void nonSingletonServicesShouldBeInstantiatedForEachInstance(){
assertThat(MockService.started,equalTo(2));//RW
}