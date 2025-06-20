@Test public void testTransportReadWriteWithParameters() throws Exception {
Assert.assertTrue("Could not create services",services.isSuccessfulBoot());
Assert.assertEquals(result.toString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(result.toString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(result.toString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals("new-rack",result.get(RESULT).asString());
}