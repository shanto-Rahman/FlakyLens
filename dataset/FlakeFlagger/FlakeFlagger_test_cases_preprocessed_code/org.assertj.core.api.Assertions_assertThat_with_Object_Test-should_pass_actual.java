@Test public void should_pass_actual(){
AbstractObjectAssert<?,Object> assertions=Assertions.assertThat(actual);
assertSame(actual,assertions.actual);
}