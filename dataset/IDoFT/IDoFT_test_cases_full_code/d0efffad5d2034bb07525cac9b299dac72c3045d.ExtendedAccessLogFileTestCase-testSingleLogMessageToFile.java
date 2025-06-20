@Test public void testSingleLogMessageToFile() throws IOException, InterruptedException {
  Path directory=logDirectory;
  Path logFileName=directory.resolve("extended.log");
  DefaultAccessLogReceiver logReceiver=DefaultAccessLogReceiver.builder().setLogWriteExecutor(DefaultServer.getWorker()).setOutputDirectory(directory).setLogBaseName("extended.").setLogFileHeaderGenerator(new ExtendedAccessLogParser.ExtendedAccessLogHeaderGenerator(PATTERN)).build();
  verifySingleLogMessageToFile(logFileName,logReceiver);
}
