@Test public void testMapField() throws Exception {
  TestData data=new TestData();
  Child child=newChild("first",1);
  data.addChild(child);
  child=newChild("second",2);
  data.addChild(child);
  child=newChild("third",3);
  data.addChild(child);
  data.setList(Arrays.asList(newChild("forth",4)));
  Object obj=PojoUtils.generalize(data);
  Assertions.assertEquals(3,data.getChildren().size());
  assertSame(data.getChildren().get("first").getClass(),Child.class);
  Assertions.assertEquals(1,data.getList().size());
  assertSame(data.getList().get(0).getClass(),Child.class);
  TestData realizadData=(TestData)PojoUtils.realize(obj,TestData.class);
  Assertions.assertEquals(data.getChildren().size(),realizadData.getChildren().size());
  Assertions.assertEquals(data.getChildren().keySet(),realizadData.getChildren().keySet());
  for (  Map.Entry<String,Child> entry : data.getChildren().entrySet()) {
    Child c=realizadData.getChildren().get(entry.getKey());
    Assertions.assertNotNull(c);
    Assertions.assertEquals(entry.getValue().getName(),c.getName());
    Assertions.assertEquals(entry.getValue().getAge(),c.getAge());
  }
  Assertions.assertEquals(1,realizadData.getList().size());
  Assertions.assertEquals(data.getList().get(0).getName(),realizadData.getList().get(0).getName());
  Assertions.assertEquals(data.getList().get(0).getAge(),realizadData.getList().get(0).getAge());
}
