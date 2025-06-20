@Test public void testUrlWithRegisteredProvider() throws Exception {
assertEquals(HttpServletResponse.SC_OK,context.response().getStatus(),"Expected the 200 status code.");
assertEquals("application/json;charset=utf-8",context.response().getContentType(),"Expected the JSON content type.");
assertEquals(expectedOutput,context.response().getOutputAsString(),"Does not match the expected response output.");
}