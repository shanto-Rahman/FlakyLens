@Test(expected=MojoExecutionException.class) public void shouldReportOnlyFirstErrorWhenFailFastIsTrue() throws Exception {
assertEquals(1,lintReport.getReports().size());
}