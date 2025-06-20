@Test public void test() throws Exception {
assertThat(context.getCommandName(),equalTo("test"));
assertThat(context.getArgs(),arrayContaining("hello"));
assertThat(context.getOrginRequest(),is(request));
assertTrue(context.isHttp());
assertThat(context.getRemote(),is(channel));
assertThat(context.getCommandName(),equalTo("command"));
assertThat(context.getArgs(),arrayContaining("world"));
assertThat(context.getOrginRequest(),is(request));
assertFalse(context.isHttp());
assertThat(context.getRemote(),is(channel));
}