@Test public void should_fail_if_no_throwable_was_thrown(){
assertThat(e).hasMessage("Expecting code to raise a throwable.");
}