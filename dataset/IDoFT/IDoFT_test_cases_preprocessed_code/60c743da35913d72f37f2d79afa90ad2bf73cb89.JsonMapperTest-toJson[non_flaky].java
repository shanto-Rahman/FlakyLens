/** 
 * 序列化对象/集合到Json字符串.
 */
@Test public void toJson() throws Exception {
assertThat(mapString).isEqualTo("{\"name\":\"A\",\"age\":2}");
assertThat(listString).isEqualTo("[\"A\",\"B\",\"C\"]");
}