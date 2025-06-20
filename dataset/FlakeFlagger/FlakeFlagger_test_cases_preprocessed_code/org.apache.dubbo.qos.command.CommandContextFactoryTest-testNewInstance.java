@Test public void testNewInstance() throws Exception {
assertThat(context.getCommandName(),equalTo("test"));
assertThat(context.getCommandName(),equalTo("command"));
assertThat(context.getArgs(),Matchers.arrayContaining("hello"));
assertTrue(context.isHttp());
}