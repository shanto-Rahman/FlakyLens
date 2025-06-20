@Test public void renameToNonExistingDirectory() throws IOException, RolloverFailure {
renameUtil.rename(fromFile.toString(),new File(randomTARGETDir + "/to.test").toString());//RO
assertTrue(statusChecker.isErrorFree(0));
}