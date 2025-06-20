@Test(expected=IllegalArgumentException.class) public void assertPortInvalid(){
  SnapshotService snapshotService=new SnapshotService(getREG_CENTER(),-1);
  snapshotService.listen();
}
