@Test public void equalOrNewerMessage() throws Exception {
assertThat(outcome.getMessage(),equalTo("Required JVM version " + "1.6 or newer found 1.7"));
}