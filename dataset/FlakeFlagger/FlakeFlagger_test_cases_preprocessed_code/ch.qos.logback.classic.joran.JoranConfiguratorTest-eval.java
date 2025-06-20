@Test public void eval() throws JoranException {
assertNotNull(slAppender);
assertEquals(2,slAppender.strList.size());
assertTrue(slAppender.strList.get(0).contains(" DEBUG - toto"));
assertTrue(str1.contains("Caller+0"));
assertTrue(str1.contains(" DEBUG - hello world"));
}