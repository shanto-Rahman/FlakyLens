/** 
 * 测试三种不同的Mapper.
 */
@Test public void threeTypeMappers(){
assertThat(normalBinder.toJson(bean)).isEqualTo("{\"name\":\"A\",\"defaultValue\":\"hello\",\"nullValue\":null,\"emptyValue\":[]}");
assertThat(nonNullMapper.toJson(bean)).isEqualTo("{\"name\":\"A\",\"defaultValue\":\"hello\",\"emptyValue\":[]}");
assertThat(nonEmptyMapper.toJson(bean)).isEqualTo("{\"name\":\"A\",\"defaultValue\":\"hello\"}");
assertThat(nonEmptyBean.getEmptyValue()).isEmpty();//IT
}