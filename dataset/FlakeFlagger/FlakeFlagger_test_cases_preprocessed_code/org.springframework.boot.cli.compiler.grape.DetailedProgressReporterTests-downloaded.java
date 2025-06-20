@Test public void downloaded() throws InterruptedException {
Thread.sleep(100);
assertThat(message,startsWith("Downloaded: " + REPOSITORY + ARTIFACT));
assertThat(message,containsString("4KB at"));
assertThat(message,containsString("KB/sec"));
assertThat(message,endsWith("\n"));
}