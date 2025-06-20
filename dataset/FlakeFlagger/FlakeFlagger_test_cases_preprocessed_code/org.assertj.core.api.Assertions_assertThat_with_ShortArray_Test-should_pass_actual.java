@Test public void should_pass_actual(){
AbstractShortArrayAssert<?> assertions=Assertions.assertThat(actual);
assertSame(actual,assertions.actual);
}