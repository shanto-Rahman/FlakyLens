@Test public void encodesArray(){
  new JsonEncoder().encode(jsonArray,JSONArray.class,requestTemplate);
  JSONAssert.assertEquals("[{\"a\":\"b\",\"c\":1},123]",new String(requestTemplate.body(),UTF_8),false);
}
