@Test @SuppressWarnings("deprecation") public void testPriority() throws Exception {
assertEquals(0,getPriorityIncrementCallCount("A"));
assertEquals(3,getPriorityIncrementCallCount("A"));
assertEquals(0,getPriorityIncrementCallCount("B"));
assertEquals(1,getPriorityIncrementCallCount("B"));
assertEquals(0,getPriorityIncrementCallCount("C"));
assertEquals(0,getPriorityIncrementCallCount("C"));
assertEquals(1,getPriorityIncrementCallCount("A"));
assertEquals(1,getPriorityIncrementCallCount("A"));
assertEquals(2,getPriorityIncrementCallCount("A"));
assertEquals(2,getPriorityIncrementCallCount("A"));
assertTrue("Get expected JMX of CallVolumeSummary before decay",cvs1.equals("{\"A\":6,\"B\":2,\"C\":2}"));
assertTrue("Get expected JMX for CallVolumeSummary after decay",cvs2.equals("{\"A\":3,\"B\":1,\"C\":1}"));
}