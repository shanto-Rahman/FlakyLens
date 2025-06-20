public void test_mapping_1() throws Exception {
  String text="{\"@type\":\"com.alibaba.json.bvt.parser.deser.AbstractSerializeTest$A\",\"id\":123}";
  B b=(B)JSON.parse(text);
  Assert.assertNotNull(b);
  Assert.assertEquals(123,b.getId());
}
