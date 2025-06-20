@Test public void test() throws InterruptedException {
assertNull(threadA.x0);
assertEquals("a",threadA.x1);
assertNull(threadA.x2);
assertNull(threadB.x0);
assertEquals("b",threadB.x1);
assertNull(threadB.x2);
}