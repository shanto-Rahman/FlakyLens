public void testForIssue(){
vo.setName("zhangsan");//IT
assertEquals("{\"map\":{\"a\":[\"1\",\"2\",\"3\"],\"b\":[\"1\"]},\"name\":\"zhangsan\"}",JSON.toJSONString(vo));
}