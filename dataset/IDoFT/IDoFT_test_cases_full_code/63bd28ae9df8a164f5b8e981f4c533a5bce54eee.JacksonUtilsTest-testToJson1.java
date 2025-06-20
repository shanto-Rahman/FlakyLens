@Test public void testToJson1(){
  Assert.assertEquals("null",JacksonUtils.toJson(null));
  Assert.assertEquals("\"string\"",JacksonUtils.toJson("string"));
  Assert.assertEquals("30",JacksonUtils.toJson(new BigDecimal(30)));
  Assert.assertEquals("{\"key\":\"value\"}",JacksonUtils.toJson(Collections.singletonMap("key","value")));
  Assert.assertEquals("[{\"key\":\"value\"}]",JacksonUtils.toJson(Collections.singletonList(Collections.singletonMap("key","value"))));
  Assert.assertEquals("{\"aLong\":0,\"aInteger\":1,\"aBoolean\":false}",JacksonUtils.toJson(new TestOfAtomicObject()));
  Assert.assertEquals("{\"date\":1626192000000}",JacksonUtils.toJson(new TestOfDate()));
  Assert.assertEquals("{\"publicAccessModifier\":\"public\"}",JacksonUtils.toJson(new TestOfAccessModifier()));
  Assert.assertEquals("{\"value\":\"value\",\"key\":\"key\"}",JacksonUtils.toJson(new TestOfGetter()));
  Assert.assertEquals("{\"@type\":\"JacksonUtilsTest$TestOfAnnotationSub\",\"date\":\"2021-07-14\",\"subField\":\"subField\"," + "\"camelCase\":\"value\"}",JacksonUtils.toJson(new TestOfAnnotationSub()));
}
