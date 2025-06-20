@Test public void test() throws ReplicationException {
STORAGE.addPeer(Integer.toString(i),getConfig(i),i % 2 == 0,SyncReplicationState.valueOf(i % 4));//RW
List<String> peerIds=STORAGE.listPeerIds();//RW
assertEquals(peerCount,peerIds.size());
assertConfigEquals(getConfig(seed),STORAGE.getPeerConfig(peerId));//RW
STORAGE.updatePeerConfig(Integer.toString(i),getConfig(i + 1));//RW
assertConfigEquals(getConfig(seed + 1),STORAGE.getPeerConfig(peerId));//RW
assertEquals(i % 2 == 0,STORAGE.isPeerEnabled(Integer.toString(i)));//RW
STORAGE.setPeerState(Integer.toString(i),i % 2 != 0);//RW
assertEquals(i % 2 != 0,STORAGE.isPeerEnabled(Integer.toString(i)));//RW
assertEquals(SyncReplicationState.valueOf(i % 4),STORAGE.getPeerSyncReplicationState(Integer.toString(i)));//RW
STORAGE.removePeer(toRemove);//RW
peerIds=STORAGE.listPeerIds();//RW
assertEquals(peerCount - 1,peerIds.size());
assertFalse(peerIds.contains(toRemove));
STORAGE.getPeerConfig(toRemove);//RW
fail("Should throw a ReplicationException when getting peer config of a removed peer");
}