@Test public void testWhereCompound0(){
Assert.assertEquals(Integer.valueOf(35),country35.getId());
Assert.assertEquals("China",country35.getCountryname());
Assert.assertEquals("CN",country35.getCountrycode());
Assert.assertEquals(Integer.valueOf(183),country183.getId());
Assert.assertEquals("Zambia",country183.getCountryname());
Assert.assertEquals("ZM",country183.getCountrycode());
Assert.assertEquals(Integer.valueOf(179),country179.getId());
Assert.assertEquals("Yemen",country179.getCountryname());
Assert.assertEquals("YE",country179.getCountrycode());
}