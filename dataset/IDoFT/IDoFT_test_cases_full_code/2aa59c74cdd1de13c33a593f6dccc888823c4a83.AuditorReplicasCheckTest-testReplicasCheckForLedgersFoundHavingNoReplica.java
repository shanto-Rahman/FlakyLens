@Test public void testReplicasCheckForLedgersFoundHavingNoReplica() throws Exception {
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
  int numLedgersFoundHavingNoReplicaOfAnEntry=0;
  Map<Long,List<BookieId>> segmentEnsembles=new HashMap<Long,List<BookieId>>();
  segmentEnsembles.put(0L,bookieAddresses);
  long ledgerId=1L;
  createClosedLedgerMetadata(lm,ledgerId,ensembleSize,writeQuorumSize,ackQuorumSize,segmentEnsembles,lastEntryId,length,digestType,password);
  for (  BookieId bookieSocketAddress : bookieAddresses) {
    returnAvailabilityOfEntriesOfLedger.put(bookieSocketAddress.toString(),Long.toString(ledgerId),AvailabilityOfEntriesOfLedger.EMPTY_AVAILABILITYOFENTRIESOFLEDGER);
  }
  numLedgersFoundHavingNoReplicaOfAnEntry++;
  ensembleSize=4;
  segmentEnsembles.clear();
  segmentEnsembles.put(0L,bookieAddresses.subList(0,4));
  segmentEnsembles.put(20L,bookieAddresses.subList(1,5));
  segmentEnsembles.put(60L,bookieAddresses.subList(0,4));
  ledgerId=2L;
  createClosedLedgerMetadata(lm,ledgerId,ensembleSize,writeQuorumSize,ackQuorumSize,segmentEnsembles,lastEntryId,length,digestType,password);
  for (  BookieId bookieSocketAddress : bookieAddresses) {
    errorReturnValueForGetAvailabilityOfEntriesOfLedger.put(bookieSocketAddress.toString(),Long.toString(ledgerId),BKException.Code.NoSuchLedgerExistsException);
  }
  numLedgersFoundHavingNoReplicaOfAnEntry++;
  segmentEnsembles.clear();
  segmentEnsembles.put(0L,bookieAddresses.subList(0,4));
  ledgerId=3L;
  createNonClosedLedgerMetadata(lm,ledgerId,ensembleSize,writeQuorumSize,ackQuorumSize,segmentEnsembles,digestType,password);
  for (  BookieId bookieSocketAddress : bookieAddresses) {
    returnAvailabilityOfEntriesOfLedger.put(bookieSocketAddress.toString(),Long.toString(ledgerId),AvailabilityOfEntriesOfLedger.EMPTY_AVAILABILITYOFENTRIESOFLEDGER);
  }
  ensembleSize=3;
  writeQuorumSize=3;
  ackQuorumSize=2;
  lastEntryId=1;
  length=1000;
  segmentEnsembles.clear();
  segmentEnsembles.put(0L,bookieAddresses.subList(0,3));
  ledgerId=4L;
  createClosedLedgerMetadata(lm,ledgerId,ensembleSize,writeQuorumSize,ackQuorumSize,segmentEnsembles,lastEntryId,length,digestType,password);
  for (  BookieId bookieSocketAddress : bookieAddresses) {
    returnAvailabilityOfEntriesOfLedger.put(bookieSocketAddress.toString(),Long.toString(ledgerId),new AvailabilityOfEntriesOfLedger(new long[]{0L}));
  }
  numLedgersFoundHavingNoReplicaOfAnEntry++;
  ensembleSize=4;
  writeQuorumSize=3;
  ackQuorumSize=2;
  lastEntryId=3;
  length=10000;
  segmentEnsembles.put(0L,bookieAddresses.subList(0,4));
  ledgerId=5L;
  createClosedLedgerMetadata(lm,ledgerId,ensembleSize,writeQuorumSize,ackQuorumSize,segmentEnsembles,lastEntryId,length,digestType,password);
  returnAvailabilityOfEntriesOfLedger.put(bookieAddresses.get(0).toString(),Long.toString(ledgerId),new AvailabilityOfEntriesOfLedger(new long[]{0}));
  returnAvailabilityOfEntriesOfLedger.put(bookieAddresses.get(1).toString(),Long.toString(ledgerId),new AvailabilityOfEntriesOfLedger(new long[]{0,3}));
  returnAvailabilityOfEntriesOfLedger.put(bookieAddresses.get(2).toString(),Long.toString(ledgerId),new AvailabilityOfEntriesOfLedger(new long[]{0}));
  returnAvailabilityOfEntriesOfLedger.put(bookieAddresses.get(3).toString(),Long.toString(ledgerId),new AvailabilityOfEntriesOfLedger(new long[]{2,3}));
  numLedgersFoundHavingNoReplicaOfAnEntry++;
  runTestScenario(returnAvailabilityOfEntriesOfLedger,errorReturnValueForGetAvailabilityOfEntriesOfLedger,numLedgersFoundHavingNoReplicaOfAnEntry,0,0);
}
