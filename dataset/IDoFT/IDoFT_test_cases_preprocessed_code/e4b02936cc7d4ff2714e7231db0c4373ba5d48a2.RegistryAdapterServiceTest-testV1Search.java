@Test public void testV1Search() throws Throwable {
assertNotNull("result is null",response);
assertEquals("Unexpected number of results",10,response.numResults);
assertEquals("Unexpected number of results",10,response.results.size());
assertEquals("results[0].name","library/ubuntu",result.name);
assertEquals("results[0].is_official",true,result.official);
}