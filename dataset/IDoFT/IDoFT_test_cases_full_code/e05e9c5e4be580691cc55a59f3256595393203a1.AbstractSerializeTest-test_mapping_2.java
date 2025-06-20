public void test_mapping_2() throws Exception {
  String text="{\"@type\":\"com.alibaba.json.bvt.parser.deser.AbstractSerializeTest$A\",\"id\":234,\"name\":\"abc\"}";
  B b=(B)JSON.parse(text);
  Assert.assertNotNull(b);
  Assert.assertEquals(234,b.getId());
  Assert.assertEquals("abc",b.getName());
}
