@Test public void createDefaultDirectoryManagerPath() throws IOException {
assertTrue(dm instanceof DirectoryManagerImpl);
assertTrue(dmi.readOnly);
assertEquals(path,dmi.directory);
}