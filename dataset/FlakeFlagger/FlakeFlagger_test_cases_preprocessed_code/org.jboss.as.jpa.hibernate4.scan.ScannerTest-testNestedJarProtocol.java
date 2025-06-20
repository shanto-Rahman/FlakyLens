@Test public void testNestedJarProtocol() throws Exception {
Closeable closeable=VFS.mountZip(nestedEarVirtualFile,nestedEarVirtualFile,tempFileProvider);//RW
Closeable closeable2=VFS.mountZip(parVirtualFile,parVirtualFile,tempFileProvider);//RW
closeable=VFS.mountZip(parVirtualFile,parVirtualFile,tempFileProvider);//RW
}