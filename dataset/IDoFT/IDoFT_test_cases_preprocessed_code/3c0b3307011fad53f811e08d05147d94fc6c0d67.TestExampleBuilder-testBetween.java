@Test public void testBetween(){
Assert.assertEquals(Integer.valueOf(35),country35.getId());
Assert.assertEquals("China",country35.getCountryname());
Assert.assertEquals("CN",country35.getCountrycode());
Assert.assertEquals(Integer.valueOf(34),country34.getId());
Assert.assertEquals("Chile",country34.getCountryname());
Assert.assertEquals("CL",country34.getCountrycode());
}