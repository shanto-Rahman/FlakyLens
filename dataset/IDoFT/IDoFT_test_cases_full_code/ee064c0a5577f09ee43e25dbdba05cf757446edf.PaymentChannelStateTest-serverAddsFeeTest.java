@Test public void serverAddsFeeTest() throws Exception {
  Utils.setMockClock();
  final long EXPIRE_TIME=Utils.currentTimeMillis() / 1000 + 60 * 60 * 24;
  serverState=new PaymentChannelServerState(mockBroadcaster,serverWallet,serverKey,EXPIRE_TIME);
  assertEquals(PaymentChannelServerState.State.WAITING_FOR_REFUND_TRANSACTION,serverState.getState());
  clientState=new PaymentChannelClientState(wallet,myKey,new ECKey(null,serverKey.getPubKey()),Utils.CENT,EXPIRE_TIME){
    @Override protected void editContractSendRequest(    Wallet.SendRequest req){
      req.coinSelector=wallet.getCoinSelector();
    }
  }
;
  assertEquals(PaymentChannelClientState.State.NEW,clientState.getState());
  clientState.initiate();
  assertEquals(PaymentChannelClientState.State.INITIATED,clientState.getState());
  Transaction refund=new Transaction(params,clientState.getIncompleteRefundTransaction().bitcoinSerialize());
  byte[] refundSig=serverState.provideRefundTransaction(refund,myKey.getPubKey());
  assertEquals(PaymentChannelServerState.State.WAITING_FOR_MULTISIG_CONTRACT,serverState.getState());
  clientState.provideRefundSignature(refundSig);
  assertEquals(PaymentChannelClientState.State.SAVE_STATE_IN_WALLET,clientState.getState());
  clientState.fakeSave();
  assertEquals(PaymentChannelClientState.State.PROVIDE_MULTISIG_CONTRACT_TO_SERVER,clientState.getState());
  Transaction multisigContract=new Transaction(params,clientState.getMultisigContract().bitcoinSerialize());
  assertEquals(PaymentChannelClientState.State.READY,clientState.getState());
  assertEquals(2,multisigContract.getOutputs().size());
  Script script=multisigContract.getOutput(0).getScriptPubKey();
  assertTrue(script.isSentToMultiSig());
  script=multisigContract.getOutput(1).getScriptPubKey();
  assertTrue(script.isSentToAddress());
  assertTrue(wallet.getPendingTransactions().contains(multisigContract));
  serverState.provideMultiSigContract(multisigContract);
  assertEquals(PaymentChannelServerState.State.WAITING_FOR_MULTISIG_ACCEPTANCE,serverState.getState());
  TxFuturePair pair=broadcasts.take();
  pair.future.set(pair.tx);
  assertEquals(PaymentChannelServerState.State.READY,serverState.getState());
  byte[] signature=clientState.incrementPaymentBy(Transaction.REFERENCE_DEFAULT_MIN_TX_FEE.subtract(BigInteger.ONE)).signature.encodeToBitcoin();
  BigInteger totalRefund=Utils.CENT.subtract(Transaction.REFERENCE_DEFAULT_MIN_TX_FEE.subtract(BigInteger.ONE));
  serverState.incrementPayment(totalRefund,signature);
  try {
    serverState.close();
    fail();
  }
 catch (  InsufficientMoneyException e) {
  }
  StoredBlock block=new StoredBlock(makeSolvedTestBlock(blockStore,new ECKey().toAddress(params)),BigInteger.ONE,1);
  Transaction tx1=createFakeTx(params,Utils.COIN,serverKey.toAddress(params));
  serverWallet.receiveFromBlock(tx1,block,AbstractBlockChain.NewBlockType.BEST_CHAIN,0);
  try {
    serverState.close();
    fail();
  }
 catch (  InsufficientMoneyException e) {
    assertTrue(e.getMessage().contains("more in fees"));
  }
  signature=clientState.incrementPaymentBy(BigInteger.ONE.shiftLeft(1)).signature.encodeToBitcoin();
  totalRefund=totalRefund.subtract(BigInteger.ONE.shiftLeft(1));
  serverState.incrementPayment(totalRefund,signature);
  serverState.close();
  assertEquals(PaymentChannelServerState.State.CLOSING,serverState.getState());
  pair=broadcasts.take();
  pair.future.set(pair.tx);
  assertEquals(PaymentChannelServerState.State.CLOSED,serverState.getState());
}
