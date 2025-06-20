@Test public void testIsFileDeletable() throws IOException, ReplicationException {
fs.createNewFile(file);//RW
assertTrue("Test file not created!",fs.exists(file));//RW
cleaner.setConf(conf);//RW
assertTrue("Cleaner should allow to delete this file as there is no hfile reference node " + "for it in the queue.",cleaner.isFileDeletable(fs.getFileStatus(file)));//RW
rq.addHFileRefs(peerId,files);//RW
assertFalse("Cleaner should not allow to delete this file as there is a hfile reference node " + "for it in the queue.",cleaner.isFileDeletable(fs.getFileStatus(file)));//RW
}