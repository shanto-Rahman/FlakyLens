@Test public void testReplicasCheckForBookieHandleNotAvailable() throws Exception {
  int numOfBookies=5;
  RegistrationManager regManager=driver.getRegistrationManager();
  MultiKeyMap<String,AvailabilityOfEntriesOfLedger> returnAvailabilityOfEntriesOfLedger=new MultiKeyMap<String,AvailabilityOfEntriesOfLedger>();
  MultiKeyMap<String,Integer> errorReturnValueForGetAvailabilityOfEntriesOfLedger=new MultiKeyMap<String,Integer>();
  List<BookieId> bookieAddresses=addAndRegisterBookies(regManager,numOfBookies);
  LedgerManagerFactory mFactory=driver.getLedgerManagerFactory();
  LedgerManager lm=mFactory.newLedgerManager();
  int ensembleSize=5;
  int writeQuorumSize=4;
  int ackQuorumSize=2;
  long lastEntryId=100;
  int length=10000;
  DigestType digestType=DigestType.DUMMY;
  byte[] password=new byte[0];
  Collections.shuffle(bookieAddresses);
  Map<Long,List<BookieId>> segmentEnsembles=new HashMap<Long,List<BookieId>>();
  segmentEnsembles.put(0L,bookieAddresses);
  long ledgerId=1L;
  createClosedLedgerMetadata(lm,ledgerId,ensembleSize,writeQuorumSize,ackQuorumSize,segmentEnsembles,lastEntryId,length,digestType,password);
  for (  BookieId bookieSocketAddress : bookieAddresses) {
    errorReturnValueForGetAvailabilityOfEntriesOfLedger.put(bookieSocketAddress.toString(),Long.toString(ledgerId),BKException.Code.BookieHandleNotAvailableException);
  }
  ensembleSize=4;
  segmentEnsembles.clear();
  segmentEnsembles.put(0L,bookieAddresses.subList(0,4));
  segmentEnsembles.put(20L,bookieAddresses.subList(1,5));
  segmentEnsembles.put(60L,bookieAddresses.subList(0,4));
  ledgerId=2L;
  createClosedLedgerMetadata(lm,ledgerId,ensembleSize,writeQuorumSize,ackQuorumSize,segmentEnsembles,lastEntryId,length,digestType,password);
  for (  BookieId bookieSocketAddress : bookieAddresses) {
    errorReturnValueForGetAvailabilityOfEntriesOfLedger.put(bookieSocketAddress.toString(),Long.toString(ledgerId),BKException.Code.BookieHandleNotAvailableException);
  }
  segmentEnsembles.clear();
  segmentEnsembles.put(0L,bookieAddresses.subList(0,4));
  ledgerId=3L;
  createNonClosedLedgerMetadata(lm,ledgerId,ensembleSize,writeQuorumSize,ackQuorumSize,segmentEnsembles,digestType,password);
  for (  BookieId bookieSocketAddress : bookieAddresses) {
    errorReturnValueForGetAvailabilityOfEntriesOfLedger.put(bookieSocketAddress.toString(),Long.toString(ledgerId),BKException.Code.BookieHandleNotAvailableException);
  }
  segmentEnsembles.clear();
  segmentEnsembles.put(0L,bookieAddresses.subList(0,4));
  segmentEnsembles.put(20L,bookieAddresses.subList(1,5));
  segmentEnsembles.put(60L,bookieAddresses.subList(0,4));
  ledgerId=4L;
  createNonClosedLedgerMetadata(lm,ledgerId,ensembleSize,writeQuorumSize,ackQuorumSize,segmentEnsembles,digestType,password);
  for (  BookieId bookieSocketAddress : bookieAddresses) {
    errorReturnValueForGetAvailabilityOfEntriesOfLedger.put(bookieSocketAddress.toString(),Long.toString(ledgerId),BKException.Code.BookieHandleNotAvailableException);
  }
  runTestScenario(returnAvailabilityOfEntriesOfLedger,errorReturnValueForGetAvailabilityOfEntriesOfLedger,0,0,0);
}
