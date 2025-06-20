@Test public void testGetAllStorageGroupNodes(){
  List<IStorageGroupMNode> allStorageGroupNodes=queryExecutor.getAllStorageGroupNodes();
  for (int i=0; i < allStorageGroupNodes.size(); i++) {
    assertEquals(IoTDB.metaManager.getAllStorageGroupNodes().get(i).getFullPath(),allStorageGroupNodes.get(i).getFullPath());
  }
}
