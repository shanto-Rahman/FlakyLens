@Test public void testDateHandler() throws IOException, InterruptedException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertTrue((firstDate + 3000) > System.currentTimeMillis());
Assert.assertTrue(System.currentTimeMillis() > firstDate);
Thread.sleep(1500);
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertTrue((secondDate + 2000) > System.currentTimeMillis());
Assert.assertTrue(System.currentTimeMillis() >= secondDate);
Assert.assertTrue(secondDate > firstDate);
}