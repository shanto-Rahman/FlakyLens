@Test public void testCancel() throws InterruptedException {
File pageFile=new File("target/cancel" + i + ".obj");//RO
long t=TimeUnit.SECONDS.toMillis(5);
TimeUnit.MILLISECONDS.sleep(waitMs);
assertFalse(pageFile.exists());
}