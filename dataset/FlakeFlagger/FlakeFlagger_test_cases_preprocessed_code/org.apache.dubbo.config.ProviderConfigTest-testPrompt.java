@Test public void testPrompt() throws Exception {
assertThat(provider.getPrompt(),equalTo("#"));
assertThat(parameters,hasEntry("prompt","%23"));
}