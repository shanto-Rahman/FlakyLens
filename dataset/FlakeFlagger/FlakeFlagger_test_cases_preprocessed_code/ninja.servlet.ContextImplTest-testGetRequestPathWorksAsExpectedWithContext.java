@Test public void testGetRequestPathWorksAsExpectedWithContext(){
assertEquals("/myapp/is/here",context.getRequestPath());
}