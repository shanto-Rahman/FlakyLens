@Test public void should_pass_actual(){
AbstractCharSequenceAssert<?,?> assertions=Assertions.assertThat((CharSequence)actual);
assertSame(actual,assertions.actual);
}