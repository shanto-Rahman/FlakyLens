/** 
 * 序列化对象/集合到Json字符串.
 */
@Test public void toJson() throws Exception {
assertThat(beanString).isEqualTo("{\"name\":\"A\",\"defaultValue\":\"hello\",\"nullValue\":null,\"emptyValue\":[]}");
assertThat(mapString).isEqualTo("{\"name\":\"A\",\"age\":2}");
assertThat(listString).isEqualTo("[\"A\",\"B\",\"C\"]");
assertThat(beanListString).isEqualTo("[{\"name\":\"A\",\"defaultValue\":\"hello\",\"nullValue\":null,\"emptyValue\":[]},{\"name\":\"B\",\"defaultValue\":\"hello\",\"nullValue\":null,\"emptyValue\":[]}]");
assertThat(beanArrayString).isEqualTo("[{\"name\":\"A\",\"defaultValue\":\"hello\",\"nullValue\":null,\"emptyValue\":[]},{\"name\":\"B\",\"defaultValue\":\"hello\",\"nullValue\":null,\"emptyValue\":[]}]");
}