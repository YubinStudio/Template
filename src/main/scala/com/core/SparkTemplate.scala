package com.core

import com.esotericsoftware.kryo.Kryo
import org.apache.spark.serializer.KryoRegistrator

//实现kryo序列化
class SparkTemplate extends KryoRegistrator {
  override def registerClasses(kryo: Kryo): Unit = {
    kryo.register(classOf[SparkJob])
  }
}
