@Test public void testClient() throws Exception {
if (PerformanceUtils.getProperty("server",null) == null) {
}
if (client.isConnected()) {
}
if (client != null && client.isConnected() == false) {
}
if (messageBlock == null) {
}
if (output.lastIndexOf(messageBlock) < 0) {
if (j % 100 == 0) System.out.println("OK: " + j);
}
}