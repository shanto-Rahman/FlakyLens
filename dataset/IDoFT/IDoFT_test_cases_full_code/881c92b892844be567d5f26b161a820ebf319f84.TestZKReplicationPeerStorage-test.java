@Test public void test() throws ReplicationException {
  int peerCount=10;
  for (int i=0; i < peerCount; i++) {
    STORAGE.addPeer(Integer.toString(i),getConfig(i),i % 2 == 0,SyncReplicationState.valueOf(i % 4));
  }
  List<String> peerIds=STORAGE.listPeerIds();
  assertEquals(peerCount,peerIds.size());
  for (  String peerId : peerIds) {
    int seed=Integer.parseInt(peerId);
    assertConfigEquals(getConfig(seed),STORAGE.getPeerConfig(peerId));
  }
  for (int i=0; i < peerCount; i++) {
    STORAGE.updatePeerConfig(Integer.toString(i),getConfig(i + 1));
  }
  for (  String peerId : peerIds) {
    int seed=Integer.parseInt(peerId);
    assertConfigEquals(getConfig(seed + 1),STORAGE.getPeerConfig(peerId));
  }
  for (int i=0; i < peerCount; i++) {
    assertEquals(i % 2 == 0,STORAGE.isPeerEnabled(Integer.toString(i)));
  }
  for (int i=0; i < peerCount; i++) {
    STORAGE.setPeerState(Integer.toString(i),i % 2 != 0);
  }
  for (int i=0; i < peerCount; i++) {
    assertEquals(i % 2 != 0,STORAGE.isPeerEnabled(Integer.toString(i)));
  }
  for (int i=0; i < peerCount; i++) {
    assertEquals(SyncReplicationState.valueOf(i % 4),STORAGE.getPeerSyncReplicationState(Integer.toString(i)));
  }
  String toRemove=Integer.toString(peerCount / 2);
  STORAGE.removePeer(toRemove);
  peerIds=STORAGE.listPeerIds();
  assertEquals(peerCount - 1,peerIds.size());
  assertFalse(peerIds.contains(toRemove));
  try {
    STORAGE.getPeerConfig(toRemove);
    fail("Should throw a ReplicationException when getting peer config of a removed peer");
  }
 catch (  ReplicationException e) {
  }
}
