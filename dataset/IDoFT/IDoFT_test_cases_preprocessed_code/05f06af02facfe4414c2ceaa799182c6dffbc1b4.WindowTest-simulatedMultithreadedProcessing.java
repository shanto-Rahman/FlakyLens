@Test public void simulatedMultithreadedProcessing() throws Exception {
requestThread.start();
responseThread.start();
requestThread.join();
responseThread.join();
if (requestThreads[i].throwable != null) {
}
Assert.assertNull("RequestThread " + i + " throwable wasn't null: "+ requestThreads[i].throwable,requestThreads[i].throwable);
if (responseThread.throwable != null) {
}
Assert.assertNull("ResponseThread throwable wasn't null",responseThread.throwable);
Assert.assertEquals(0,window.getSize());
}