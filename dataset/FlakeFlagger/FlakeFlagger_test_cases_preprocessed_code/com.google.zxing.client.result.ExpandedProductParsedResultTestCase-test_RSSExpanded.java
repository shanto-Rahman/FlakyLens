@Test public void test_RSSExpanded(){
assertNotNull(o);
assertEquals("66546",o.getProductID());
assertNull(o.getSscc());
assertNull(o.getLotNumber());
assertNull(o.getProductionDate());
assertEquals("001205",o.getPackagingDate());
assertNull(o.getBestBeforeDate());
assertNull(o.getExpirationDate());
assertEquals("6544",o.getWeight());
assertEquals("KG",o.getWeightType());
assertEquals("2",o.getWeightIncrement());
assertEquals("5",o.getPrice());
assertEquals("2",o.getPriceIncrement());
assertEquals("445",o.getPriceCurrency());
assertEquals(uncommonAIs,o.getUncommonAIs());
}