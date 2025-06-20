@Test public void testUrlWithRegisteredProvider() throws Exception {
  context.request().setQueryString("url=https://www.pinterest.com/pin/99360735500167749/");
  servlet.doGet(context.request(),context.response());
  String expectedOutput="{\"processor\":\"pinterest\",\"options\":{\"pinId\":\"99360735500167749\"}}";
  assertEquals(HttpServletResponse.SC_OK,context.response().getStatus(),"Expected the 200 status code.");
  assertEquals("application/json;charset=utf-8",context.response().getContentType(),"Expected the JSON content type.");
  assertEquals(expectedOutput,context.response().getOutputAsString(),"Does not match the expected response output.");
}
