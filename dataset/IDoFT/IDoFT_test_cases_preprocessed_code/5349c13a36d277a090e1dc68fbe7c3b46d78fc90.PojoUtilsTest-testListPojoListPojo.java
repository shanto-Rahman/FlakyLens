@Test public void testListPojoListPojo() throws Exception {
parent.setName("zhangsan");//IT
parent.setAge(Integer.MAX_VALUE);//IT
parentList.setList(Arrays.asList(parent));//IT
list.setResult(Arrays.asList(parentList));//IT
assertTrue(realizeObject instanceof ListResult);
List realizeInnerList=realizeList.getResult();//IT
Assertions.assertEquals(1,realizeInnerList.size());
assertTrue(realizeInnerList.get(0) instanceof InnerPojo);
Assertions.assertEquals(1,realizeParentList.getList().size());//IT
assertTrue(realizeParentList.getList().get(0) instanceof Parent);//IT
Parent realizeParent=(Parent)realizeParentList.getList().get(0);//IT
Assertions.assertEquals(parent.getName(),realizeParent.getName());//IT
Assertions.assertEquals(parent.getAge(),realizeParent.getAge());//IT
}