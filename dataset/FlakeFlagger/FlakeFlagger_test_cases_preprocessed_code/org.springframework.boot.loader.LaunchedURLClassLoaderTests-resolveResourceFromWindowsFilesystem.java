@Test public void resolveResourceFromWindowsFilesystem() throws Exception {
assertNull(getClass().getClassLoader().getResource("c:\\Users\\user\\bar.properties"));
assertNull(loader.getResource("c:\\Users\\user\\bar.properties"));
}