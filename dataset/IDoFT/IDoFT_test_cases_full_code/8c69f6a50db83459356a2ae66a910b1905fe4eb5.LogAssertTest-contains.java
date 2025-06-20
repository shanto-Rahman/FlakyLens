@Test public void contains() throws IOException {
  log.info("Hello");
  assertNotContains("a");
  assertNotContains("Hello");
  log.info("World");
  assertContains("World");
  assertNotContains("Hello","World");
  log.info("DDDplus Framework");
  assertContains("DDD");
  log.info("a");
  log.info("b");
  assertContains("a","b");
  try {
    assertContains("a");
    fail();
  }
 catch (  AssertionError expected) {
  }
}
