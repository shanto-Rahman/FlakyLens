@Test public void encodesObject(){
  new JsonEncoder().encode(jsonObject,JSONObject.class,requestTemplate);
  JSONAssert.assertEquals("{\"a\":\"b\",\"c\":1}",new String(requestTemplate.body(),UTF_8),false);
}
