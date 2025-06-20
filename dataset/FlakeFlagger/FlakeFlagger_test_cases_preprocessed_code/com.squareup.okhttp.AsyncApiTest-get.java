@Test public void get() throws Exception {
assertTrue(server.takeRequest().getHeaders().contains("User-Agent: AsyncApiTest"));
}