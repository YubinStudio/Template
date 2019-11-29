package com.core

import org.apache.spark.sql.SparkSession

abstract class SparkJob {
  private var _session: SparkSession = null
  private var _args = Array[String]()

  def getSession = _session

  def setSession(session: SparkSession) = {
    _session = session
  }

  def getArgs = _args

  def setArgs(args: Array[String]) = {
    _args = args
  }

  def execute
}
