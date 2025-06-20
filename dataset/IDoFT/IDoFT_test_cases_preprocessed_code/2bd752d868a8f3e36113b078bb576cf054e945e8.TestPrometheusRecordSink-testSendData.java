@Test public void testSendData() throws IOException, InitializationException {
assertNotNull(writeResult);
assertEquals(2,writeResult.getRecordCount());
assertEquals("Hello",writeResult.getAttributes().get("a"));
assertTrue(content.contains("field1{field3=\"Hello\",} 15.0\nfield1{field3=\"World!\",} 6.0\n"));
assertTrue(content.contains("field2{field3=\"Hello\",} 12.34567\nfield2{field3=\"World!\",} 0.12345678901234568\n"));
}