@Test public void should_pass_actual(){
AbstractFileAssert<?> assertions=Assertions.assertThat(actual);//RW
assertSame(actual,assertions.actual);//RW
}