@Test public void should_pass_actual(){
AbstractIntArrayAssert<?> assertions=Assertions.assertThat(actual);
assertSame(actual,assertions.actual);
}