@Test public void integrationAutoConfigEmbeddedTest() throws Exception {
assertThat(output,containsString("OK (1 test)"));
}