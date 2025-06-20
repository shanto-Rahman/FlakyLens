@Test public void should_pass_actual(){
AbstractByteArrayAssert<?> assertions=Assertions.assertThat(actual);
assertSame(actual,assertions.actual);
}