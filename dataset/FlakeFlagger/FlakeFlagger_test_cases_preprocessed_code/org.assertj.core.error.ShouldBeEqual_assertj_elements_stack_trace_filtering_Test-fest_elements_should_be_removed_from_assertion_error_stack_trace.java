@Test public void fest_elements_should_be_removed_from_assertion_error_stack_trace(){
assertThat("Xavi").isEqualTo("Xabi");
assertThat(hasStackTraceElementRelatedToAssertJ(assertionError)).isFalse();
}