package code.snippet

import scala.xml.NodeSeq


import net.liftweb.common._
import net.liftweb.http.S

import net.liftmodules.jqplot._

//<span class="lift:LineGraphExample?w=512;h=384"></span>
object LineGraphExample extends PlotSnippet {
  
    val seriesA = List((1, 1),(2,2),(3,4),(4,8),(5,16),(6,32),(7,64))
    val seriesB = List((64, 1),(32,2),(16,3),(8,4),(4,5),(2,6),(1,7))
    
    override val series:Array[List[List[Any]]]  = Array(seriesA,seriesB)
          
    override val options =  Full(Options().title("Line graph"))
  
}
class Dates extends PlotSnippet  {
  import java.util.Calendar

    val c = Calendar.getInstance()
    val now = c.getTime
     c.add(Calendar.DATE,-1)
    val then = c.getTime
    c.add(Calendar.DATE,2)
    val soon = c.getTime
    
   override val series:Array[List[List[Any]]] = Array(List((now,0.0), (then,-1.0), (soon,1.0)))
 
   val x = Axis().renderer(DateAxisRenderer())
   val s = Series().lineWidth(4).markerOptions(MarkerOption().style(square()))
   override val options = Full(Options().title("Date objects").axes(Axes().xaxis(x)).seriesDefault(s))
     
   
}

object Pie extends PlotSnippet  {
  
    override  val series:Array[List[List[Any]]] = Array(List(("Heavy Industry", 12),("Retail", 9), ("Light Industry", 14),("Out of home", 16),("Commuting", 7), ("Orientation", 9)))

    override  val options = Full(Options().title("Pie Chart").seriesDefault(Series().renderer(PieRenderer())).legend(Legend().location(EA()).show))
    
   
}
object Bar extends PlotSnippet  {

   val seriesA = List((2,1), (4,2), (6,3), (3,4))
   val seriesB = List((5,1), (1,2), (3,3), (4,4))
   val seriesC = List((4,1), (7,2), (1,3), (2,4))
   
   override val series:Array[List[List[Any]]] = Array(seriesA,seriesB,seriesC)
   
   override  val options = Full(Options().title("Bar chart").seriesDefault(Series().renderer(BarRenderer()).shadowAngle(135)).axes(Axes().yaxis(Axis().renderer(CategoryAxisRenderer()))))
   
    
}
object Bubbles extends PlotSnippet  {

   override val series:Array[List[List[Any]]] = Array(List(List(11, 123, 1236, "Acura"), List(45, 92, 1067, "Alfa Romeo"),List(24, 104, 1176, "AM General"), List(50, 23, 610, "Aston Martin Lagonda"),List(18, 17, 539, "Audi"), List(7, 89, 864, "BMW"), List(2, 13, 1026, "Bugatti")))

   override  val options = Full(Options().title("Bubble Chart").seriesDefault(Series().renderer(BubbleRenderer())))
 
}
object  OHLC  extends PlotSnippet {

   override val series:Array[List[List[Any]]]  = Array(List(List("06/15/2009 16:00:00", 136.01, 139.5, 134.53, 139.48),List("06/08/2009 16:00:00", 143.82, 144.56, 136.04, 136.97),List("06/01/2009 16:00:00", 136.47, 146.4, 136.0, 144.67),List("05/26/2009 16:00:00", 124.76, 135.9, 124.55, 135.81)))
   
   override  val options = Full(Options().title("OHLC").axes(
      Axes().xaxis(Axis().renderer(DateAxisRenderer()))).
      series(List(Series().renderer(OHLCRenderer()))))
   
}
object Cosine extends PlotSnippet  {
  
   import scala.math._    
    
   val v = 0D to 2*Pi by 0.1
   override val series:Array[List[List[Any]]] = Array(for { i <- v.toList } yield {(i,cos(i))})
   
   override val options = Full(Options().title("Cosine").axes(Axes().xaxis(Axis().label("Angle (radians)")).
		   											   yaxis(Axis().label("Cosine"))))
}



 
 
    
     