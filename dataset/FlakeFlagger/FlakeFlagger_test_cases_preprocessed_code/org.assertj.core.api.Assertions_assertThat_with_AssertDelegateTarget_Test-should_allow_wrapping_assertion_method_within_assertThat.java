@Test public void should_allow_wrapping_assertion_method_within_assertThat(){
assertThat(assertion).isCompletelyTrue();
Object result=assertThat(assertion);
assertThat(result).isSameAs(assertion);
}