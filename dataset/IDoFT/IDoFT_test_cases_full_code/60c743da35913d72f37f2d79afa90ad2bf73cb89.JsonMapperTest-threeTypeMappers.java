/** 
 * 测试三种不同的Mapper.
 */
@Test public void threeTypeMappers(){
  JsonMapper normalBinder=JsonMapper.defaultMapper();
  TestBean bean=new TestBean("A");
  assertThat(normalBinder.toJson(bean)).isEqualTo("{\"name\":\"A\",\"defaultValue\":\"hello\",\"nullValue\":null,\"emptyValue\":[]}");
  JsonMapper nonNullMapper=JsonMapper.nonNullMapper();
  assertThat(nonNullMapper.toJson(bean)).isEqualTo("{\"name\":\"A\",\"defaultValue\":\"hello\",\"emptyValue\":[]}");
  JsonMapper nonEmptyMapper=JsonMapper.nonEmptyMapper();
  assertThat(nonEmptyMapper.toJson(bean)).isEqualTo("{\"name\":\"A\",\"defaultValue\":\"hello\"}");
  TestBean nonEmptyBean=nonEmptyMapper.fromJson("{\"name\":\"A\",\"defaultValue\":\"hello\"}",TestBean.class);
  assertThat(nonEmptyBean.getEmptyValue()).isEmpty();
}
