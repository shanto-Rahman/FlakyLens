public void testOutOfOrderResponses() throws Exception {
if (request.getPath().equals(firstRequest)) {
latch.await();
}
startsFirst.start();
endsFirst.start();
endsFirst.join();
assertEquals(0,firstResponseCode.get());
assertEquals(200,secondResponseCode.get());
latch.countDown();
startsFirst.join();
assertEquals(200,firstResponseCode.get());
assertEquals(200,secondResponseCode.get());
}