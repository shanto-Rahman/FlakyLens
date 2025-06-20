@Test public void testLongTextMessage() throws Exception {
resultQueue.addLast(data);
resultQueue.add("FAILED " + error);
String res=resultQueue.poll(10,TimeUnit.SECONDS);
Assert.assertEquals(message,res);
}