@Test public void testGreeting() throws Exception {
assertThat(output,containsString("COMMAND NAME"));
assertThat(output,containsString("greeting"));
assertThat(output,containsString("EXAMPLE"));
assertThat(output,containsString("greeting dubbo"));
}