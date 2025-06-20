@Test public void testPojoList() throws Exception {
parent.setAge(Integer.MAX_VALUE);//IT
parent.setName("zhangsan");//IT
result.setResult(list);//IT
assertTrue(realizeObject instanceof ListResult);
List l=listResult.getResult();//IT
assertTrue(l.size() == 1);
assertTrue(l.get(0) instanceof Parent);
Assert.assertEquals(parent.getName(),realizeParent.getName());//IT
Assert.assertEquals(parent.getAge(),realizeParent.getAge());//IT
}