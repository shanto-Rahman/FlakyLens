@Test public void should_pass_actual(){
AbstractCharSequenceAssert<?,?> assertions=Assertions.assertThat(actual);
assertSame(actual,assertions.actual);
}