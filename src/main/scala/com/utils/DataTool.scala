package com.utils

import java.text.SimpleDateFormat
import java.util.Date

import scala.collection.mutable.ListBuffer

/**
  * @ Description   :  对数据进行一些转换操作的特质
  * @ Author        :  jyb
  * @ CreateDate    :  2019/8/19$ 10:56$
  * @ UpdateUser    :  jyb
  * @ UpdateDate    :  2019/8/19$ 10:56$
  * @ UpdateRemark  :  修改内容
  * @ Version       :  1.0
  */
trait DataTool {
  /**
    * 获取到当前时间
    *
    * @param timeTem 参数的日期格式  yyyyMMdd yyyyMMddHHmmss
    * @return 当前日期字符串
    */
  def getNow(timeTem: String) = {
    val date = new Date()
    val pattern = new SimpleDateFormat(timeTem)
    pattern.format(date)
  }

  def getCPH(str: String)= {
    /*if (str == null) {
      str=""
    }*/
    val regx = """[\d]+""".r
    val result = regx.findAllMatchIn(str)
    val list = ListBuffer[String]()
    for (it <- result) {
      list += it.toString()
    }
    list
  }
}
