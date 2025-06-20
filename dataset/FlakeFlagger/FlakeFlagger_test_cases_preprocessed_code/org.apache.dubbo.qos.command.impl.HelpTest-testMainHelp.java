@Test public void testMainHelp() throws Exception {
assertThat(output,containsString("greeting"));
assertThat(output,containsString("help"));
assertThat(output,containsString("ls"));
assertThat(output,containsString("online"));
assertThat(output,containsString("offline"));
assertThat(output,containsString("quit"));
}