public void testLocks() throws IOException {
assertEquals(rowid,region.getRowFromLock(lockids[i]));
LOG.debug(getName() + " locked " + Bytes.toString(rowid));
LOG.debug(getName() + " set " + Integer.toString(lockCount)+ " locks");
LOG.debug(getName() + " unlocked " + i);
LOG.debug(getName() + " released " + Integer.toString(lockCount)+ " locks");
t.start();
while (t.isAlive()) {
  try {
    Thread.sleep(1);
  }
 catch (  InterruptedException e) {
  }
}
Thread.sleep(1);
}