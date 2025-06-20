@Test public void testNothingHappensWhenApplicationSecretIsThere() throws Exception {
assertFalse(new File(baseDirWithoutTrailingSlash + "src/main/java/conf/application.conf").exists());//RO
assertFalse(new File(baseDirWithoutTrailingSlash + "src/main/java/conf/application.conf").exists());//RO
FileUtils.deleteDirectory(new File(baseDirWithoutTrailingSlash));//RO
}