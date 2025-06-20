@Test public void onDisconnectDoesNothing(){
  AtomicLongSequence atomicLongSequence=spy(new AtomicLongSequence());
  atomicLongSequence.onDisconnect();
  verify(atomicLongSequence).onDisconnect();
  verifyNoMoreInteractions(atomicLongSequence);
}
