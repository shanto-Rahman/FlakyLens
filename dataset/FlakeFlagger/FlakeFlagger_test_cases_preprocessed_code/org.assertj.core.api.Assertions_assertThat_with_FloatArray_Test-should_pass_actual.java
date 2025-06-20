@Test public void should_pass_actual(){
AbstractFloatArrayAssert<?> assertions=Assertions.assertThat(actual);
assertSame(actual,assertions.actual);
}