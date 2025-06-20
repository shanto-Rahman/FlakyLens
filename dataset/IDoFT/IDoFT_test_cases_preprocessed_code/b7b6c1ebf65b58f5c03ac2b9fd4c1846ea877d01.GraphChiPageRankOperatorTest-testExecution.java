@Test public void testExecution() throws IOException {
FileChannel.Instance inputChannelInstance=(FileChannel.Instance)new FileChannel(FileChannel.HDFS_TSV_DESCRIPTOR).createInstance(graphChiExecutor,null,-1);//RW
StreamChannel.Instance outputFileChannelInstance=(StreamChannel.Instance)StreamChannel.DESCRIPTOR.createChannel(graphChiPageRankOperator.getOutput(),configuration).createInstance(graphChiExecutor,null,-1);//RW
}