@Test public void generatedClusterPassoword() throws Exception {
assertThat(configuration.getClusterPassword().length(),equalTo(36));
}