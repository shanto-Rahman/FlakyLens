@Test public void testDumpDirectory() throws Exception {
assertThat(application.getDumpDirectory(),equalTo("/dump"));
assertThat(parameters,hasEntry(Constants.DUMP_DIRECTORY,"/dump"));
}