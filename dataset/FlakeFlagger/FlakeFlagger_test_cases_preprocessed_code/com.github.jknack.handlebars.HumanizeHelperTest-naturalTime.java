@Test public void naturalTime() throws IOException, InterruptedException {
Thread.sleep(1000);
assertEquals("moments ago",handlebars.compile("{{naturalTime this locale=\"en_US\"}}").apply(now));
}