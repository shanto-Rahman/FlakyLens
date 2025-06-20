/** 
 * 测试三种不同的Mapper.
 */
@Test public void threeTypeMappers() throws JSONException {
  JsonMapper normalBinder=JsonMapper.defaultMapper();
  TestBean bean=new TestBean("A");
  assertJSONEqual(normalBinder.toJson(bean),"{\"name\":\"A\",\"defaultValue\":\"hello\",\"nullValue\":null,\"emptyValue\":[]}");
  JsonMapper nonNullMapper=JsonMapper.nonNullMapper();
  assertJSONEqual(nonNullMapper.toJson(bean),"{\"name\":\"A\",\"defaultValue\":\"hello\",\"emptyValue\":[]}");
  JsonMapper nonEmptyMapper=JsonMapper.nonEmptyMapper();
  assertJSONEqual(nonEmptyMapper.toJson(bean),"{\"name\":\"A\",\"defaultValue\":\"hello\"}");
  TestBean nonEmptyBean=nonEmptyMapper.fromJson("{\"name\":\"A\",\"defaultValue\":\"hello\"}",TestBean.class);
  assertThat(nonEmptyBean.getEmptyValue()).isEmpty();
}
