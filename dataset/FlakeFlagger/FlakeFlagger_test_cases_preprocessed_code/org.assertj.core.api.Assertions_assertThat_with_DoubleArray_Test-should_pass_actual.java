@Test public void should_pass_actual(){
AbstractDoubleArrayAssert<?> assertions=Assertions.assertThat(actual);
assertSame(actual,assertions.actual);
}