@Test public void testCancelObservable() throws InterruptedException {
File pageFile=new File("target/cancelObs" + i + ".obj");//RO
long t=TimeUnit.SECONDS.toMillis(5);
TimeUnit.MILLISECONDS.sleep(waitMs);
assertFalse(pageFile.exists());
}