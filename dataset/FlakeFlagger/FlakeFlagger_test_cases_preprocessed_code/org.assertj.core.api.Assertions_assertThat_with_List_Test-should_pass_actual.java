@Test public void should_pass_actual(){
AbstractListAssert<?,? extends List<? extends String>,String> assertions=Assertions.assertThat(names);
assertSame(names,assertions.actual);
}