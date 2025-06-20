@Test public void testIsFileDeletable() throws IOException, ReplicationException {
  Path file=new Path(root,"testIsFileDeletableWithNoHFileRefs");
  fs.createNewFile(file);
  assertTrue("Test file not created!",fs.exists(file));
  ReplicationHFileCleaner cleaner=new ReplicationHFileCleaner();
  cleaner.setConf(conf);
  assertTrue("Cleaner should allow to delete this file as there is no hfile reference node " + "for it in the queue.",cleaner.isFileDeletable(fs.getFileStatus(file)));
  List<Pair<Path,Path>> files=new ArrayList<>(1);
  files.add(new Pair<>(null,file));
  rq.addHFileRefs(peerId,files);
  assertFalse("Cleaner should not allow to delete this file as there is a hfile reference node " + "for it in the queue.",cleaner.isFileDeletable(fs.getFileStatus(file)));
}
