@Test public void testAppendParameters4() throws Exception {
TestCase.assertEquals("one",parameters.get("key.1"));
TestCase.assertEquals("two",parameters.get("key.2"));
TestCase.assertEquals("1",parameters.get("num"));
TestCase.assertEquals("hello%2Fworld",parameters.get("naming"));
TestCase.assertEquals("30",parameters.get("age"));
}