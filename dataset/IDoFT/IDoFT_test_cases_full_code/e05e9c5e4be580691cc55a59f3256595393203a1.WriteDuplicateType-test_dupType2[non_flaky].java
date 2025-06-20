public void test_dupType2() throws Exception {
  DianDianCart cart=new DianDianCart();
  cart.setId(1001);
  LinkedHashMap<String,HashMap<String,Object>> cartMap=new LinkedHashMap<String,HashMap<String,Object>>();
  HashMap<String,Object> obj=new LinkedHashMap<String,Object>();
  obj.put("id",1001);
  obj.put(JSON.DEFAULT_TYPE_KEY,"com.alibaba.json.bvt.writeClassName.WriteDuplicateType$DianDianCart");
  cartMap.put("1001",obj);
  String text1=JSON.toJSONString(cartMap,SerializerFeature.WriteClassName);
  Assert.assertEquals("{\"@type\":\"java.util.LinkedHashMap\",\"1001\":{\"id\":1001,\"@type\":\"com.alibaba.json.bvt.writeClassName.WriteDuplicateType$DianDianCart\"}}",text1);
}
