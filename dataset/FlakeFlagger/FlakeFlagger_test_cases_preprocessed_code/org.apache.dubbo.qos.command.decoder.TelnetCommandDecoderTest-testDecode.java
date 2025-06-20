@Test public void testDecode() throws Exception {
assertThat(context.getCommandName(),equalTo("test"));
assertThat(context.isHttp(),is(false));
assertThat(context.getArgs(),arrayContaining("a","b"));
}