@Test public void testExpressions(){
Assert.assertTrue(newModel.get("name").equals(new ModelNode(new ValueExpression("${name}"))));
Assert.assertTrue(newModel.get("giop-version").equals(new ModelNode(new ValueExpression("${giop.minor.version:1.2}"))));
}