@Test public void testZippedJar() throws Exception {
Closeable closeable=VFS.mountZip(virtualFile,virtualFile,tempFileProvider);//RW
}