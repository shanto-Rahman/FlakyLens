@Test public void testCreateBadTables() throws IOException {
assertTrue("Unexcepted exception message " + msg,msg != null && msg.startsWith(IllegalArgumentException.class.getName()) && msg.contains(HTableDescriptor.ROOT_TABLEDESC.getNameAsString()));
assertTrue("Unexcepted exception message " + msg,msg != null && msg.startsWith(IllegalArgumentException.class.getName()) && msg.contains(HTableDescriptor.META_TABLEDESC.getNameAsString()));
successes.incrementAndGet();
failures.incrementAndGet();
throw new RuntimeException("Failed threaded create" + getName(),e);
threads[i].start();
while (threads[i].isAlive()) {
  try {
    Thread.sleep(1000);
  }
 catch (  InterruptedException e) {
  }
}
Thread.sleep(1000);
assertEquals(1,successes.get());
assertEquals(count - 1,failures.get());
}