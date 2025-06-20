@Test public void decodeGet() throws Exception {
assertThat(context.getCommandName(),equalTo("test"));
assertThat(context.isHttp(),is(true));
assertThat(context.getArgs(),arrayContaining("b","d"));
}