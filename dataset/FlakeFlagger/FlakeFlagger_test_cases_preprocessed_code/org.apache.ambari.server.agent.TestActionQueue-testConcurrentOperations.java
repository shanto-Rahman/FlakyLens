@Test public void testConcurrentOperations() throws InterruptedException {
ActionQueueOperation[] enqueOperators=new ActionQueueOperation[threadCount];//RW
ActionQueueOperation[] dequeOperators=new ActionQueueOperation[threadCount];//RW
ActionQueueOperation[] dequeAllOperators=new ActionQueueOperation[threadCount];//RW
for (int i=0; i < threadCount; i++) //RW
t.start();
for (int i=0; i < threadCount; i++) //RW
t.start();
for (int i=0; i < threadCount; i++) //RW
t.start();
Thread.sleep(100);
for (int i=0; i < threadCount; i++) //RW
enqueOperators[i].stop();//IT
Thread.sleep(10);
if (aq.size(host) > 0) {
}
for (int i=0; i < threadCount; i++) //RW
dequeOperators[i].stop();//IT
dequeAllOperators[i].stop();//IT
for (int i=0; i < threadCount; i++) //RW
opsEnqueued+=enqueOperators[i].getOpCounts()[h];//IT
opsDequeued+=dequeOperators[i].getOpCounts()[h];//IT
opsDequeued+=dequeAllOperators[i].getOpCounts()[h];//IT
assertTrue(opsEnqueued != 0);
assertEquals(0,aq.size(hosts[h]));
LOG.info("Host: " + hosts[h] + ", opsEnqueued: "+ opsEnqueued+ ", opsDequeued: "+ opsDequeued);//RW
assertEquals(opsDequeued,opsEnqueued);
}