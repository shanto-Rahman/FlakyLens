@Test(expected=MojoExecutionException.class) public void shouldReportAllErrorsWhenFailFastIsFalse() throws Exception {
assertEquals(2,lintReport.getReports().size());
}