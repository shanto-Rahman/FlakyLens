@Test public void bufferShouldBeResetBetweenMessages() throws Exception {
Thread.yield();
assertNotNull(mma);
assertEquals(expectedEmailCount,mma.length);
assertFalse(body1.contains(msg0));
}