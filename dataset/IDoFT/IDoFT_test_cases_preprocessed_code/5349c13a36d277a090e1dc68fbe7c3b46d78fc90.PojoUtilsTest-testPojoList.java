@Test public void testPojoList() throws Exception {
parent.setAge(Integer.MAX_VALUE);//IT
parent.setName("zhangsan");//IT
result.setResult(list);//IT
assertTrue(realizeObject instanceof ListResult);
List l=listResult.getResult();//IT
assertEquals(1,l.size());
assertTrue(l.get(0) instanceof Parent);
Assertions.assertEquals(parent.getName(),realizeParent.getName());//IT
Assertions.assertEquals(parent.getAge(),realizeParent.getAge());//IT
}