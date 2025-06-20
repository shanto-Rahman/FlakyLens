public void testIncrementColumnValue_ConcurrentFlush() throws IOException {
t.start();
assertEquals(value + amount,r);
}