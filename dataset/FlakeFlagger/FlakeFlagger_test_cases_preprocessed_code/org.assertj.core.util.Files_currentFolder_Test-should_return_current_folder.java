@Test public void should_return_current_folder() throws IOException {
File e=new File(".");//RO
assertEquals(e.getCanonicalPath(),a.getCanonicalPath());
}