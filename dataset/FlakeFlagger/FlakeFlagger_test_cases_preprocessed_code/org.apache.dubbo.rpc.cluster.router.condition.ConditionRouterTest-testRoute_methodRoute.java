@Test public void testRoute_methodRoute(){
Assert.assertEquals(true,matchWhen);
Assert.assertEquals(true,matchWhen);
Assert.assertEquals(false,matchWhen);
Assert.assertEquals(true,matchWhen);
Assert.assertEquals(1,filteredInvokers1.size());
Assert.assertEquals(3,filteredInvokers2.size());
}