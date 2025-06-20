@Test public void should_fail_with_message_having_args(){
assertThat(e).hasMessage("fail 5 times");
}