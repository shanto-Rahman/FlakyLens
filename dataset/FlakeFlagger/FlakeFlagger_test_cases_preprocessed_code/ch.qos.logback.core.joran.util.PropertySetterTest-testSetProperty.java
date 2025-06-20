@Test public void testSetProperty(){
assertEquals(10,house.getCount());
assertEquals(33.1d,(double)house.getTemperature(),0.01);
assertEquals("jack",house.getName());
assertTrue(house.isOpen());
assertEquals(10,house.getCount());
assertEquals("jack",house.getName());
assertTrue(house.isOpen());
}