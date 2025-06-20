@Test public void parseMemorySizeTest(){
Assert.assertEquals(k / 10,CommonUtils.parseMemorySize(k / 10.0 + "b"));
Assert.assertEquals(k / 10,CommonUtils.parseMemorySize(k / 10.0 + "B"));
Assert.assertEquals(k / 10,CommonUtils.parseMemorySize(k / 10.0 + ""));
Assert.assertEquals(k * Constants.KB / 10,CommonUtils.parseMemorySize(k / 10.0 + "kb"));
Assert.assertEquals(k * Constants.KB / 10,CommonUtils.parseMemorySize(k / 10.0 + "Kb"));
Assert.assertEquals(k * Constants.KB / 10,CommonUtils.parseMemorySize(k / 10.0 + "KB"));
Assert.assertEquals(k * Constants.KB / 10,CommonUtils.parseMemorySize(k / 10.0 + "kB"));
Assert.assertEquals(k * Constants.MB / 10,CommonUtils.parseMemorySize(k / 10.0 + "mb"));
Assert.assertEquals(k * Constants.MB / 10,CommonUtils.parseMemorySize(k / 10.0 + "Mb"));
Assert.assertEquals(k * Constants.MB / 10,CommonUtils.parseMemorySize(k / 10.0 + "MB"));
Assert.assertEquals(k * Constants.MB / 10,CommonUtils.parseMemorySize(k / 10.0 + "mB"));
Assert.assertEquals(k * Constants.GB / 10,CommonUtils.parseMemorySize(k / 10.0 + "gb"));
Assert.assertEquals(k * Constants.GB / 10,CommonUtils.parseMemorySize(k / 10.0 + "Gb"));
Assert.assertEquals(k * Constants.GB / 10,CommonUtils.parseMemorySize(k / 10.0 + "GB"));
Assert.assertEquals(k * Constants.GB / 10,CommonUtils.parseMemorySize(k / 10.0 + "gB"));
Assert.assertEquals(k * Constants.TB / 10,CommonUtils.parseMemorySize(k / 10.0 + "tb"));
Assert.assertEquals(k * Constants.TB / 10,CommonUtils.parseMemorySize(k / 10.0 + "Tb"));
Assert.assertEquals(k * Constants.TB / 10,CommonUtils.parseMemorySize(k / 10.0 + "TB"));
Assert.assertEquals(k * Constants.TB / 10,CommonUtils.parseMemorySize(k / 10.0 + "tB"));
}