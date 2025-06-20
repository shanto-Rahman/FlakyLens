@Test public void testInputStreamZippedJar() throws Exception {
Closeable closeable=VFS.mountZip(virtualFile,virtualFile,tempFileProvider);//RW
}