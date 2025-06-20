@Test public void testSerialization() throws Exception {
Assert.assertNotNull(headers1);
Assert.assertNotNull(headers2);
Assert.assertEquals(headers1.length,headers2.length);
Assert.assertEquals(headers1[i].getName(),headers2[i].getName());
Assert.assertEquals(headers1[i].getValue(),headers2[i].getValue());
}