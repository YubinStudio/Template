package com

import com.core.{SparkJob, SparkTemplate}
import org.apache.spark.sql.SparkSession

//启动的任务入口函数 Main
object SparkDemoMain extends App {
  val session = SparkSession.builder().appName("data-template").enableHiveSupport().getOrCreate()
  session.sparkContext.getConf.registerKryoClasses(Array(classOf[SparkTemplate]))
  //  session.sparkContext.getConf.setJars(List("/root/javajars/"))
  val executor = Class.forName(args(0)).newInstance().asInstanceOf[SparkJob]
  executor.setArgs(args)
  executor.setSession(session)
  executor.execute
}
