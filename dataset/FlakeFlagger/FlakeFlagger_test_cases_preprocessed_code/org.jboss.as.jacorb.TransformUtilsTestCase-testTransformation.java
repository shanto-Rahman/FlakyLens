@Test public void testTransformation(){
Assert.assertTrue(newModel.get("name").equals(new ModelNode("test")));
Assert.assertTrue(newModel.get("giop-version").equals(new ModelNode("1.2")));
Assert.assertTrue(newModel.get("security").equals(new ModelNode("none")));
Assert.assertTrue(newModel.get("transactions").equals(new ModelNode("full")));
Assert.assertTrue(newModel.get("export-corbaloc").equals(new ModelNode(true)));
Assert.assertTrue(newModel.get("support-ssl").equals(new ModelNode(false)));
Assert.assertTrue(newModel.get("iona").equals(new ModelNode(true)));
}