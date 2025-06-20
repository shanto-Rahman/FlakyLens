@Test public void testUsernameExtractionEnvVarOverrride() throws Throwable {
  String whoami=RegistryUtils.getCurrentUsernameUnencoded("drwho");
  assertEquals("drwho",whoami);
}
