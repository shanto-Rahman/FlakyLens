@Test public void testPushPoll(){
  SpecializedMpscLinkedQueue<Integer> q=SpecializedMpscLinkedQueue.create();
  q.offer(1);
  assertEquals(1,(int)q.poll());
  assertNull(q.poll());
}
