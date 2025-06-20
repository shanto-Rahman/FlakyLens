@Test public void basic() throws Exception {
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
final TxFuturePair pair=broadcasts.take();
assertEquals(PaymentChannelServerState.State.READY,serverState.getState());
assertEquals(2,wallet.getTransactions(false).size());
assertFalse(clientWalletMultisigContract.getHash().equals(clientState.getCompletedRefundTransaction().getHash()));
if (!clientWalletMultisigContract.getHash().equals(multisigContract.getHash())) {
assertFalse(clientWalletMultisigContract.getHash().equals(clientState.getCompletedRefundTransaction().getHash()));
assertFalse(walletTransactionIterator.next().getHash().equals(clientState.getCompletedRefundTransaction().getHash()));
}
assertEquals(multisigContract.getHash(),clientWalletMultisigContract.getHash());
assertFalse(clientWalletMultisigContract.getInput(0).getConnectedOutput().getSpentBy().getParentTransaction().getHash().equals(refund.getHash()));
assertEquals(PaymentChannelServerState.State.CLOSING,serverState.getState());
final TxFuturePair pair2=broadcasts.take();
assertEquals(PaymentChannelServerState.State.CLOSED,serverState.getState());
assertEquals(PaymentChannelClientState.State.CLOSED,clientState.getState());
assertEquals(size.multiply(BigInteger.valueOf(5)),serverWallet.getBalance());
assertEquals(0,serverWallet.getPendingTransactions().size());
assertEquals(Utils.COIN.subtract(size.multiply(BigInteger.valueOf(5))),wallet.getBalance());
assertEquals(0,wallet.getPendingTransactions().size());
assertEquals(3,wallet.getTransactions(false).size());
if (!clientWalletCloseTransaction.getHash().equals(closeTx.getHash())) clientWalletCloseTransaction=walletTransactionIterator.next();
if (!clientWalletCloseTransaction.getHash().equals(closeTx.getHash())) clientWalletCloseTransaction=walletTransactionIterator.next();
assertEquals(closeTx.getHash(),clientWalletCloseTransaction.getHash());
assertNotNull(clientWalletCloseTransaction.getInput(0).getConnectedOutput());
}