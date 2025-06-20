@Test public void customAtomikosTransactionManagerName() throws BeansException, Exception {
File epochFile=new File("target/transaction-logs/custom0.epoch");//RO
assertTrue(epochFile.isFile());
}