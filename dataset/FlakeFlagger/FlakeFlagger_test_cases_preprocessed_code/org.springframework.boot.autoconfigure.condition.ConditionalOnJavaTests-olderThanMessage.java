@Test public void olderThanMessage() throws Exception {
assertThat(outcome.getMessage(),equalTo("Required JVM version " + "older than 1.6 found 1.7"));
}