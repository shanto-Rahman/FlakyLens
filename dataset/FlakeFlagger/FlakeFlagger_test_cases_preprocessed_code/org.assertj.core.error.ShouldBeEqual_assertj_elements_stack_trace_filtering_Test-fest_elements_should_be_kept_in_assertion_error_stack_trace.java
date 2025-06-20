@Test public void fest_elements_should_be_kept_in_assertion_error_stack_trace(){
assertThat("Messi").isEqualTo("Ronaldo");
assertThat(hasStackTraceElementRelatedToAssertJ(assertionError)).isTrue();
}