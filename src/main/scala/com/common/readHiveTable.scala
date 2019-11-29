package com.common

import com.core.SparkJob
import com.utils.{DataTool, TableInfo}
import org.apache.spark.sql.{DataFrame, SaveMode}

/**
  * @ Description   :  java类作用描述
  * @ Author        :  jyb
  * @ CreateDate    :  2019/8/19$ 11:01$
  * @ UpdateUser    :  jyb
  * @ UpdateDate    :  2019/8/19$ 11:01$
  * @ UpdateRemark  :  修改内容
  * @ Version       :  1.0
  */
class readHiveTable extends SparkJob with DataTool {

  override def execute: Unit = {
    val args = getArgs
    val spark = getSession
    val dp = getNow("yyyyMMdd")

    val frame: DataFrame = spark.sql(TableInfo.test)
//    frame.repartition(1).toDF().write.mode(SaveMode.Append).insertInto("tableName")
    //改option
    frame.repartition(1).toDF().write.mode(SaveMode.Append).option("delimiter","€€").save("hdfsPath")
    //spark停止
    spark.stop()
  }
}
/*object test {
  def main(args: Array[String]): Unit = {
    val t = new test
    val ti = t.getNow("yyyy/MM/dd HH:mm:ss")
    val g = t.getCPH("342")
    println(ti + " , " + g.apply(0))
  }
}*/
