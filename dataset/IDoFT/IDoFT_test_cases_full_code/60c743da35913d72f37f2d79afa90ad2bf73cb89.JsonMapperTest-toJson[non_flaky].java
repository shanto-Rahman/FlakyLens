/** 
 * 序列化对象/集合到Json字符串.
 */
@Test public void toJson() throws Exception {
  TestBean bean=new TestBean("A");
  String beanString=JsonMapper.INSTANCE.toJson(bean);
  System.out.println("Bean:" + beanString);
  assertJSONEqual(beanString,"{\"name\":\"A\",\"defaultValue\":\"hello\",\"nullValue\":null,\"emptyValue\":[]}");
  Map<String,Object> map=Maps.newLinkedHashMap();
  map.put("name","A");
  map.put("age",2);
  String mapString=JsonMapper.INSTANCE.toJson(map);
  System.out.println("Map:" + mapString);
  assertThat(mapString).isEqualTo("{\"name\":\"A\",\"age\":2}");
  List<String> stringList=Lists.newArrayList("A","B","C");
  String listString=JsonMapper.INSTANCE.toJson(stringList);
  System.out.println("String List:" + listString);
  assertThat(listString).isEqualTo("[\"A\",\"B\",\"C\"]");
  List<TestBean> beanList=Lists.newArrayList(new TestBean("A"),new TestBean("B"));
  String beanListString=JsonMapper.INSTANCE.toJson(beanList);
  System.out.println("Bean List:" + beanListString);
  assertJSONEqual(beanListString,"[{\"name\":\"A\",\"defaultValue\":\"hello\",\"nullValue\":null,\"emptyValue\":[]},{\"name\":\"B\",\"defaultValue\":\"hello\",\"nullValue\":null,\"emptyValue\":[]}]");
  TestBean[] beanArray=new TestBean[]{new TestBean("A"),new TestBean("B")};
  String beanArrayString=JsonMapper.INSTANCE.toJson(beanArray);
  System.out.println("Array List:" + beanArrayString);
  assertJSONEqual(beanArrayString,"[{\"name\":\"A\",\"defaultValue\":\"hello\",\"nullValue\":null,\"emptyValue\":[]},{\"name\":\"B\",\"defaultValue\":\"hello\",\"nullValue\":null,\"emptyValue\":[]}]");
}
