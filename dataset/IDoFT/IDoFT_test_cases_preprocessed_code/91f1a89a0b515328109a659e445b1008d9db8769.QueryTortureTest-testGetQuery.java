@Test public void testGetQuery(){
assertEquals("point=46.444481%2C11.306992&point=46.07847%2C11.178589&elevation=true&locale=en_US&weighting=fastest&vehicle=car",result.createQueryString());
assertEquals(46.444481,result.start.lat,1e-5);
assertEquals(11.178589,result.end.lon,1e-5);
}