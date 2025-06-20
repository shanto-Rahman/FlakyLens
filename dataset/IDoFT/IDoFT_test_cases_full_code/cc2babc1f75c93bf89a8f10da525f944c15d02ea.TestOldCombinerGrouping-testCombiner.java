@Test public void testCombiner() throws Exception {
  if (!new File(TEST_ROOT_DIR).mkdirs()) {
    throw new RuntimeException("Could not create test dir: " + TEST_ROOT_DIR);
  }
  File in=new File(TEST_ROOT_DIR,"input");
  if (!in.mkdirs()) {
    throw new RuntimeException("Could not create test dir: " + in);
  }
  File out=new File(TEST_ROOT_DIR,"output");
  PrintWriter pw=new PrintWriter(new FileWriter(new File(in,"data.txt")));
  pw.println("A|a,1");
  pw.println("A|b,2");
  pw.println("B|a,3");
  pw.println("B|b,4");
  pw.println("B|c,5");
  pw.close();
  JobConf job=new JobConf();
  job.set("mapreduce.framework.name","local");
  TextInputFormat.setInputPaths(job,new Path(in.getPath()));
  TextOutputFormat.setOutputPath(job,new Path(out.getPath()));
  job.setMapperClass(Map.class);
  job.setReducerClass(Reduce.class);
  job.setInputFormat(TextInputFormat.class);
  job.setMapOutputKeyClass(Text.class);
  job.setMapOutputValueClass(LongWritable.class);
  job.setOutputFormat(TextOutputFormat.class);
  job.setOutputValueGroupingComparator(GroupComparator.class);
  job.setCombinerClass(Combiner.class);
  job.setCombinerKeyGroupingComparator(GroupComparator.class);
  job.setInt("min.num.spills.for.combine",0);
  JobClient client=new JobClient(job);
  RunningJob runningJob=client.submitJob(job);
  runningJob.waitForCompletion();
  if (runningJob.isSuccessful()) {
    Counters counters=runningJob.getCounters();
    long combinerInputRecords=counters.getGroup("org.apache.hadoop.mapreduce.TaskCounter").getCounter("COMBINE_INPUT_RECORDS");
    long combinerOutputRecords=counters.getGroup("org.apache.hadoop.mapreduce.TaskCounter").getCounter("COMBINE_OUTPUT_RECORDS");
    Assert.assertTrue(combinerInputRecords > 0);
    Assert.assertTrue(combinerInputRecords > combinerOutputRecords);
    BufferedReader br=new BufferedReader(new FileReader(new File(out,"part-00000")));
    Set<String> output=new HashSet<String>();
    String line=br.readLine();
    Assert.assertNotNull(line);
    output.add(line.substring(0,1) + line.substring(4,5));
    line=br.readLine();
    Assert.assertNotNull(line);
    output.add(line.substring(0,1) + line.substring(4,5));
    line=br.readLine();
    Assert.assertNull(line);
    br.close();
    Set<String> expected=new HashSet<String>();
    expected.add("A2");
    expected.add("B5");
    Assert.assertEquals(expected,output);
  }
 else {
    Assert.fail("Job failed");
  }
}
