@Test public void fest_elements_should_be_removed_from_assertion_error_stack_trace(){
assertThat(5).isLessThan(0);
assertThat(hasStackTraceElementRelatedToAssertJ(assertionError)).isFalse();
}