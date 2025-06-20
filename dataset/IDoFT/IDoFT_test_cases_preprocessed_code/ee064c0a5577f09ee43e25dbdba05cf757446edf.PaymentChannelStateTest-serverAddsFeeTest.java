@Test public void serverAddsFeeTest() throws Exception {
assertEquals(PaymentChannelServerState.State.WAITING_FOR_REFUND_TRANSACTION,serverState.getState());
assertEquals(PaymentChannelClientState.State.NEW,clientState.getState());
assertEquals(PaymentChannelClientState.State.INITIATED,clientState.getState());
assertEquals(PaymentChannelServerState.State.WAITING_FOR_MULTISIG_CONTRACT,serverState.getState());
assertEquals(PaymentChannelClientState.State.SAVE_STATE_IN_WALLET,clientState.getState());
assertEquals(PaymentChannelClientState.State.PROVIDE_MULTISIG_CONTRACT_TO_SERVER,clientState.getState());
assertEquals(PaymentChannelClientState.State.READY,clientState.getState());
assertEquals(2,multisigContract.getOutputs().size());
assertTrue(script.isSentToMultiSig());
assertTrue(script.isSentToAddress());
assertTrue(wallet.getPendingTransactions().contains(multisigContract));
assertEquals(PaymentChannelServerState.State.WAITING_FOR_MULTISIG_ACCEPTANCE,serverState.getState());
TxFuturePair pair=broadcasts.take();
assertEquals(PaymentChannelServerState.State.READY,serverState.getState());
fail();
fail();
assertTrue(e.getMessage().contains("more in fees"));
assertEquals(PaymentChannelServerState.State.CLOSING,serverState.getState());
pair=broadcasts.take();
assertEquals(PaymentChannelServerState.State.CLOSED,serverState.getState());
}