@Test public void logsOutput() throws Exception {
assertThat(l,containsString("not a web application (OnWebApplicationCondition)"));
}