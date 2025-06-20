@Test public void defaultAtomikosTransactionManagerName() throws UnknownHostException {
File epochFile=new File("target/transaction-logs/" + InetAddress.getLocalHost().getHostAddress() + ".tm0.epoch");//RO
assertTrue(epochFile.isFile());
}