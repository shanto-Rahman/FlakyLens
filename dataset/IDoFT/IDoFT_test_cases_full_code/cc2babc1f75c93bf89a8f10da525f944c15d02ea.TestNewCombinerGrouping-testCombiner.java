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
  JobConf conf=new JobConf();
  conf.set("mapreduce.framework.name","local");
  Job job=new Job(conf);
  TextInputFormat.setInputPaths(job,new Path(in.getPath()));
  TextOutputFormat.setOutputPath(job,new Path(out.getPath()));
  job.setMapperClass(Map.class);
  job.setReducerClass(Reduce.class);
  job.setInputFormatClass(TextInputFormat.class);
  job.setMapOutputKeyClass(Text.class);
  job.setMapOutputValueClass(LongWritable.class);
  job.setOutputFormatClass(TextOutputFormat.class);
  job.setGroupingComparatorClass(GroupComparator.class);
  job.setCombinerKeyGroupingComparatorClass(GroupComparator.class);
  job.setCombinerClass(Combiner.class);
  job.getConfiguration().setInt("min.num.spills.for.combine",0);
  job.submit();
  job.waitForCompletion(false);
  if (job.isSuccessful()) {
    Counters counters=job.getCounters();
    long combinerInputRecords=counters.findCounter("org.apache.hadoop.mapreduce.TaskCounter","COMBINE_INPUT_RECORDS").getValue();
    long combinerOutputRecords=counters.findCounter("org.apache.hadoop.mapreduce.TaskCounter","COMBINE_OUTPUT_RECORDS").getValue();
    Assert.assertTrue(combinerInputRecords > 0);
    Assert.assertTrue(combinerInputRecords > combinerOutputRecords);
    BufferedReader br=new BufferedReader(new FileReader(new File(out,"part-r-00000")));
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
