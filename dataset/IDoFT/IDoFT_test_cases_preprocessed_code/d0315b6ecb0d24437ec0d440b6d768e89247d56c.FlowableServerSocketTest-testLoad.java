@Test public void testLoad() throws InterruptedException {
socket=new Socket(LOCALHOST,port.get());
openSockets.incrementAndGet();
openSockets.decrementAndGet();
if (socket != null) socket.close();
Thread.sleep(1000);
assertFalse(errored.get());
Thread.sleep(1000);
}