@Test public void testShowTimeseries(){
  InterpreterResult actual=interpreter.internalInterpret("show timeseries",null);
  String gt="timeseries\talias\tstorage group\tdataType\tencoding\tcompression\ttags\tattributes\n" + "root.test.wf02.wt02.temperature\tnull\troot.test.wf02\tFLOAT\tGORILLA\tSNAPPY\tnull\tnull\n" + "root.test.wf02.wt02.status\tnull\troot.test.wf02\tBOOLEAN\tRLE\tSNAPPY\tnull\tnull\n"+ "root.test.wf02.wt02.hardware\tnull\troot.test.wf02\tFLOAT\tGORILLA\tSNAPPY\tnull\tnull\n"+ "root.test.wf01.wt01.temperature\tnull\troot.test.wf01\tFLOAT\tGORILLA\tSNAPPY\tnull\tnull\n"+ "root.test.wf01.wt01.status\tnull\troot.test.wf01\tBOOLEAN\tRLE\tSNAPPY\tnull\tnull\n"+ "root.test.wf01.wt01.hardware\tnull\troot.test.wf01\tFLOAT\tGORILLA\tSNAPPY\tnull\tnull";
  Assert.assertNotNull(actual);
  Assert.assertEquals(Code.SUCCESS,actual.code());
  Assert.assertEquals(gt,actual.message().get(0).getData());
}
