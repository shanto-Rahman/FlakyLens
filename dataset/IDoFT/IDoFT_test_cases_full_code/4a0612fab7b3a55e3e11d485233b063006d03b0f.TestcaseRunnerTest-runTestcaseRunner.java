@Test public void runTestcaseRunner() throws Exception {
  File targetDirectory=new File("target/test/testcaseRunnerResult");
  targetDirectory.mkdirs();
  System.setProperty("OUT_DIRECTORY",targetDirectory.getAbsolutePath());
  TestcaseRunner.main(new String[]{});
}
