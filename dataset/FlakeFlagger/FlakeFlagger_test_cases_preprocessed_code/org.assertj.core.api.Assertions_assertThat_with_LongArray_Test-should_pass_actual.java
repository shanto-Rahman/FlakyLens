@Test public void should_pass_actual(){
AbstractLongArrayAssert<?> assertions=Assertions.assertThat(actual);
assertSame(actual,assertions.actual);
}