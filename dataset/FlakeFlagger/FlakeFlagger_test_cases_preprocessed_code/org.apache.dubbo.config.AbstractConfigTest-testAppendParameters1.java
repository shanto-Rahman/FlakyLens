@Test public void testAppendParameters1() throws Exception {
TestCase.assertEquals("one",parameters.get("prefix.key.1"));
TestCase.assertEquals("two",parameters.get("prefix.key.2"));
TestCase.assertEquals("ONE,one,1",parameters.get("prefix.num"));
TestCase.assertEquals("hello%2Fworld",parameters.get("prefix.naming"));
TestCase.assertEquals("30",parameters.get("prefix.age"));
TestCase.assertFalse(parameters.containsKey("prefix.key-2"));
TestCase.assertFalse(parameters.containsKey("prefix.secret"));
}