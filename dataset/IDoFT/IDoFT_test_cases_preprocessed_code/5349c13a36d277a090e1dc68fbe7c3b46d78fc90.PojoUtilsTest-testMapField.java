@Test public void testMapField() throws Exception {
data.addChild(child);//IT
data.addChild(child);//IT
data.addChild(child);//IT
data.setList(Arrays.asList(newChild("forth",4)));//IT
Assertions.assertEquals(3,data.getChildren().size());//IT
assertSame(data.getChildren().get("first").getClass(),Child.class);//IT
Assertions.assertEquals(1,data.getList().size());//IT
assertSame(data.getList().get(0).getClass(),Child.class);//IT
Assertions.assertEquals(data.getChildren().size(),realizadData.getChildren().size());//IT
Assertions.assertEquals(data.getChildren().keySet(),realizadData.getChildren().keySet());//IT
for (Map.Entry<String,Child> entry : data.getChildren().entrySet()) {
  Child c=realizadData.getChildren().get(entry.getKey());
  Assertions.assertNotNull(c);
  Assertions.assertEquals(entry.getValue().getName(),c.getName());
  Assertions.assertEquals(entry.getValue().getAge(),c.getAge());
}//IT
Child c=realizadData.getChildren().get(entry.getKey());//IT
Assertions.assertNotNull(c);
Assertions.assertEquals(entry.getValue().getName(),c.getName());//IT
Assertions.assertEquals(entry.getValue().getAge(),c.getAge());//IT
Assertions.assertEquals(1,realizadData.getList().size());//IT
Assertions.assertEquals(data.getList().get(0).getName(),realizadData.getList().get(0).getName());//IT
Assertions.assertEquals(data.getList().get(0).getAge(),realizadData.getList().get(0).getAge());//IT
}