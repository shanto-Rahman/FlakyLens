@Test public void getClientsTest() throws IOException {
Assert.assertEquals(clients + 1,files.size());
Assert.assertEquals("/",files.get(0));
Assert.assertEquals("/" + k,files.get(k + 1));
}