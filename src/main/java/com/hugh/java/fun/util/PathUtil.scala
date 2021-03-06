package com.hugh.java.fun.util

/**
 * @Author Fly.Hugh
 * @Date 2020/3/25 11:40
 * @Version 2.0
 *
 **/
object PathUtil {
  def main(args: Array[String]): Unit = {
    val str: String = pathGet("ARecordofaMortal'sJourneytoImmortality.txt")
    println(str)
  }

  // relative path
  def pathGet():String = {
    getPath("")
  }

  def pathGet(file:String):String = {
    getPath(file)
  }

  // entering name of file in Resources floder,get absolute path
  def getPath(filePath:String):String = {
    if (filePath == "") {
      println("请输入Resources文件夹内文件名 或者 工程目录下的相对路径")
    }

    var str: String = ""
    val arrRelative: Array[String] = filePath.split("/")
    val p = this.getClass.getClassLoader.getResource(arrRelative(arrRelative.length - 1))
    val arr: Array[String] = p.toString.split("/")
    for (i <- 1 to arr.length - 4) {
        str = str + arr(i) + "/"
    }
    str = str + "src/" + "main/" + "resources/" + arrRelative(arrRelative.length - 1)
    val pathArr = str.split("%20")
    str = ""
    for (j <- 0 to pathArr.length - 1) {
      str = str + pathArr(j) + " "
    }
    str = "/" + str.trim // 为了适应mac的系统特性 加上了 /
  str
  }
}