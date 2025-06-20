@Test public void should_pass_actual(){
AbstractCharArrayAssert<?> assertions=Assertions.assertThat(actual);
assertSame(actual,assertions.actual);
}