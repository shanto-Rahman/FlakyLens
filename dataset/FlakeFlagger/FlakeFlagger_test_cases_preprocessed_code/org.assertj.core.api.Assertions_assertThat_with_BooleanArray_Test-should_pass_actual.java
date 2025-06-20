@Test public void should_pass_actual(){
AbstractBooleanArrayAssert<?> assertions=Assertions.assertThat(actual);
assertSame(actual,assertions.actual);
}