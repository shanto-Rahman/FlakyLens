@Test public void testPostFormParsingWorks(){
assertTrue(response.contains("test3"));
assertTrue(response.contains("test2@email.com"));
assertTrue(response.contains("test1"));
}