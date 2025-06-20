@Test public void disposablesShouldBeDisposedOf(){
assertThat(MockService.disposed,equalTo(1));//RW
}