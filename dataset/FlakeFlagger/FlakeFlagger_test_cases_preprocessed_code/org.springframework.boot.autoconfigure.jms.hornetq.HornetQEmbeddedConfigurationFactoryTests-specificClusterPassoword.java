@Test public void specificClusterPassoword() throws Exception {
assertThat(configuration.getClusterPassword(),equalTo("password"));
}