@Test public void should_pass_actual(){
AbstractObjectArrayAssert<?,Object> assertions=Assertions.assertThat(actual);
assertSame(actual,assertions.actual);
}