@Test public void testPushPoll(){
assertEquals(1,(int)q.poll());
assertNull(q.poll());
}