@Test public void testMapField() throws Exception {
data.addChild(child);//IT
data.addChild(child);//IT
data.addChild(child);//IT
data.setList(Arrays.asList(newChild("forth",4)));//IT
Assert.assertEquals(3,data.getChildren().size());//IT
assertTrue(data.getChildren().get("first").getClass() == Child.class);//IT
Assert.assertEquals(1,data.getList().size());//IT
assertTrue(data.getList().get(0).getClass() == Child.class);//IT
Assert.assertEquals(data.getChildren().size(),realizadData.getChildren().size());//IT
Assert.assertEquals(data.getChildren().keySet(),realizadData.getChildren().keySet());//IT
for (Map.Entry<String,Child> entry : data.getChildren().entrySet()) {
  Child c=realizadData.getChildren().get(entry.getKey());
  Assert.assertNotNull(c);
  Assert.assertEquals(entry.getValue().getName(),c.getName());
  Assert.assertEquals(entry.getValue().getAge(),c.getAge());
}//IT
Child c=realizadData.getChildren().get(entry.getKey());//IT
Assert.assertNotNull(c);
Assert.assertEquals(entry.getValue().getName(),c.getName());//IT
Assert.assertEquals(entry.getValue().getAge(),c.getAge());//IT
Assert.assertEquals(1,realizadData.getList().size());//IT
Assert.assertEquals(data.getList().get(0).getName(),realizadData.getList().get(0).getName());//IT
Assert.assertEquals(data.getList().get(0).getAge(),realizadData.getList().get(0).getAge());//IT
}