@Test public void fail_with_good_message_when_assertion_is_failing(){
assertThat(ae).hasMessageContaining("Expecting message:").hasMessageContaining("<\"yo\">").hasMessageContaining("but was:").hasMessageContaining("<\"boom\">");
}