public void test_dupType() throws Exception {
  DianDianCart cart=new DianDianCart();
  cart.setId(1001);
  LinkedHashMap<String,JSONObject> cartMap=new LinkedHashMap<String,JSONObject>();
  JSONObject obj=new JSONObject();
  obj.put("id",1001);
  obj.put(JSON.DEFAULT_TYPE_KEY,"com.alibaba.json.bvt.writeClassName.WriteDuplicateType$DianDianCart");
  cartMap.put("1001",obj);
  String text1=JSON.toJSONString(cartMap,SerializerFeature.WriteClassName);
  assertTrue(text1.equals("{\"@type\":\"java.util.LinkedHashMap\",\"1001\":{\"@type\":\"com.alibaba.json.bvt.writeClassName.WriteDuplicateType$DianDianCart\",\"id\":1001}}") || text1.equals("{\"@type\":\"java.util.LinkedHashMap\",\"1001\":{\"id\":1001,\"@type\":\"com.alibaba.json.bvt.writeClassName.WriteDuplicateType$DianDianCart\"}}"));
}
