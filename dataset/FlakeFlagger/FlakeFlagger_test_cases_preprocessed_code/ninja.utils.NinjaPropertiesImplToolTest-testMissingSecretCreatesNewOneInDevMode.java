@Test public void testMissingSecretCreatesNewOneInDevMode() throws Exception {
assertTrue(compositeConfiguration.getString(NinjaConstant.applicationSecret).length() == 64);
assertTrue(defaultConfiguration.getString(NinjaConstant.applicationSecret).length() == 64);
assertTrue(Files.toString(new File(devConf),Charsets.UTF_8).contains(NinjaConstant.applicationSecret));//RO
FileUtils.deleteDirectory(new File(baseDirWithoutTrailingSlash));//RO
}