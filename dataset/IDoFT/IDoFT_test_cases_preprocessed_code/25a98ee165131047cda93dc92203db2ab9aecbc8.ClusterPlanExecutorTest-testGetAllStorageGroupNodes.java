@Test public void testGetAllStorageGroupNodes(){
assertEquals(IoTDB.metaManager.getAllStorageGroupNodes().get(i).getFullPath(),allStorageGroupNodes.get(i).getFullPath());
}