@Test public void should_pass_actual(){
AbstractMapAssert<?,? extends Map<Object,Object>,Object,Object> assertions=Assertions.assertThat(actual);
assertSame(actual,assertions.actual);
}