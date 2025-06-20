@Test public void should_fail_if_other_is_not_a_readable_file(){
assertThat(e).hasMessage(format("The given Path <%s> to compare actual content to should be readable",other));
}