@Test public void testSerialize(){
assertEquals(requestJson,json);
assertEquals(jsonBase64,saleToAcquirerDataModelAdapter.serialize(saleToAcquirerData,null,null).getAsString());
}