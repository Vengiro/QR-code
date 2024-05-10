import scala.compiletime.ops.double
package src

class Qr(val message: String, val size: Int):

    type qrcode = Array[color]

    enum color(val value: Int):
        case black extends color(255)
        case white extends color(0)

    


    def fill_fixe_modules(): qrcode =
        val qr = Array.fill(size * size)(color.white)

        val line = (0 to 6).toList
        val blacklines = 
            line
            ::: line.map(_ + size - 7)
            ::: line.map(_ + 6 * size)
            ::: line.map(_ + 7 * size - 7)
            ::: line.map(_ + (size - 7) * size)
            ::: line.map(_ + (size - 1) * size)
        
        val row =  (1 to 5).toList
        val blackrows = 
            row.map(_ * size)
            ::: row.map(_ * size + 6)
            ::: row.map(_ * size + size - 7)
            ::: row.map(_ * size + size - 1)
            ::: row.map((_ + (size - 7)) * size)
            ::: row.map((_ + (size - 7)) * size + 6)
        
        val square = 
            (2 to 4).toList
            ::: (2 to 4).toList.map(_ + size)
            ::: (2 to 4).toList.map(_ + 2 * size)
        
        val allsquares = 
            square
            ::: square.map(_ + (size - 7))
            ::: square.map(_ + (size - 7) * size)
        
        val lined = (1 to ((size - 16 + 1)/2)).toList.map(_ * 2 + 6 + size * 6)
        val allalternates = 
            ((size - 8) * size + 8 :: lined)
            ::: lined.map(_ * size + 6)

        val all = blacklines ::: blackrows ::: allsquares ::: allalternates

        for i <- all do
            qr(i) = color.black

        qr
        
    def printall(qr: qrcode): Unit =
        qr.grouped(size).foreach(el => el.foreach(e => print(if e == color.black then "X" else " ")) + println())

      
    
