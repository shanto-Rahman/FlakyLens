@Test public void testIn(){
Assert.assertEquals(Integer.valueOf(35),country35.getId());
Assert.assertEquals("China",country35.getCountryname());
Assert.assertEquals("CN",country35.getCountrycode());
Assert.assertEquals(Integer.valueOf(183),country183.getId());
Assert.assertEquals("Zambia",country183.getCountryname());
Assert.assertEquals("ZM",country183.getCountrycode());
}