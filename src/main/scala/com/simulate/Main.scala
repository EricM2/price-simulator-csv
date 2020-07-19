package com.simulate

import java.io.FileWriter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import scala.util.Random

object Main {
    val mapMonthNumDate = Map[Int,Int](1->32,1->29,3->31,4->30,5->31
    ,6->30,7->31,8->31,9->30,10->31,11->30,12->31)
  val mapDate2Data= Map[Int,String](1->"January",2->"Febuary",3->"March",4->"April",5->"May"
    ,6->"June",7->"July",8->"Agust",9->"September",10->"October",11->"November",12->"Dicember")
  val rndr = new Random()
  val items = List("sweater","short","tracksuit","socks")
  val sizes = List ("L","M","S")
  val colors = List ("black","white","blue")
  val brands = List ("nike","adidas","reebok")
    def main (args : Array[String])={
      generateDummyCSVForRandomMonth()
    }
    def generateDummyCSVForRandomMonth(): Unit ={
      val numMonth = rndr.nextInt(12) + 1
      val numDays = mapMonthNumDate(numMonth)
      for (numDay : Int <- 1.to(numDays)){
        val twoDigitDate = "%02d".format(numDay)
        val twoDigitMonth = "%02d".format(numMonth)
        val date = "2020"+twoDigitMonth+twoDigitDate
        val sb = new StringBuilder()
        val fileWriter = new FileWriter("C:\\Users\\HOLA\\Documents\\prices_results\\sales_"+date+".csv")
         items.map( it=> {
           sizes.map( s => {
             colors.map(col => {
               brands.map(brand => {
                    val numItemSelled = rndr.nextInt(10)
                    for ( j : Int <- 1.to(numItemSelled)){

                      val price = it match {
                        case "short"=> getShortPrice(brand,col,s)
                        case "tracksuit" => getTracksuitPrice(brand,col,s)
                        case "sweater" => getSweaterPrice(brand,col,s)
                        case "socks" => getSocksPrice(brand,col,s)
                      }
                      val csvLine = date+";"+it+";"+brand+";"+col+";"+s+";"+price+"\n"
                      print(csvLine)
                      fileWriter.write(csvLine)
                    }

               })
             })
           })
         })
        // WRITE FILE


      }

    }

  def getShortPrice (brand: String, color: String, size : String): Double={
    brand match {
      case "adidas" =>{
        color match {
          case "black" =>{
            size match {
              case "S" =>{
                20d
              }
              case "L" =>{
                25d
              }
              case "M" =>{
                30d
              }
            }
          }
          case "white" =>{
            size match {
              case "S" =>{
                15d
              }
              case "L" =>{
                20d
              }
              case "M" =>{
                25d
              }
            }
          }
          case "blue" =>{
            size match {
              case "S" =>{
                10d
              }
              case "L" =>{
                15d
              }
              case "M" =>{
                20d
              }
            }
          }
        }
      }
      case "nike" =>{
        color match {
          case "black" =>{
            size match {
              case "S" =>{
                30d
              }
              case "L" =>{
                31d
              }
              case "M" =>{
                33d
              }
            }
          }
          case "white" =>{
            size match {
              case "S" =>{
                18d
              }
              case "L" =>{
                22d
              }
              case "M" =>{
                25d
              }
            }
          }
          case "blue" =>{
            size match {
              case "S" =>{
                11d
              }
              case "L" =>{
                19d
              }
              case "M" =>{
                23d
              }
            }
          }
        }
      }
      case "reebok" =>{
        color match {
          case "black" =>{
            size match {
              case "S" =>{
                10d
              }
              case "L" =>{
                13d
              }
              case "M" =>{
                20d
              }
            }
          }
          case "white" =>{
            size match {
              case "S" =>{
                13d
              }
              case "L" =>{
                17d
              }
              case "M" =>{
                21d
              }
            }
          }
          case "blue" =>{
            size match {
              case "S" =>{
                7d
              }
              case "L" =>{
                13d
              }
              case "M" =>{
                19d
              }
            }
          }
        }
      }

    }
  }
  def getSocksPrice (brand: String, color: String, size : String): Double={
    brand match {
      case "adidas" =>{
        color match {
          case "black" =>{
            size match {
              case "S" =>{
                7d
              }
              case "L" =>{
                9d
              }
              case "M" =>{
                11d
              }
            }
          }
          case "white" =>{
            size match {
              case "S" =>{
                5d
              }
              case "L" =>{
                8d
              }
              case "M" =>{
                10d
              }
            }
          }
          case "blue" =>{
            size match {
              case "S" =>{
                3d
              }
              case "L" =>{
                5d
              }
              case "M" =>{
                7d
              }
            }
          }
        }
      }
      case "nike" =>{
        color match {
          case "black" =>{
            size match {
              case "S" =>{
                9d
              }
              case "L" =>{
                11d
              }
              case "M" =>{
                13d
              }
            }
          }
          case "white" =>{
            size match {
              case "S" =>{
                7d
              }
              case "L" =>{
                9d
              }
              case "M" =>{
                11d
              }
            }
          }
          case "blue" =>{
            size match {
              case "S" =>{
                6d
              }
              case "L" =>{
                8d
              }
              case "M" =>{
                10d
              }
            }
          }
        }
      }
      case "reebok" =>{
        color match {
          case "black" =>{
            size match {
              case "S" =>{
                3d
              }
              case "L" =>{
                6d
              }
              case "M" =>{
                7d
              }
            }
          }
          case "white" =>{
            size match {
              case "S" =>{
                2.50d
              }
              case "L" =>{
                3d
              }
              case "M" =>{
                4.50d
              }
            }
          }
          case "blue" =>{
            size match {
              case "S" =>{
                1.99d
              }
              case "L" =>{
                2.90d
              }
              case "M" =>{
                3.30d
              }
            }
          }
        }
      }

    }
  }
  def getSweaterPrice (brand: String, color: String, size : String): Double={
    brand match {
      case "adidas" =>{
        color match {
          case "black" =>{
            size match {
              case "S" =>{
                22d
              }
              case "L" =>{
                26d
              }
              case "M" =>{
                29d
              }
            }
          }
          case "white" =>{
            size match {
              case "S" =>{
                20d
              }
              case "L" =>{
                23d
              }
              case "M" =>{
                27d
              }
            }
          }
          case "blue" =>{
            size match {
              case "S" =>{
                17d
              }
              case "L" =>{
                19d
              }
              case "M" =>{
                23d
              }
            }
          }
        }
      }
      case "nike" =>{
        color match {
          case "black" =>{
            size match {
              case "S" =>{
                23d
              }
              case "L" =>{
                27d
              }
              case "M" =>{
                30d
              }
            }
          }
          case "white" =>{
            size match {
              case "S" =>{
                22d
              }
              case "L" =>{
                25d
              }
              case "M" =>{
                29d
              }
            }
          }
          case "blue" =>{
            size match {
              case "S" =>{
                13d
              }
              case "L" =>{
                19d
              }
              case "M" =>{
                21d
              }
            }
          }
        }
      }
      case "reebok" =>{
        color match {
          case "black" =>{
            size match {
              case "S" =>{
                13d
              }
              case "L" =>{
                15d
              }
              case "M" =>{
                19d
              }
            }
          }
          case "white" =>{
            size match {
              case "S" =>{
                11d
              }
              case "L" =>{
                11.70d
              }
              case "M" =>{
                13d
              }
            }
          }
          case "blue" =>{
            size match {
              case "S" =>{
                9d
              }
              case "L" =>{
                11d
              }
              case "M" =>{
                12.50d
              }
            }
          }
        }
      }

    }
  }
  def getTracksuitPrice (brand: String, color: String, size : String): Double={
    brand match {
      case "adidas" =>{
        color match {
          case "black" =>{
            size match {
              case "S" =>{
                45d
              }
              case "L" =>{
                58d
              }
              case "M" =>{
                60d
              }
            }
          }
          case "white" =>{
            size match {
              case "S" =>{
                43d
              }
              case "L" =>{
                50d
              }
              case "M" =>{
                55d
              }
            }
          }
          case "blue" =>{
            size match {
              case "S" =>{
                32d
              }
              case "L" =>{
                40d
              }
              case "M" =>{
                43d
              }
            }
          }
        }
      }
      case "nike" =>{
        color match {
          case "black" =>{
            size match {
              case "S" =>{
                60d
              }
              case "L" =>{
                68d
              }
              case "M" =>{
                70d
              }
            }
          }
          case "white" =>{
            size match {
              case "S" =>{
                54d
              }
              case "L" =>{
                65d
              }
              case "M" =>{
                69d
              }
            }
          }
          case "blue" =>{
            size match {
              case "S" =>{
                35d
              }
              case "L" =>{
                40d
              }
              case "M" =>{
                50d
              }
            }
          }
        }
      }
      case "reebok" =>{
        color match {
          case "black" =>{
            size match {
              case "S" =>{
                33d
              }
              case "L" =>{
                37d
              }
              case "M" =>{
                41d
              }
            }
          }
          case "white" =>{
            size match {
              case "S" =>{
                30d
              }
              case "L" =>{
                35d
              }
              case "M" =>{
                39d
              }
            }
          }
          case "blue" =>{
            size match {
              case "S" =>{
                21d
              }
              case "L" =>{
                25d
              }
              case "M" =>{
                27d
              }
            }
          }
        }
      }

    }
  }

}
