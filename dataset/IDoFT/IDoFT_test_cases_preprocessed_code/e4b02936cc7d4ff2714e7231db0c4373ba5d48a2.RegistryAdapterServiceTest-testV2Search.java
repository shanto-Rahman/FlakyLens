@Test public void testV2Search() throws Throwable {
assertNotNull("result is null",response);
assertEquals("Unexpected number of results",2,response.results.size());
assertEquals("results[0].name","test/v2image",result.name);
}