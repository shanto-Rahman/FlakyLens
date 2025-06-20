@Test public void testJarProtocol() throws Exception {
Closeable closeable=VFS.mountZip(warVirtualFile,warVirtualFile,tempFileProvider);//RW
}