@Test public void should_pass_actual(){
AbstractIterableAssert<?,? extends Iterable<? extends String>,String> assertions=Assertions.assertThat(names);
assertSame(names,assertions.actual);
}