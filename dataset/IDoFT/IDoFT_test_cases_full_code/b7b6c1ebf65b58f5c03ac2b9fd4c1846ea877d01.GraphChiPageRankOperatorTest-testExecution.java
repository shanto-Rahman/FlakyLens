@Test public void testExecution() throws IOException {
  GraphChiPlatform.getInstance();
  final Configuration configuration=new Configuration();
  GraphChi.plugin().configure(configuration);
  final GraphChiPageRankOperator graphChiPageRankOperator=new GraphChiPageRankOperator(20);
  final Job job=mock(Job.class);
  when(job.getConfiguration()).thenReturn(configuration);
  when(job.getCrossPlatformExecutor()).thenReturn(new CrossPlatformExecutor(job,new FullInstrumentationStrategy()));
  final ExecutionOperator outputOperator=mock(ExecutionOperator.class);
  when(outputOperator.getNumOutputs()).thenReturn(1);
  FileChannel.Instance inputChannelInstance=(FileChannel.Instance)new FileChannel(FileChannel.HDFS_TSV_DESCRIPTOR).createInstance(graphChiExecutor,null,-1);
  inputChannelInstance.addPath(this.getClass().getResource("/test.edgelist.input").toString());
  inputChannelInstance.getLineage().collectAndMark();
  final ExecutionOperator inputOperator=mock(ExecutionOperator.class);
  when(inputOperator.getNumOutputs()).thenReturn(1);
  StreamChannel.Instance outputFileChannelInstance=(StreamChannel.Instance)StreamChannel.DESCRIPTOR.createChannel(graphChiPageRankOperator.getOutput(),configuration).createInstance(graphChiExecutor,null,-1);
  final DefaultOptimizationContext optimizationContext=new DefaultOptimizationContext(job);
  final OptimizationContext.OperatorContext operatorContext=optimizationContext.addOneTimeOperator(graphChiPageRankOperator);
  graphChiPageRankOperator.execute(new ChannelInstance[]{inputChannelInstance},new ChannelInstance[]{outputFileChannelInstance},operatorContext);
}
