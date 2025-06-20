@Test public void testLegacyConfigurations() throws Exception {
if (Files.isDirectory(path)) {
if (pattern.matcher(name).matches()) {
}
}
Assert.assertFalse("No configs were found",configs.isEmpty());
}