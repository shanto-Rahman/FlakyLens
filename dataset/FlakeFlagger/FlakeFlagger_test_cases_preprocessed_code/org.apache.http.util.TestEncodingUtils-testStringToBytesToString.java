@Test public void testStringToBytesToString() throws Exception {
Assert.assertNotNull(data1);
Assert.assertEquals(utf.length,data1.length);
Assert.assertEquals(utf[i],data1[i]);
Assert.assertNotNull(data2);
Assert.assertEquals(latin1.length,data2.length);
Assert.assertEquals(latin1[i],data2[i]);
Assert.fail("IllegalArgumentException should have been thrown");
Assert.fail("IllegalArgumentException should have been thrown");
Assert.fail("IllegalArgumentException should have been thrown");
}