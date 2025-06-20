@Test public void testEqualTo(){
Assert.assertEquals(Integer.valueOf(35),country.getId());
Assert.assertEquals("China",country.getCountryname());
Assert.assertEquals("CN",country.getCountrycode());
}