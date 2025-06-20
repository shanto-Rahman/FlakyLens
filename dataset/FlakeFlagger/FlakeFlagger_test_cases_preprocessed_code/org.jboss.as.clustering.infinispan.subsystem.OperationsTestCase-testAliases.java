@Test public void testAliases() throws Exception {
Assert.assertEquals(result.toString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertFalse(result.get(RESULT).isDefined());
Assert.assertEquals(result.toString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(new ModelNode(alias),result.get(RESULT));
Assert.assertEquals(result.toString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertFalse(result.get(RESULT).isDefined());
Assert.assertEquals(result.toString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertFalse(result.get(RESULT).isDefined());
Assert.assertEquals(result.toString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertFalse(result.get(RESULT).isDefined());
Assert.assertEquals(result.toString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(result.toString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertFalse(result.get(RESULT).isDefined());
Assert.assertEquals(result.toString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertFalse(result.get(RESULT).isDefined());
}