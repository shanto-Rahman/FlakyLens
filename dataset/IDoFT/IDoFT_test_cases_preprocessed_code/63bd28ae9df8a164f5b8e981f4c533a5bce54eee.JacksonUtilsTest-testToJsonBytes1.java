@Test public void testToJsonBytes1(){
Assert.assertArrayEquals("null".getBytes(),JacksonUtils.toJsonBytes(null));
Assert.assertArrayEquals("\"string\"".getBytes(),JacksonUtils.toJsonBytes("string"));
Assert.assertArrayEquals("30".getBytes(),JacksonUtils.toJsonBytes(new BigDecimal(30)));
Assert.assertArrayEquals("{\"key\":\"value\"}".getBytes(),JacksonUtils.toJsonBytes(Collections.singletonMap("key","value")));
Assert.assertArrayEquals("[{\"key\":\"value\"}]".getBytes(),JacksonUtils.toJsonBytes(Collections.singletonList(Collections.singletonMap("key","value"))));
Assert.assertArrayEquals("{\"aLong\":0,\"aInteger\":1,\"aBoolean\":false}".getBytes(),JacksonUtils.toJsonBytes(new TestOfAtomicObject()));
Assert.assertArrayEquals("{\"date\":1626192000000}".getBytes(),JacksonUtils.toJsonBytes(new TestOfDate()));
Assert.assertArrayEquals("{\"publicAccessModifier\":\"public\"}".getBytes(),JacksonUtils.toJsonBytes(new TestOfAccessModifier()));
Assert.assertArrayEquals("{\"value\":\"value\",\"key\":\"key\"}".getBytes(),JacksonUtils.toJsonBytes(new TestOfGetter()));
Assert.assertArrayEquals(("{\"@type\":\"JacksonUtilsTest$TestOfAnnotationSub\",\"date\":\"2021-07-14\",\"subField\":\"subField\"," + "\"camelCase\":\"value\"}").getBytes(),JacksonUtils.toJsonBytes(new TestOfAnnotationSub()));
}