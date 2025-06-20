@Test public void randomMessages() throws Exception {
assertEquals(messages.size(),queue.size());
assertArrayEquals(messages.remove().getRight(),queue.remove().getRight());
}