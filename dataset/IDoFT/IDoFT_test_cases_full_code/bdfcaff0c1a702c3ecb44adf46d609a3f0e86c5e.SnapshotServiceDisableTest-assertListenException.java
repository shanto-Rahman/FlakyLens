@Test @SneakyThrows public void assertListenException(){
  ServerSocket serverSocket=new ServerSocket(9898);
  SnapshotService snapshotService=new SnapshotService(getREG_CENTER(),9898);
  snapshotService.listen();
  serverSocket.close();
  Field field=snapshotService.getClass().getDeclaredField("serverSocket");
  field.setAccessible(true);
  assertNull(field.get(snapshotService));
}
