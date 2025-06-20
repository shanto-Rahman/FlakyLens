@Test public void test() throws URISyntaxException, IOException, DeploymentException, InterruptedException {
assertEquals("test1",client.messages.poll(10,TimeUnit.SECONDS));
assertEquals("test2",client.messages.poll(10,TimeUnit.SECONDS));
}